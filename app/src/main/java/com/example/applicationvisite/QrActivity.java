package com.example.applicationvisite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class QrActivity extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private Button buttonback;
    String resScan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        buttonback = (Button) findViewById(R.id.backToMainActivity);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });

        scanQR();
        System.out.println("Résultat du scan : " + resScan);
    }

    private void scanQR(){
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.startPreview();

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                //resultat du scan
                resScan = result.getText();

                //Encapsulation du résultat pour transmission dans la vue suivante
                Bundle bundle = new Bundle();
                bundle.putString("id_decoded",resScan);

                if (resScan.contains("bat_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailBatimentActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }
                else if (resScan.contains("dep_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailDepartementActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }
                /*
                else if (resScan.contains("autrelieu_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailAutreLieuActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }

                 */
                else {
                    Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainactivity);
                    finish();
                }
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCodeScanner.releaseResources();
    }

}
