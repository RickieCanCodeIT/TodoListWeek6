package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class TodoOwner {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "owner")
    private Collection<TodoItem> items;


    public TodoOwner(String name) {
        this.name = name;
    }

    public TodoOwner() {

    }

    public String getName() {
        return name;
    }

    public Collection<TodoItem> getItems() {
        return items;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TodoOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoOwner todoOwner = (TodoOwner) o;

        if (id != todoOwner.id) return false;
        return name.equals(todoOwner.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
