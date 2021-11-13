package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.applicationvisite.fragments.BatimentFragment;

public class DetailViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        //injecter le fragment batiment dans notre boite fragment container

    FragmentTransaction t = getSupportFragmentManager().beginTransaction();
    t.replace(R.id.fragment_container_detailview, new BatimentFragment());
    t.addToBackStack(null);
    t.commit();

    }
}