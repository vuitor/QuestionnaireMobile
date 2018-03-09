package com.example.victo.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Page6 extends AppCompatActivity implements View.OnClickListener {

    private Button btRetour;
    private ListView lvListe;
    private String nom, rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.rer = this.getIntent().getStringExtra("rer").toString();

        this.btRetour.setOnClickListener(this);

        //Afficher la liste
        ArrayList<String> laListe = SNCF.listerCandidats(this.rer);

        //On construit un tableau de chaine de caractères
        String tabC[] = new String[laListe.size()];
        int i = 0;
        for (String chaine : laListe) {
            tabC[i] = chaine;
            i++;
        }

        //On construit un tableau des id des images smiley
        ArrayList<Integer> laListeSmiley = SNCF.listerSmiley(this.rer);
        int tabI[] = new int[laListeSmiley.size()];
        i = 0;
        for(Integer image : laListeSmiley)
        {
            tabI[i] = image;
            i++;
        }

        //Adaptation de l'affichage à la liste view
        AdapterList unAdapter = new AdapterList(this, tabC, tabI);
        this.lvListe.setAdapter(unAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idRetour)
        {
            //On passe à la page principale
            Intent unIntent = new Intent(this, MainActivity.class);

            startActivity(unIntent); //Démarrage de l'Intent
        }
    }
}
