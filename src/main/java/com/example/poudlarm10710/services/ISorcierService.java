package com.example.poudlarm10710.services;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.dto.SorcierSortilegeDto;
import com.example.poudlarm10710.entities.SorcierEntity;

import java.util.List;

public interface ISorcierService {
    /**
     * Cette fonction transforme une entité en DTO
     * @param entity
     * @return
     */
    SorcierDto toDto(SorcierEntity entity);

    SorcierSortilegeDto toSortilegeDto(SorcierEntity entity);

    List<SorcierDto> getAll();

    SorcierDto get (Integer id);

    SorcierSortilegeDto getSorcierSortilege(Integer id)

    Boolean exist(Integer id);
}
