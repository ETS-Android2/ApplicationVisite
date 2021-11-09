package com.example.applicationvisite.logique;

import java.util.HashSet;

public class Departement implements Lieux{

    Departement instance;
    HashSet<Lieux> listeLieuxInteret;

    String nom;
    String id;
    String descrption;
    String lienVideo;

    private Departement(HashSet<Lieux> listeLieuxInteret, String nom, String id, String descrption, String lienVideo) {
        this.listeLieuxInteret =listeLieuxInteret;
        this.nom = nom;
        this.id = id;
        this.descrption = descrption;
        this.lienVideo = lienVideo;
    }

    public Departement getInstanceBat(HashSet<Lieux> listeLieuxInteret, String nom, String id, String descrption, String lienVideo){
        if (instance == null){
            instance = new Departement(listeLieuxInteret, nom, id, descrption, lienVideo);
            return instance;
        }
        else {
            return instance;
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return descrption;
    }

    @Override
    public String getLienVideo() {
        return lienVideo;
    }

}
