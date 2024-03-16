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

            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("Dave's Discount Computer Parts");
            o.setName("Apple Computer");
            o.setInv(5);
            o.setPrice(200.0);
            o.setId(100L);
            outsourcedPartRepository.save(o);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Apple Computer")) thePart = part;
            }

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Dave's Discount Computer Parts");
            o2.setName("Windows Computer");
            o2.setInv(5);
            o2.setPrice(200.0);
            o2.setId(100L);
            outsourcedPartRepository.save(o2);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Windows Computer")) thePart = part;
            }

            OutsourcedPart o3 = new OutsourcedPart();
            o3.setCompanyName("Dave's Discount Computer Parts");
            o3.setName("Linux Computer");
            o3.setInv(5);
            o3.setPrice(250.0);
            o3.setId(100L);
            outsourcedPartRepository.save(o3);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Linux Computer")) thePart = part;
            }

            OutsourcedPart o4 = new OutsourcedPart();
            o4.setCompanyName("Dave's Discount Computer Parts");
            o4.setName("Ubuntu Computer");
            o4.setInv(5);
            o4.setPrice(250.0);
            o4.setId(100L);
            outsourcedPartRepository.save(o4);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Ubuntu Computer")) thePart = part;
            }

            OutsourcedPart o5 = new OutsourcedPart();
            o5.setCompanyName("Dave's Discount Computer Parts");
            o5.setName("Chromebook Computer");
            o5.setInv(5);
            o5.setPrice(100.0);
            o5.setId(100L);
            outsourcedPartRepository.save(o5);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Chromebook Computer")) thePart = part;
            }
        }

        System.out.println(thePart.getCompanyName());

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
