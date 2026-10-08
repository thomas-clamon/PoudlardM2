package com.example.poudlarm10710.dto;

public class SorcierSortilegeDto {

    private String nom;
    private String prenom;

    private String maison;

    private Integer nbSort;

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

    public String getMaison() {
        return maison;
    }

    public void setMaison(String maison) {
        this.maison = maison;
    }

    public Integer getNbSort() {
        return nbSort;
    }

    public void setNbSort(Integer nbSort) {
        this.nbSort = nbSort;
    }
}
