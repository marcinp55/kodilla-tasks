package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {
    @Autowired
    DbService dbService;

    @Test
    public void shouldFetchAllTasks() {
        //Given
        //When
        List<Task> fetchedTasks = dbService.getAllTasks();

        //Then
        Assert.assertEquals(8, fetchedTasks.size());
    }

    @Test
    public void shouldFetchTaskById() {
        //Given
        //When
        //Task fetchedTask = dbService.getTask(2L);

        //Then
        //Assert.assertEquals("test2", fetchedTask.getTitle());
        //Assert.assertEquals("testing2", fetchedTask.getContent());
    }
}
