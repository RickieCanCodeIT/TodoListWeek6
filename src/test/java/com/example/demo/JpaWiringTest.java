package com.example.demo;

import com.example.demo.models.TodoItem;
import com.example.demo.models.TodoOwner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TodoOwnerRepository todoOwnerRepo;
    @Autowired
    private TodoItemRepository todoItemRepo;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private HashtagRepository hashtagRepo;

    @Test
    public void checkOwnerHasManyItemsAndItemsHaveSingleOwner() {
        TodoOwner jordan = new TodoOwner("Jordan");

        todoOwnerRepo.save(jordan);

        TodoItem task1 = new TodoItem(jordan, "Mow the lawn", "Low", "The lawn is a bit long");
        TodoItem task2 = new TodoItem(jordan, "Fight the clown", "High", "The clown has it coming");

        todoItemRepo.save(task1);
        todoItemRepo.save(task2);

        testEntityManager.flush();
        testEntityManager.clear();

        TodoOwner retrievedJordan = todoOwnerRepo.findById(jordan.getId()).get();

        assertThat(retrievedJordan.getItems()).contains(task1, task2);
    }

    @Test
    public void todoItemHasManyHashtagsAndHashtagsHaveManyTodoItems(){
        TodoOwner jordan = new TodoOwner("Jordan");

        todoOwnerRepo.save(jordan);

        TodoItem task1 = new TodoItem(jordan, "Mow the lawn", "Low", "The lawn is a bit long");
        TodoItem task2 = new TodoItem(jordan, "Fight the clown", "High", "The clown has it coming");
        todoItemRepo.save(task1);
        todoItemRepo.save(task2);

        Hashtag testHashtag = new Hashtag("Cool",task1,task2);
        Hashtag testHashtag2 = new Hashtag("Awesome",task1);
        Hashtag testHashtag3 = new Hashtag("Incredible",task2);
        hashtagRepo.save(testHashtag);
        hashtagRepo.save(testHashtag2);
        hashtagRepo.save(testHashtag3);

        testEntityManager.flush();
        testEntityManager.clear();

        TodoItem retrievedItem1 = todoItemRepo.findById(task1.getId()).get();
        TodoItem retrievedItem2 = todoItemRepo.findById(task2.getId()).get();

        assertThat(retrievedItem1.getHashtags()).contains(testHashtag,testHashtag2);
        assertThat(retrievedItem2.getHashtags()).contains(testHashtag,testHashtag3);
    }
}
