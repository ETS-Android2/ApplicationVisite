package com.example.applicationvisite.logique;

import android.util.Log;

import com.example.applicationvisite.SplashScreenActivity;

import java.util.ArrayList;
import java.util.LinkedList;


public class Visite {

    private static Visite instance;
    private int nbsommets;
    private String[] tabBatimentCorrespondance;
    private int[][] graphCampus;

    private Visite(int nbBatiments, int[] liaisonsPremierBat, String[] tabBatimentCorrespondance) {
        this.nbsommets = nbBatiments;
        this.graphCampus = new int[nbsommets][nbsommets];
        this.tabBatimentCorrespondance=tabBatimentCorrespondance;
        remplirGraph(liaisonsPremierBat);
    }

    public static Visite getInstance(){
        if (instance==null){
            int[] liaisonsPremierBat= {1,2,3,4,5,6,6,5,4,3,2,1,-1};
            String[] tabBatimentCorrespondance = {
                    "bat_a","bat_b","bat_c","bat_l","bat_k","bat_d",
                    "bat_m","bat_e","bat_f","bat_g","bat_h","bat_i","bat_j"};
            instance = new Visite(13,liaisonsPremierBat, tabBatimentCorrespondance);
            return instance;
        }
        else {
            return instance;
        }
    }

    private int getIndexWithBat(String string){
        for (int i=0; i< this.tabBatimentCorrespondance.length;i++){
            if (tabBatimentCorrespondance[i].equals(string)) {
                return i;
            }
        }
        return -1;
    }

    private String getBatWithIndex(int index){
        return this.tabBatimentCorrespondance[index];
    }

    private boolean isBatimentVisited(String id_bat){
        System.out.println("test");
        ArrayList<Batiment> listebat = BDRepository.getBatimentsListe();
        listebat = SplashScreenActivity.getSharedBatList();

        for ( Batiment bat: listebat){
            if (bat.getBat_id().equals(id_bat)){
                return bat.isVisited();
            }
        }
        return true;
    }

    private void remplirGraph(int liaisonsPremierBat[]){
        //Remplit automatiquement le graphe complet à partir de la première liste de liaisons
        //nouvelle ligne courante
        int newLiaisonsPremierBat[] = new int[liaisonsPremierBat.length];
        for (int u = 0; u < liaisonsPremierBat.length; u++) {
            newLiaisonsPremierBat[u]=liaisonsPremierBat[u];
        }

        for (int i=0; i<nbsommets;i++){

            //écriture de la liste actuelle dans le graph
            for (int j=0; j<nbsommets; j++){
                if (j == 0) {
                    //décaler toute la liste de +1
                    graphCampus[i][j]=newLiaisonsPremierBat[newLiaisonsPremierBat.length-1];
                }
                else{
                    //ajouter au tout début le dernier int de la liste
                    graphCampus[i][j]=newLiaisonsPremierBat[j-1];
                }
            }

            //copie de la nouvelle liste courante
            for (int v = 0; v < liaisonsPremierBat.length; v++) {
                newLiaisonsPremierBat[v]=graphCampus[i][v];
            }
        }
    }

    public String getBatimentSuivant(String currentBatiment){
        int indexDeRecherche = getIndexWithBat(currentBatiment);
        int indiceProximite = 1;
        String retourne ="";
        boolean trouve=false;
        LinkedList<String> deuxSolutionsTrouve = new LinkedList<>();

        while (!trouve){
            //Ajout des solutions courantes
            for (int i = 0; i < graphCampus.length; i++) {
                if (graphCampus[indexDeRecherche][i]==indiceProximite){
                    deuxSolutionsTrouve.add(this.getBatWithIndex(i));
                }
            }
            System.out.println("test");
            //Vérification si visited ou non
            try {
                if (!this.isBatimentVisited(deuxSolutionsTrouve.get(0))) {
                    trouve = true;
                    retourne = deuxSolutionsTrouve.get(0);
                } else if (!this.isBatimentVisited(deuxSolutionsTrouve.get(1))) {
                    trouve = true;
                    retourne = deuxSolutionsTrouve.get(1);
                }
                else {
                    deuxSolutionsTrouve.clear();
                }
            }catch (Exception e){
                //S'il n'existe qu'une solution : que la première
                trouve = true;
                retourne = deuxSolutionsTrouve.get(0);
            }
            indiceProximite++;

            //tout les batiments ont été visités (puisque la boucle indique
            if (indiceProximite>(nbsommets-1)/2){
                System.out.println("ERREUR");
                trouve=true;
                retourne = null;
            }
        }
        Log.i("RECOMMANDATION", "prochain batiment à visiter :"+ retourne);
        return retourne;
    }

    @Override
    public String toString() {
        String str ="";

        for (int i=0; i<nbsommets;i++){
            for (int j=0; j<nbsommets; j++){
                str= str +" "+ graphCampus[i][j];
            }
            str=str+"\n";
        }

        return str;
    }

}

