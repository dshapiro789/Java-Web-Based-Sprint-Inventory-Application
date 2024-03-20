package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);
        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }

        // Checks if inventory is less than the minimum
        if (part.getInv() < part.getMinInv()) {
            theBindingResult.rejectValue("inv", "error.inv", "Inventory must not be less than the minimum required.");
            return "InhousePartForm";
        }

        // Checks if inventory exceeds the maximum
        if (part.getInv() > part.getMaxInv()) {
            theBindingResult.rejectValue("inv", "error.inv", "Inventory must not exceed the maximum allowed.");
            return "InhousePartForm";
        }

        else if (!part.isInventoryValid()) {
            // Logs the invalid inventory case
            System.out.println("Inventory is not valid. Inventory: " + part.getInv() + ", Min: " + part.getMinInv() + ", Max: " + part.getMaxInv());
            // Adds validation for the inventory level
            theBindingResult.rejectValue("inv", "error.inv", "Inventory must be between the minimum and maximum values.");
            return "InhousePartForm";
        }

        else{
        InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setProducts(ip.getProducts());
            repo.save(part);

        return "confirmationaddpart";}
    }

}
