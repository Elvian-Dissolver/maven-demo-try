package com.controllers;

import com.domain.User;
import com.models.StringProcessor;
import com.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.cassandra.core.query.Query.query;

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

    @GetMapping("/users")
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

    @PutMapping
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }

    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @GetMapping("/user/{age}")
    public List<User> getUserbyId(@PathVariable int age){
        List<User> users = this.userRepository.findByAgeLessThanEqual(age);

//        String name = users.get(0).getName();
//        String address = users.get(0).getAddress();
//        String ages = String.valueOf(users.get(0).getAge());
//
//        ArrayList<String> aList =  new ArrayList();
//        aList.addAll(Arrays.asList(name,address,ages));
        return users;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<User> remove(@PathVariable int id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
