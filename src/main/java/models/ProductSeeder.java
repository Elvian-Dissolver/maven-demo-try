package models;


import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class ProductSeeder implements CommandLineRunner {
    private ProductRepository productRepository;

    @Autowired
    public ProductSeeder(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product TheForce = new Product(1, "The Force", "The Force™ is strong with you. Channel it with the Special Edition Battle-Worn BB-8 and included Star Wars™ Force Band™ by Sphero. Like a Jedi Knight, you can control your BB-8™ App-Enabled Droid™ with just a wave of your hand and expand your abilities with Force Training.","/img/1-jlol_sp_ed_bb-8_sphero_force_band.jpg","100000" , 10);
        Product TheDarkSide = new Product(2,"The Dark Side", "The Dark Side is a very turbulent place. Sure they have cookies, but there are nooks and crannies in which darkness reigns so supreme, if you merely enter, you're likely to stub your toe.","/img/ilhi_3d_sw_kylo_ren.gif","150000" ,7);
        Product LightSaber = new Product(3, "Light Saber","You would think a light source based off something that literally has the word light in the name would be inevitable. You were right, but we didn't just want any old light source.","/img/itjp_sw_standing_lightsaber_lamp.gif", "200000", 8);

        List<Product> products = new ArrayList();
        products.add(TheForce);
        products.add(TheDarkSide);
        products.add(LightSaber);
        this.productRepository.saveAll(products);

    }
}
