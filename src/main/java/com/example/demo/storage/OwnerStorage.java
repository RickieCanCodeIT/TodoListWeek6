package com.example.demo.storage;

import com.example.demo.TodoOwnerRepository;
import com.example.demo.models.TodoOwner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerStorage {
    //Map<Long, TodoOwner> ownerList = new HashMap<>();
    //
    private TodoOwnerRepository todoOwnerRepo;

    public OwnerStorage(TodoOwnerRepository todoOwnerRepo) {

        this.todoOwnerRepo = todoOwnerRepo;
    }

    public void addOwner(TodoOwner inOwner) {
        //ownerList.put(inOwner.getId(), inOwner);
        todoOwnerRepo.save(inOwner);
    }

    public Iterable<TodoOwner> retrieveAllOwners() {
        //return ownerList.values();
        return todoOwnerRepo.findAll();
    }

    public TodoOwner retrieveOwnerById(Long id) {
        //return ownerList.get(id);
        Optional<TodoOwner> retrievedTodoOwnerOptional = todoOwnerRepo.findById(id);
        if(retrievedTodoOwnerOptional.isPresent()){
            TodoOwner foundTodoOwner = retrievedTodoOwnerOptional.get();
            return foundTodoOwner;
        }
        return null;
    }
}
