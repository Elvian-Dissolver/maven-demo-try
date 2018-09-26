package com.models;

import com.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository // bsa smua notasiny

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByAgeLessThan(int age);

    @Query("SELECT name, address, age FROM user WHERE id=?0")
    List<User> findByIdLessThan(int id);
}


