package com.example.applicationvisite.logique;

import java.util.HashSet;
import java.util.Objects;

public class Batiment implements Lieux{

    Batiment instance;
    HashSet<Lieux> listeLieuxInteret;

    String nom;
    String id;
    String descrption;
    String lienVideo;

    private Batiment(HashSet<Lieux> listeLieuxInteret, String nom, String id, String descrption, String lienVideo) {
        this.listeLieuxInteret =listeLieuxInteret;
        this.nom = nom;
        this.id = id;
        this.descrption = descrption;
        this.lienVideo = lienVideo;
    }

    public Batiment getInstanceBat(HashSet<Lieux> listeLieuxInteret, String nom, String id, String descrption, String lienVideo){
        if (instance == null){
            instance = new Batiment(listeLieuxInteret, nom, id, descrption, lienVideo);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batiment batiment = (Batiment) o;
        return Objects.equals(instance, batiment.instance) && Objects.equals(listeLieuxInteret, batiment.listeLieuxInteret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instance, listeLieuxInteret);
    }
}
