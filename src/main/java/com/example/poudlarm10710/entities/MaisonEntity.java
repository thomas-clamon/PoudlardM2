package com.example.poudlarm10710.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Maisons")
public class MaisonEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "points", nullable = false)
    private Integer points;

    @OneToMany(fetch =FetchType.LAZY)
    @JoinColumn(name = "id_maison")
    List<SorcierEntity> sorcierEntityList;

    public List<SorcierEntity> getSorcierEntityList() {
        return sorcierEntityList;
    }

    public void setSorcierEntityList(List<SorcierEntity> sorcierEntityList) {
        this.sorcierEntityList = sorcierEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}


