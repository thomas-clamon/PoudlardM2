package com.example.poudlarm10710.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Sortileges")
public class SortielegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sorcier")
    private SorcierEntity sorcier;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SorcierEntity getSorcier() {
        return sorcier;
    }

    public void setSorcier(SorcierEntity sorcier) {
        this.sorcier = sorcier;
    }
}
