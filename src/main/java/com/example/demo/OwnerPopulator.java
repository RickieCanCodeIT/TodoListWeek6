package com.example.demo;

import com.example.demo.models.TodoItem;
import com.example.demo.models.TodoOwner;
import com.example.demo.storage.OwnerStorage;
import com.example.demo.storage.TodoItemStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OwnerPopulator implements CommandLineRunner {
    OwnerStorage ownerStorage;
    private TodoItemStorage itemStorage;
    private HashtagRepository hashtagRepo;

    public OwnerPopulator(OwnerStorage inOwnerStorage, TodoItemStorage itemStorage, HashtagRepository hashtagRepo){
        ownerStorage = inOwnerStorage;
        this.itemStorage = itemStorage;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        TodoOwner Jordan = new TodoOwner("Jordan");
        TodoOwner Rickie = new TodoOwner("Rickie");
        TodoOwner Cliff = new TodoOwner("Cliff");
        TodoOwner Lauren = new TodoOwner("Lauren");


        ownerStorage.addOwner(Jordan);
        ownerStorage.addOwner(Rickie);
        ownerStorage.addOwner(Cliff);
        ownerStorage.addOwner(Lauren);

        TodoItem itemToAdd1 = new TodoItem(Jordan, "Clean Dishes", "Today", "Clean dishes in sink.");
        itemStorage.addItem(itemToAdd1);
        TodoItem itemToAdd2 = new TodoItem(Rickie, "Remove Cats", "Today", "Remove cats from room.");
        itemStorage.addItem(itemToAdd2);

        hashtagRepo.save(new Hashtag("#Awesome",itemToAdd1,itemToAdd2));
        hashtagRepo.save(new Hashtag("#SuperAwesome",itemToAdd1));
        hashtagRepo.save(new Hashtag("#whatever",itemToAdd2));
    }
}
