package com.invoker.taskmanager.task_management_api.controller;

import com.invoker.taskmanager.task_management_api.model.Task;
import com.invoker.taskmanager.task_management_api.security.JwtAuthenticationFilter;
import com.invoker.taskmanager.task_management_api.security.JwtUtil;
import com.invoker.taskmanager.task_management_api.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
@ContextConfiguration(classes = {TaskController.class, JwtAuthenticationFilter.class, JwtUtil.class})
@ComponentScan(basePackages = "com.invoker.taskmanager.task_management_api.security")
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    @WithMockUser(username = "admin", roles = "USER")
    public void testGetAllTasks() throws Exception {
        when(taskService.getAllTasks()).thenReturn(Collections.singletonList(new Task()));
        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk());
    }
}