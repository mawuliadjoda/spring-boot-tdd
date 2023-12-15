package com.esprit.springboottdd.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {
    @Autowired MockMvc mvc;

    @MockBean
    TodoRepository todoRepository;

    @Autowired ObjectMapper objectMapper;

    @Test
    void testWithMockMvc() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void shouldGetAllTodo() throws Exception {
        var todos = List.of(
                new Todo("Test 1", true),
                new Todo("Test 2", true)
        );

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        mvc.perform(get("/api/todos"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(todos))
                );
    }
    @Test
    void shouldCreateNewTodo() {
        var todo = new Todo("Test", false);
        Assertions.assertEquals("Test", todo.name());

        org.assertj.core.api.Assertions.assertThat("Test")
                .isEqualTo(todo.name())
                .startsWith("T")
                .isEqualToIgnoringCase("test")
                .endsWith("t");
    }
}
