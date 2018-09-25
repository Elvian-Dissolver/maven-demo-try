package com.controllers;

import com.domain.User;
import com.models.StringProcessor;
import com.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiderController {

    private UserRepository userRepository;

    @Autowired
    SiderController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private StringProcessor stringProcessor;

    @GetMapping("/hello")
    public String hello() {
//        StringProcessor stringProcessor = new StringProcessor();
        return stringProcessor.process("oke");
    }

    @GetMapping("/listuser")
    public List<User> getAllUser() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

//    @GetMapping("/products")
//    public List<Product> getAllProduct() {
//        //List<User> users = this.userRepository.findAll();
//        List<Product> products = this.productRepository.findAll();
//        return products;
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @RequestMapping(value = "/affordable/{age}", method = RequestMethod.GET)
    public List<User> getAffordable(@PathVariable int age) {
        return userRepository.findByAgeLessThan(age);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<User> remove(@PathVariable int id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
