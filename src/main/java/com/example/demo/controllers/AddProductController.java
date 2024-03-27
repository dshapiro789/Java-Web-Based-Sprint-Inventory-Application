package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddProductController {
    @Autowired
    private ApplicationContext context;
    private PartService partService;
    private static Product product1;
    private Product product;


    @GetMapping("/showFormAddProduct")
    public String showFormAddPart(Model theModel) {
        theModel.addAttribute("parts", partService.findAll());
        product = new Product();
        product1=product;
        theModel.addAttribute("product", product);

        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!product.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        theModel.addAttribute("assparts",product.getParts());
        return "productForm";
    }

    @PostMapping("/showFormAddProduct")
    public String submitForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product existingProduct = null;

        // Only try to find the existing product if the ID is not 0 (which means it's not a new product)
        if (product.getId() != 0) {
            existingProduct = productService.findById((int) product.getId());
        }

        // Validate product inventory does not exceed max limit
        if (product.getInv() > 10000) {
            bindingResult.rejectValue("inv", "error.inv", "Inventory must not exceed 10000 units.");
        }

        // Validate that updating product inventory won't cause part inventory to fall below minimum
        if (existingProduct != null) {
            validatePartInventories(product, existingProduct, bindingResult);
        }

        // If there are errors after validations, return to the form with error messages
        if (bindingResult.hasErrors()) {
            setupModelForForm(theModel, partService, existingProduct != null ? existingProduct : product);
            return "productForm";
        }

        // Persist the product with the manual inventory input
        productService.save(product);

        return "confirmationaddproduct";
    }

    private void validatePartInventories(Product product, Product existingProduct, BindingResult bindingResult) {
        if (existingProduct != null) {
            for (Part part : existingProduct.getParts()) {
                int updatedInventory = part.getInv() - (product.getInv() - existingProduct.getInv());
                if (updatedInventory < part.getMinInv()) {
                    String errorMessage = String.format(
                            "Not enough inventory for part: %s. Minimum required is %d, but would be %d.",
                            part.getName(), part.getMinInv(), updatedInventory
                    );
                    bindingResult.rejectValue("inv", "error.inv.low", errorMessage);
                    // Break the loop since we found an error, no need to continue
                    break;
                }
            }
        }
    }


    private void setupModelForForm(Model theModel, PartService partService, Product existingProduct) {
        theModel.addAttribute("product", existingProduct);
        List<Part> availableParts = new ArrayList<>();
        for (Part part : partService.findAll()) {
            if (!existingProduct.getParts().contains(part)) {
                availableParts.add(part);
            }
        }
        theModel.addAttribute("availparts", availableParts);
        theModel.addAttribute("assparts", existingProduct.getParts());
    }

    private void updateProductAndParts(Product product, Product existingProduct, ProductService productService) {
        if (existingProduct != null) {
            int inventoryDifference = product.getInv() - existingProduct.getInv();
            // Only update part inventories if there's an increase in product inventory
            if (inventoryDifference > 0) {
                PartService partService1 = context.getBean(PartServiceImpl.class);
                for (Part p : existingProduct.getParts()) {
                    int inv = p.getInv();
                    // Only reduce the part's inventory if the new inventory would not go below minimum
                    int newInventory = inv - inventoryDifference;
                    if (newInventory >= p.getMinInv()) {
                        p.setInv(newInventory);
                        partService1.save(p);
                    } else {
                        // If it goes below the minimum, you should not proceed and handle this as an error
                        // However, this should have been caught during the validation step.
                        // Throw an exception or handle this case as needed.
                    }
                }
            }
        } else {
            product.setInv(0);
        }
        productService.save(product);
    }


    @GetMapping("/showProductFormForUpdate")
    public String showProductFormForUpdate(@RequestParam("productID") int theId, Model theModel) {
        theModel.addAttribute("parts", partService.findAll());
        ProductService repo = context.getBean(ProductServiceImpl.class);
        Product theProduct = repo.findById(theId);
        product1=theProduct;
    //    this.product=product;
        //set the employ as a model attibute to prepopulate the form
        theModel.addAttribute("product", theProduct);
        theModel.addAttribute("assparts",theProduct.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!theProduct.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        //send over to our form
        return "productForm";
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct(@RequestParam("productID") int theId, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product2=productService.findById(theId);
        for(Part part:product2.getParts()){
            part.getProducts().remove(product2);
            partService.save(part);
        }
        product2.getParts().removeAll(product2.getParts());
        productService.save(product2);
        productService.deleteById(theId);

        return "confirmationdeleteproduct";
    }

    public AddProductController(PartService partService) {
        this.partService = partService;
    }
// make the add and remove buttons work

    @GetMapping("/associatepart")
    public String associatePart(@Valid @RequestParam("partID") int theID, Model theModel){
    //    theModel.addAttribute("product", product);
    //    Product product1=new Product();
        if (product1.getName()==null) {
            return "saveproductscreen";
        }
        else{
        product1.getParts().add(partService.findById(theID));
        partService.findById(theID).getProducts().add(product1);
        ProductService productService = context.getBean(ProductServiceImpl.class);
        productService.save(product1);
        partService.save(partService.findById(theID));
        theModel.addAttribute("product", product1);
        theModel.addAttribute("assparts",product1.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!product1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "productForm";}
 //        return "confirmationassocpart";
    }
    @GetMapping("/removepart")
    public String removePart(@RequestParam("partID") int theID, Model theModel){
        theModel.addAttribute("product", product);
      //  Product product1=new Product();
        product1.getParts().remove(partService.findById(theID));
        partService.findById(theID).getProducts().remove(product1);
        ProductService productService = context.getBean(ProductServiceImpl.class);
        productService.save(product1);
        partService.save(partService.findById(theID));
        theModel.addAttribute("product", product1);
        theModel.addAttribute("assparts",product1.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!product1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "productForm";
    }
}
