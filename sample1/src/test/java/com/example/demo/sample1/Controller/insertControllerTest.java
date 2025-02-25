package com.example.demo.sample1.Controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;// 変更
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.sample1.Model.DAO.sample1DAO;
import com.example.demo.sample1.Model.DTO.sample1DTO;

@WebMvcTest(insertController.class)
public class insertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private sample1DAO dao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertForm() throws Exception {
        doNothing().when(dao).insert(any(sample1DTO.class));

        mockMvc.perform(post("/si")
                .param("name", "John")
                .param("age", "30"))
                .andExpect(view().name("index.html"))
                .andExpect(model().attributeExists("staff"));

        sample1DTO dto = new sample1DTO();
        dto.setName("John");
        dto.setAge(30);
        verify(dao, times(1)).insert(dto);
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("insert.html"));
    }
}
