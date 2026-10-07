package com.example.poudlarm10710.controler;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.services.SorcierServies;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SorcierController.class)
class SorcierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SorcierServies servies;

    @Test
    void shouldGoodMessageWhenSorcierNotExist() throws Exception {


        // Arrange
        Integer ID = 43;
        String message = "Le sorcier n'existe pas";
        when(servies.exist(ID)).thenReturn(false);
        mockMvc.perform(get("/Sorcier/get/"+ID)).andExpect(status().is(201)).andExpect(content().string(message));
    }

    @Test
    void shouldGood (){
        // Arrange
        Integer ID = 43;
        SorcierDto result = new SorcierDto();
        result.setDisplayName("test cedric");
        result.setAge(45);
        when(servies.exist(ID)).thenReturn(true);
        when(servies.get(ID)).thenReturn(result);


        try {
            mockMvc.perform(get("/Sorcier/get/"+ID)).andExpect(status().is(200));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}