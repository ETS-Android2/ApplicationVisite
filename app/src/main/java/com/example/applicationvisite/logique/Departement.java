package com.example.applicationvisite.logique;

public class Departement implements Lieux{

    String dep_nom;
    String dep_id;
    String dep_description;
    String dep_lienvideo;
    String dep_mapLocation;

    public Departement(String dep_nom, String dep_id, String dep_description, String dep_lienvideo, String dep_mapLocation) {
        this.dep_nom = dep_nom;
        this.dep_id = dep_id;
        this.dep_description = dep_description;
        this.dep_lienvideo = dep_lienvideo;
        this.dep_mapLocation=dep_mapLocation;
    }

    public Departement() {
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

    public String getDep_description() {
        return dep_description;
    }

    public String getDep_lienvideo() {
        return dep_lienvideo;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "dep_nom='" + dep_nom + '\'' +
                ", dep_id='" + dep_id + '\'' +
                ", dep_description='" + dep_description + '\'' +
                ", dep_lienvideo='" + dep_lienvideo + '\'' +
                ", dep_mapLocation='" + dep_mapLocation + '\'' +
                '}';
    }
}
