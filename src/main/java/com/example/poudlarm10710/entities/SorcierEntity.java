package com.example.poudlarm10710.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Sorciers")
public class SorcierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate date_naissance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_maison")
    private MaisonEntity maisonEntity;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }
}
