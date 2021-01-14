package com.example.demo.storage;

import com.example.demo.TodoItemRepository;
import com.example.demo.TodoOwnerRepository;
import com.example.demo.models.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemStorage {

    //constructor injec.
    private TodoItemRepository todoItemRepo;

    public TodoItemStorage(TodoItemRepository todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    public void addItem(TodoItem itemToAdd){
        todoItemRepo.save(itemToAdd);
    }

    public Iterable<TodoItem> retrieveAllItems(){
        return todoItemRepo.findAll();
    }

    public TodoItem retrieveTodoItemById(long id){
        return todoItemRepo.findById(id).get();
    }
}
