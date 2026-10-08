package com.example.poudlarm10710.repositories;

import com.example.poudlarm10710.entities.SortielegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortilegeRepository extends JpaRepository<SortielegeEntity, Integer> {

}
