package com.example.applicationvisite.logique;

public class Departement implements Lieux{

    String dep_nom;
    String dep_id;
    String dep_lienvideo;
    String dep_mapLocation;
    String dep_objectifs;
    String dep_candidature;
    String dep_organisation;
    String dep_alternance;
    String dep_contact;
    String dep_lienimg;
    String dep_nomplaquette;

    public Departement(String dep_nom, String dep_id, String dep_lienvideo, String dep_mapLocation, String dep_objectifs, String dep_candidature, String dep_organisation, String dep_alternance, String dep_contact, String dep_lienimg, String dep_nomplaquette) {
        this.dep_nom = dep_nom;
        this.dep_id = dep_id;
        this.dep_lienvideo = dep_lienvideo;
        this.dep_mapLocation = dep_mapLocation;
        this.dep_objectifs = dep_objectifs;
        this.dep_candidature = dep_candidature;
        this.dep_organisation = dep_organisation;
        this.dep_alternance = dep_alternance;
        this.dep_contact = dep_contact;
        this.dep_lienimg = dep_lienimg;
        this.dep_nomplaquette = dep_nomplaquette;
    }

    public Departement() {
    }

    public String getDep_nomplaquette() {
        return dep_nomplaquette;
    }

    public String getDep_lienimg() {
        return dep_lienimg;
    }

    public String getDep_objectifs() {
        return dep_objectifs;
    }

    public String getDep_candidature() {
        return dep_candidature;
    }

    public String getDep_organisation() {
        return dep_organisation;
    }

    public String getDep_alternance() {
        return dep_alternance;
    }

    public String getDep_contact() {
        return dep_contact;
    }

    public String getDep_mapLocation() {
        return dep_mapLocation;
    }

    public String getDep_nom() {
        return dep_nom;
    }

    public String getDep_id() {
        return dep_id;
    }

    public String getDep_lienvideo() {
        return dep_lienvideo;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "dep_nom='" + dep_nom + '\'' +
                ", dep_id='" + dep_id + '\'' +
                ", dep_lienvideo='" + dep_lienvideo + '\'' +
                ", dep_mapLocation='" + dep_mapLocation + '\'' +
                ", dep_objectifs='" + dep_objectifs + '\'' +
                ", dep_candidature='" + dep_candidature + '\'' +
                ", dep_organisation='" + dep_organisation + '\'' +
                ", dep_alternance='" + dep_alternance + '\'' +
                ", dep_contact='" + dep_contact + '\'' +
                ", dep_lienimg='" + dep_lienimg + '\'' +
                ", dep_nomplaquette='" + dep_nomplaquette + '\'' +
                '}';
    }
}
