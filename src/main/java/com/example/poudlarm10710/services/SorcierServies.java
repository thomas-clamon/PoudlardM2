package com.example.poudlarm10710.services;

import com.example.poudlarm10710.dto.SorcierDto;
import com.example.poudlarm10710.dto.SorcierSortilegeDto;
import com.example.poudlarm10710.entities.SorcierEntity;
import com.example.poudlarm10710.repositories.SorcierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SorcierServies implements ISorcierService {

    @Autowired
    private SorcierRepository repository;

    @Override
    public SorcierDto toDto(SorcierEntity entity) {
        SorcierDto dto = new SorcierDto();
        dto.setDisplayName(entity.getPrenom() + " " + entity.getNom() );

        // on calcule l'age
        Integer age = Period.between(entity.getDate_naissance(), LocalDate.now()).getYears();
        dto.setAge(age);
        return dto;
    }

    @Override
    public SorcierSortilegeDto toSortilegeDto(SorcierEntity entity) {
        SorcierSortilegeDto dto = new SorcierSortilegeDto();
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());

        // on recupere le nom de la maison.
        String maison = entity.getMaisonEntity().getNom();
        dto.setMaison(maison);

        // je recupere le nombre de sort
        dto.setNbSort(entity.getList_sort().size());

        return dto;
    }

    @Override
    public List<SorcierDto> getAll() {
        return repository.findAll().stream().map(sorcier -> toDto(sorcier)).collect(Collectors.toList());
    }

    @Override
    public SorcierDto get(Integer id) {
        return toDto(repository.findById(id).get());
    }

    @Override
    public SorcierSortilegeDto getSorcierSortilege(Integer id) {
        return toSortilegeDto(repository.findById(id).get());
    }

    @Override
    public Boolean exist(Integer id) {
        return repository.existsById(id);
    }

    public SorcierRepository getRepository() {
        return repository;
    }

    public void setRepository(SorcierRepository repository) {
        this.repository = repository;
    }
}
