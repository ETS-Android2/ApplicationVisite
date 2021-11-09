package com.example.applicationvisite.logique;

import java.util.HashSet;
import java.util.Objects;

public class Batiment implements Lieux{

    Batiment instance;
    HashSet<Lieux> listeLieuxInteret;

    String nom;
    String id;
    String descrption;

    private Batiment(HashSet<Lieux> listeLieuxInteret) {
        this.listeLieuxInteret =listeLieuxInteret;
    }

    public Batiment getInstanceBat(HashSet<Lieux> listeLieuxInteret){
        if (instance == null){
            instance = new Batiment(listeLieuxInteret);
            return instance;
        }
        else {
            return instance;
        }
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getDescription() {
        return this.descrption;
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
