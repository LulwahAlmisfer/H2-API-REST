package com.example.repository;

import com.example.models.UserTable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
@Repository
public interface UserRepository  extends CrudRepository<UserTable, Integer> {
    List<UserTable> findAll();
}
