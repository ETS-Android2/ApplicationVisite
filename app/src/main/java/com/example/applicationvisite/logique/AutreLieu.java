package com.example.applicationvisite.logique;

public class AutreLieu implements Lieux{

    String al_nom;
    String al_id;
    String al_description;
    String al_lienvideo;
    String horaires;
    String al_mapLocation;

    public AutreLieu(String al_nom, String al_id, String al_description, String al_lienvideo, String horaires, String al_mapLocation) {
        this.al_nom = al_nom;
        this.al_id = al_id;
        this.al_description = al_description;
        this.al_lienvideo = al_lienvideo;
        this.horaires = horaires;
        this.al_mapLocation = al_mapLocation;
    }

    public AutreLieu() {
    }

    public String getAl_mapLocation() {
        return al_mapLocation;
    }

    public String getAl_nom() {
        return al_nom;
    }

    public String getAl_id() {
        return al_id;
    }

    public String getAl_description() {
        return al_description;
    }

    public String getAl_lienvideo() {
        return al_lienvideo;
    }

    public String getHoraires() {
        return horaires;
    }
}
