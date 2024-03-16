package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Checks if there are no parts in the repository before adding new ones
        if (partRepository.count() == 0) {

            OutsourcedPart o1 = new OutsourcedPart();
            o1.setCompanyName("Dave's Discount Computer Parts");
            o1.setName("RAM (16 GB)");
            o1.setInv(5);
            o1.setPrice(200);
            outsourcedPartRepository.save(o1);

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Dave's Discount Computer Parts");
            o2.setName("Graphics Card");
            o2.setInv(5);
            o2.setPrice(750);
            outsourcedPartRepository.save(o2);

            OutsourcedPart o3 = new OutsourcedPart();
            o3.setCompanyName("Dave's Discount Computer Parts");
            o3.setName("Motherboard");
            o3.setInv(5);
            o3.setPrice(900);
            outsourcedPartRepository.save(o3);

            OutsourcedPart o4 = new OutsourcedPart();
            o4.setCompanyName("Dave's Discount Computer Parts");
            o4.setName("Keyboard");
            o4.setInv(5);
            o4.setPrice(75);
            o4.setId(100L);
            outsourcedPartRepository.save(o4);

            OutsourcedPart o5 = new OutsourcedPart();
            o5.setCompanyName("Dave's Discount Computer Parts");
            o5.setName("Mouse");
            o5.setInv(5);
            o5.setPrice(60);
            outsourcedPartRepository.save(o5);
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        Product appleComputer = new Product("Apple Computer",2000.0,5);
        Product windowsComputer = new Product("Windows Computer",1500.0,5);
        Product linuxComputer = new Product("Linux Computer",2500.0,5);
        Product ubuntuComputer = new Product("Ubuntu Computer",2500.0,5);
        Product chromebookComputer = new Product("Chromebook Computer",1000.0,5);
        productRepository.save(appleComputer);
        productRepository.save(windowsComputer);
        productRepository.save(linuxComputer);
        productRepository.save(ubuntuComputer);
        productRepository.save(chromebookComputer);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
