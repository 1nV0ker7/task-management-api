package com.invoker.taskmanager.task_management_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ActiveProfiles;
import com.invoker.taskmanager.task_management_api.config.TestSecurityConfig;

@SpringBootTest
@ContextConfiguration(classes = TestSecurityConfig.class)
@ActiveProfiles("test")
class TaskManagementApiApplicationTests {

    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    void contextLoads() {
    }
}