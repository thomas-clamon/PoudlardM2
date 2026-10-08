package com.example.poudlarm10710.services;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.dto.SorcierSortilegeDto;
import com.example.poudlarm10710.entities.MaisonEntity;
import com.example.poudlarm10710.entities.SorcierEntity;
import com.example.poudlarm10710.entities.SortielegeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test_tranformation_sortier_to_dto(){

        // Arange on creer un sorcier complet
        SorcierEntity sorcierEntity = new SorcierEntity();
        sorcierEntity.setPrenom("Charlie");
        sorcierEntity.setNom("DUPONT");

        MaisonEntity maisonEntity = new MaisonEntity();
        maisonEntity.setNom("Serpentard");

        sorcierEntity.setMaisonEntity(maisonEntity);

        SortielegeEntity sortielegeEntity = new SortielegeEntity();
        sortielegeEntity.setNom("Allo mora");

        List<SortielegeEntity> list_sort = new ArrayList<>();
        list_sort.add(sortielegeEntity);
        sorcierEntity.setList_sort(list_sort);

        // ACT
        SorcierSortilegeDto dto = service.toSortilegeDto(sorcierEntity);

        //assert
        assertEquals("Serpentard", dto.getMaison());
        assertEquals(1, dto.getNbSort());
    }
}