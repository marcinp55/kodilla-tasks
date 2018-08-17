package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTestSuite {
    TaskMapper taskMapper = new TaskMapper();

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto1 = new TaskDto(1L, "Title1", "Content1");
        TaskDto taskDto2 = new TaskDto(2L, "Title2", "Content2");
        TaskDto taskDto3 = new TaskDto(3L, "Title3", "Content3");

        //When
        Task task1 = taskMapper.mapToTask(taskDto1);
        Task task2 = taskMapper.mapToTask(taskDto2);
        Task task3 = taskMapper.mapToTask(taskDto3);

        //Then
        Assert.assertEquals(taskDto1.getId(), task1.getId());
        Assert.assertEquals("Title1", task1.getTitle());
        Assert.assertEquals("Content1", task1.getContent());

        Assert.assertEquals(taskDto2.getId(), task2.getId());
        Assert.assertEquals("Title2", task2.getTitle());
        Assert.assertEquals("Content2", task2.getContent());

        Assert.assertEquals(taskDto3.getId(), task3.getId());
        Assert.assertEquals("Title3", task3.getTitle());
        Assert.assertEquals("Content3", task3.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task1 = new Task(1L, "Title1", "Content1");
        Task task2 = new Task(2L, "Title2", "Content2");
        Task task3 = new Task(3L, "Title3", "Content3");

        //When
        TaskDto taskDto1 = taskMapper.mapToTaskDto(task1);
        TaskDto taskDto2 = taskMapper.mapToTaskDto(task2);
        TaskDto taskDto3 = taskMapper.mapToTaskDto(task3);

        //Then
        Assert.assertEquals(task1.getId(), taskDto1.getId());
        Assert.assertEquals("Title1", taskDto1.getTitle());
        Assert.assertEquals("Content1", taskDto1.getContent());

        Assert.assertEquals(task2.getId(), taskDto2.getId());
        Assert.assertEquals("Title2", taskDto2.getTitle());
        Assert.assertEquals("Content2", taskDto2.getContent());

        Assert.assertEquals(task3.getId(), taskDto3.getId());
        Assert.assertEquals("Title3", taskDto3.getTitle());
        Assert.assertEquals("Content3", taskDto3.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();

        Task task1 = new Task(1L, "Title1", "Content1");
        Task task2 = new Task(2L, "Title2", "Content2");
        Task task3 = new Task(3L, "Title3", "Content3");

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(task1.getId(), taskDtoList.get(0).getId());
        Assert.assertEquals("Title1", taskDtoList.get(0).getTitle());
        Assert.assertEquals("Content1", taskDtoList.get(0).getContent());

        Assert.assertEquals(task2.getId(), taskDtoList.get(1).getId());
        Assert.assertEquals("Title2", taskDtoList.get(1).getTitle());
        Assert.assertEquals("Content2", taskDtoList.get(1).getContent());

        Assert.assertEquals(task3.getId(), taskDtoList.get(2).getId());
        Assert.assertEquals("Title3", taskDtoList.get(2).getTitle());
        Assert.assertEquals("Content3", taskDtoList.get(2).getContent());
    }
}
