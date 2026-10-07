package com.example.poudlarm10710.repositories;

import com.example.poudlarm10710.entities.SorcierEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierRepositoryTest {

    @Autowired
    private SorcierRepository repository;

    @Test
    public void should_2_element()
    {
        // on considere qu'on a des donnée dans la base H2 avec le data.SQL
        SorcierEntity sorcier = repository.findById(2).get();
        assertEquals("Harry", sorcier.getPrenom());
    }


}