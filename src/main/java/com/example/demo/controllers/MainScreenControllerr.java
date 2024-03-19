package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
    private final PartService partService;
    private final ProductService productService;

    @Autowired
    public MainScreenControllerr(PartService partService, ProductService productService) {
        this.partService = partService;
        this.productService = productService;
    }


    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword) {
        //add to the sprig model
        List<Part> partList = partService.listAll(partkeyword);
        theModel.addAttribute("parts", partList);
        theModel.addAttribute("partkeyword", partkeyword);
        //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList = productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword", productkeyword);
        return "mainscreen";
    }

    @GetMapping("/About")
    public String About() {
        return "About";
    }


    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, Model model) {
        boolean success = productService.decrementInventory(productId);

        if (success) {
            model.addAttribute("message", "Product purchased successfully!");
            return "purchaseSuccessful";
        } else {
            model.addAttribute("message", "Product could not be purchased (out of stock or not found)!");
            return "purchaseError";
        }
    }
}
