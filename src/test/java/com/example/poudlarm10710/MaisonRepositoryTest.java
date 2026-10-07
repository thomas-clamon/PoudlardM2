package com.example.poudlarm10710;

import com.example.poudlarm10710.entities.MaisonEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MaisonRepositoryTest
{

    @Autowired
    MaisonRepository repository;

    @Test
    void shouldOneElement(){
        // arrange deja fais par le script data.sql

        List<MaisonEntity> list = repository.findAll(); //Access recuperation des données

        // verifie la taille de la liste
        assertEquals(1, list.size());

        // verifie si c'est bien grynfondor
        String nom = list.get(0).getNom();
        assertEquals("Grynfondor", nom);

    }
}