package com.models;

import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //gk pke jga bsa
public class UserSeeder implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public UserSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
      User Indra = new User(4, "Indra2", "Jakarta", 24 );
//        User Elvian = new User(2,"Elvian", "Banten", 23);
//        User Ahmad = new User(3, "Ahmad", "Demak", 20);
//
        List<User> users = new ArrayList();
       users.add(Indra);
//        users.add(Elvian);
//        users.add(Ahmad);
        this.userRepository.saveAll(users);
    }
}
