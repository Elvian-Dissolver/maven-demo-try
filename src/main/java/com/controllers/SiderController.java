package com.controllers;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.domain.User;
import com.models.StringProcessor;
import com.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.cassandra.core.query.Query.query;

@RestController
public class SiderController {

    private UserRepository userRepository;

    @Autowired
    SiderController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return this.userRepository.findAll();

    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @GetMapping("/user/{age}")
    public List<User> getUserbyAge(@PathVariable int age){
        return this.userRepository.findByAgeLessThanEqual(age);

    }

    @GetMapping(value = "/delete/{id}")
    public List<User> remove(@PathVariable int id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
