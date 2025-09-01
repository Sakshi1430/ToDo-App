package com.ToDoList.To_Do_List.services;

import com.ToDoList.To_Do_List.models.Task;
import com.ToDoList.To_Do_List.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
