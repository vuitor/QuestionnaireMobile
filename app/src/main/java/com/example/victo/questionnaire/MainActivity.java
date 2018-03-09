package com.example.victo.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btA;
    private ImageView btB;
    private ImageView btC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btA = (ImageView) findViewById(R.id.idRERA);
        this.btB = (ImageView) findViewById(R.id.idRERB);
        this.btC = (ImageView) findViewById(R.id.idRERC);

        this.btA.setOnClickListener(this);
        this.btB.setOnClickListener(this);
        this.btC.setOnClickListener(this);

        SNCF.remplir();

    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.idRERA)
        {
            //on enregistre la ligne de RER
            String rer = "Ligne A";
            //On passe à la page 2
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", rer);
            startActivity(unIntent);

        }
        else if (v.getId()== R.id.idRERB)
        {
            //on enregistre la ligne de RER
            String rer = "Ligne B";
            //On passe à la page 2
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", rer);
            startActivity(unIntent);

        }
        else if (v.getId()== R.id.idRERC)
        {
            //on enregistre la ligne de RER
            String rer = "Ligne C";
            //On passe à la page 2
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", rer);
            startActivity(unIntent);

        }
    }
}
