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
            // Adding specific parts, price and inventory
            Part graphicsCard = new Part("Graphics Card", 750, 100);
            partRepository.save(graphicsCard);

            Part ram = new Part("RAM", 200, 100);
            partRepository.save(ram);

            Part motherboard = new Part("Motherboard", 900, 100);
            partRepository.save(motherboard);

            Part keyboard = new Part("Keyboard", 75, 200);
            partRepository.save(keyboard);

            Part mouse = new Part("Mouse", 60, 200);
            partRepository.save(mouse);
        }

        // Checks if there are no products in the repository before adding new ones
        if (productRepository.count() == 0) {
            // Adding specific products, price and inventory
            Product appleComputer = new Product("Apple Computer", 2000, 100);
            productRepository.save(appleComputer);

            Product windowsComputer = new Product("Windows Computer", 1500, 100);
            productRepository.save(windowsComputer);

            Product linuxComputer = new Product("Linux Computer", 2500, 100);
            productRepository.save(linuxComputer);

            Product ubuntuComputer = new Product("Ubuntu Computer", 2500, 100);
            productRepository.save(ubuntuComputer);

            Product chromebookComputer = new Product("Chromebook Computer", 1000, 100);
            productRepository.save(chromebookComputer);
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
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
