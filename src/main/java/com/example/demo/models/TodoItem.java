package com.example.demo.models;


import com.example.demo.Hashtag;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private TodoOwner owner;
    private String title;
    private String Urgency;
    private String description;
    @ManyToMany(mappedBy = "todoItem")
    private Collection<Hashtag> hashtags;


    protected TodoItem() {

    }

    public TodoItem(TodoOwner owner, String title, String urgency, String description) {
        this.owner = owner;
        this.title = title;
        this.Urgency = urgency;
        this.description = description;
        }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public long getId() {
        return id;
    }
        public TodoOwner getOwner() {
            return owner;
        }

        public String getTitle() {
            return title;
        }

        public String getUrgency() {
            return Urgency;
        }

        public String getDescription() {
            return description;
        }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", owner=" + owner +
                ", title='" + title + '\'' +
                ", Urgency='" + Urgency + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != todoItem.id) return false;
        if (owner != null ? !owner.equals(todoItem.owner) : todoItem.owner != null) return false;
        if (title != null ? !title.equals(todoItem.title) : todoItem.title != null) return false;
        if (Urgency != null ? !Urgency.equals(todoItem.Urgency) : todoItem.Urgency != null) return false;
        return description != null ? description.equals(todoItem.description) : todoItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (Urgency != null ? Urgency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
