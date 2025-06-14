package com.invoker.taskmanager.task_management_api.repository;

import com.invoker.taskmanager.task_management_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}