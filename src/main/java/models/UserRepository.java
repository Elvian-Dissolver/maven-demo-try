package models;

import domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByAgeLessThan(int age);
}
