package com.example.victo.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Page2 extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNom, txtPrenom, txtProfession;
    private Spinner spAnnee, spFrequence;
    private Button btSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.btSuivant = (Button) findViewById(R.id.idSuivant);
        this.spAnnee = (Spinner) findViewById(R.id.idAnnee);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);
        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtProfession = (EditText) findViewById(R.id.idProfession);


        // Remplissage du spinner Frequence
        ArrayList<String> lesFrequences = new ArrayList<String>();
        lesFrequences.add("Plusieurs fois par jour");
        lesFrequences.add("De temps en temps");
        lesFrequences.add("Peu souvent");
        lesFrequences.add("Jamais");


        // Déclaration d'un Array Adapter : formatage
        ArrayAdapter unAdapterFreq = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesFrequences);
        this.spFrequence.setAdapter(unAdapterFreq); //Changement de l'adapter


        // Remplissage Spinner Annee
        ArrayList<String> lesAnnees = new ArrayList<String>();
        String a;
        for (int i = 1900; i <= 2000; i++) {
            lesAnnees.add(a = "" + i);
        }

        // Déclaration d'un Array Adapter : formatage
        ArrayAdapter unAdapterAnnee = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesAnnees);
        this.spAnnee.setAdapter(unAdapterAnnee); //Changement de l'adapter


        this.btSuivant.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // On enregistre les noms et prenoms, classe et année et on passe à la page 2
        String nom = this.txtNom.getText().toString();
        String prenom = this.txtPrenom.getText().toString();
        int annee = Integer.parseInt(this.spAnnee.getSelectedItem().toString());
        String frequence = this.spFrequence.getSelectedItem().toString();
        String profession = this.txtProfession.getText().toString();
        String rer = getIntent().getStringExtra("rer");

        // Instanciation d'un candidat
        Candidat unCandidat = new Candidat(nom, prenom, frequence, annee, profession, rer);

        // On l'ajoute à la HashMap
        SNCF.ajouterCandidat(rer, unCandidat);

        // Passage à la page 2
        Intent unIntent = new Intent(this, Page3.class);
        unIntent.putExtra("nom", nom);
        startActivity(unIntent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
