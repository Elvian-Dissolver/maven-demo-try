package com.models;

import com.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository // bsa smua notasiny

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByAgeLessThan(int age);


}
