package controllers;

import domain.Product;
import domain.User;
import models.ProductRepository;
import models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Qualifier
@RestController
public class SiderController {

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public SiderController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/listuser")
    public List<User> getAllUser() {
        List<User> users = this.userRepository.findAll();
        return this.userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        //List<User> users = this.userRepository.findAll();
        List<Product> products = this.productRepository.findAll();
        return products;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{age}", method = RequestMethod.GET)
    public List<User> getAffordable(@PathVariable int age) {
        //return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return userRepository.findByAgeLessThan(age);
    }
}
