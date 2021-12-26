package com.example.applicationvisite;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.applicationvisite.logique.Batiment;

import java.util.ArrayList;

public class StatistiqueFragment extends Fragment {

    private ArrayList<Batiment> list_bat_visited;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_statistique,container,false);

        try {

            list_bat_visited = SplashScreenActivity.getSharedBatList();
            int cpt = 0;
            for (Batiment b:list_bat_visited) {
                if (b.isVisited()){
                    cpt++;
                }
            }

            TextView pourcentage = (TextView) rootView.findViewById(R.id.text_bat_pourcentage_Stat);
            int taux_progress = (int)((cpt*100)/list_bat_visited.size());
            pourcentage.setText(taux_progress + " %");

            ProgressBar progessbar = (ProgressBar) rootView.findViewById(R.id.progressBarStat);
            //int ratio = (progessbar.getMin() + progessbar.getMax())/list_bat_visited.size() + cpt;
            progessbar.setProgress(taux_progress);
        }
        catch (Exception e){
            Log.d("DEBUG", "Impossible de charger les éléments ! ils ne sont pas dans le layout actuel" );
        }


        return rootView;
    }
}