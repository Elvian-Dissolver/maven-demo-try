package models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ProductSeeder implements CommandLineRunner {
    private ProductRepository productRepository;

    @Autowired
    public ProductSeeder(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {


    }
}
