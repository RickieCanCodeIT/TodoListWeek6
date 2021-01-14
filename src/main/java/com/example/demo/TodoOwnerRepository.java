package com.example.demo;

import com.example.demo.models.TodoOwner;
import org.springframework.data.repository.CrudRepository;

public interface TodoOwnerRepository extends CrudRepository<TodoOwner, Long> {
}
