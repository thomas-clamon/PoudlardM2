package com.example.poudlarm10710.repositories;

import com.example.poudlarm10710.entities.MaisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonRepository extends JpaRepository<MaisonEntity, Integer> {
}
