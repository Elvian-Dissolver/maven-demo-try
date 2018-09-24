package models;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class UserSeeder implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public UserSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User Indra = new User(1, "Indra", "Jakarta", 24);
        User Elvian = new User(2,"Elvian", "Banten", 23);
        User Ahmad = new User(3, "Ahmad", "Demak", 20);

        List<User> users = new ArrayList();
        users.add(Indra);
        users.add(Elvian);
        users.add(Ahmad);
        this.userRepository.saveAll(users);
    }
}
