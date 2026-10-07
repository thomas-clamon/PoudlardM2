package com.example.poudlarm10710.services;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.entities.SorcierEntity;
import com.example.poudlarm10710.repositories.SorcierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierServiesH2Test {


    private SorcierServies service = new SorcierServies();
    @Autowired
    private SorcierRepository repository;

    @Test
    public void test_age_with_h2_db()
    {
        //arrange
        SorcierEntity entity = repository.findById(1).get();
        SorcierDto dto = service.toDto(entity); // access
        assertEquals(35, dto.getAge());

    }

    @Test
    public void test_GetAll(){

        // le arrange est fait par le sript data.sql
        service.setRepository(repository);
        List<SorcierDto> list =  service.getAll(); //access

        assertEquals(2, list.size()); // premiere etape

        assertEquals(35, list.get(0).getAge());
        assertEquals(56, list.get(1).getAge());
    }


}