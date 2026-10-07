package com.example.poudlarm10710.services;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.entities.SorcierEntity;
import com.example.poudlarm10710.repositories.SorcierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierServiesTest {

    private SorcierServies service = new SorcierServies();

    @Test
    public void test_age_sorcier(){
        // Arrange
        SorcierEntity entity = new SorcierEntity();
        entity.setNom("Granger");
        entity.setPrenom("Hermione");
        entity.setDate_naissance(LocalDate.of(2001, 02, 01));

        SorcierDto dto = service.toDto(entity); //access

        assertEquals(25, dto.getAge());
    }



}