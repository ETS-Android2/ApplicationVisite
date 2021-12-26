package com.example.applicationvisite.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationvisite.DetailBatimentActivity;
import com.example.applicationvisite.DetailDepartementActivity;
import com.example.applicationvisite.R;
import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.Departement;

import java.util.ArrayList;

public class MyDepartementAdapter extends RecyclerView.Adapter<MyDepartementAdapter.ViewHolder> {

    ArrayList<Batiment> listeBatiments = BDRepository.getBatimentsListe();
    ArrayList<Departement> myDepartementDataReel;
    Context context;
    String idBat;

    public MyDepartementAdapter(ArrayList<Departement> myDepartementData, DetailBatimentActivity activity, String idBat) {
        this.idBat=idBat;
        this.myDepartementDataReel= new ArrayList<>();
        this.context = activity;
        initializeList(myDepartementData);
    }

    private void initializeList(ArrayList<Departement>myDepartementData){
        for(Departement dep:myDepartementData){
            if (dep.getDep_mapLocation().contains(idBat)){
                myDepartementDataReel.add(dep);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dep_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Departement myDepartementDataList = myDepartementDataReel.get(position);

        holder.textViewName.setText(myDepartementDataList.getDep_nom());

        //TODO : mettre une image dynamique
        //holder.movieImage.setImageResource(myDepartementData.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resScan = myDepartementDataList.getDep_id();

                //encapsulation de l'id de la fenêtre demandée
                Bundle bundle = new Bundle();
                bundle.putString("id_decoded",resScan);

                Intent detailviewactivity = new Intent(context.getApplicationContext(), DetailDepartementActivity.class);
                //ajout de l'encapsulation
                detailviewactivity.putExtras(bundle);
                //lancement activité
                context.startActivity(detailviewactivity);
                //TODO : lancer la vue du département avec le bon  bind
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDepartementDataReel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.recycler_dep_name);
        }
    }

}
