package com.example.applicationvisite.logique;

public class Departement{

    String dep_nom;
    String dep_id;
    String dep_description;
    String dep_lienvideo;

    public Departement(String dep_nom, String dep_id, String dep_description, String dep_lienvideo) {
        this.dep_nom = dep_nom;
        this.dep_id = dep_id;
        this.dep_description = dep_description;
        this.dep_lienvideo = dep_lienvideo;
    }

    public Departement() {
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
}
