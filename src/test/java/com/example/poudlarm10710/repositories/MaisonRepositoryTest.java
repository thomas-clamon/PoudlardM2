package com.example.poudlarm10710.repositories;

import com.example.poudlarm10710.entities.MaisonEntity;
import com.example.poudlarm10710.entities.SorcierEntity;
import com.example.poudlarm10710.repositories.MaisonRepository;
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

    @Test
    void shouldOneMemberInHouse()
    {
        // arrange deja fais par le script data.sql
        List<MaisonEntity> list = repository.findAll(); //Access recuperation des données
        // j'accede à la maison n°1
        List<SorcierEntity> sorcier_list = list.get(0).getSorcierEntityList();

        assertEquals("Grynfondor", list.get(0).getNom()); // je verifie qu'on recupere grynfondor depuis H2
        assertEquals(1, sorcier_list.size()); // on verfie que la maison a 1 sorcier
        assertEquals("Ron", sorcier_list.get(0).getPrenom()); // on verifie qu'on a le bon sorcier




    }


}