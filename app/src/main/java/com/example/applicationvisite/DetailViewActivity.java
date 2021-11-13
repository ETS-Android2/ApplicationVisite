package com.example.applicationvisite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContextParams;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.applicationvisite.fragments.BatimentFragment;

public class DetailViewActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        //reception du résultat du scan
        Bundle bundle_reciever = getIntent().getExtras();
        idQrCode = bundle_reciever.getString("id_decoded");

        //Injecter le fragment
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.fragment_container_detailview, new BatimentFragment());
        t.addToBackStack(null);
        t.commit();

        String msg_test = "Code scanné : "+ idQrCode;
        Toast toast_test = Toast.makeText(getApplicationContext(),msg_test,Toast.LENGTH_LONG);
        toast_test.show();

        buttonclose = (ImageButton) findViewById(R.id.button_close);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);
            }
        });

    }
}