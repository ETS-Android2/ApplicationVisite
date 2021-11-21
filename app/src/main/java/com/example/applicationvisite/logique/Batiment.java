package com.example.applicationvisite.logique;

import java.util.LinkedList;

public class Batiment implements Lieux{

    Batiment instance;
    LinkedList<Lieux> listeLieuxInteret;

    String bat_nom;
    String bat_id;
    String bat_description;
    String bat_id_img;

    public Batiment(){
        // constructeur vide pour la BD
    }

    public Batiment(String bat_nom, String bat_id, String bat_description, String bat_id_img) {
        this.listeLieuxInteret = new LinkedList<>();
        this.bat_nom = bat_nom;
        this.bat_id = bat_id;
        this.bat_description = bat_description;
        this.bat_id_img = bat_id_img;
    }


    @Override
    public String getId() {
        return bat_id;
    }

    @Override
    public String getNom() {
        return bat_nom;
    }

    @Override
    public String getDescription() {
        return bat_description;
    }


    public String getLienPhoto() {
        return bat_id_img;
    }


}
