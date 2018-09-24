package controllers;

import models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
    private ProductRepository productRepository;

        @Autowired
        public ProductController(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }
}
