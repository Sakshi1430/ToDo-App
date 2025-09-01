package com.ToDoList.To_Do_List.repository;

import com.ToDoList.To_Do_List.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
