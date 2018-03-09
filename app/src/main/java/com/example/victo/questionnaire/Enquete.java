package com.example.victo.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by victo on 23/02/2018.
 */

public class Enquete {
    private HashMap<String, Candidat> lesCandidats;

    public Enquete(){
        this.lesCandidats = new HashMap<String, Candidat>();
    }

    public void ajouterCandidat(Candidat unCandidat){
        this.lesCandidats.put(unCandidat.getNom(), unCandidat);
    }
    public void ajouterReponse(String nom, String question, int score)
    {
        this.lesCandidats.get(nom).ajouterReponse(question, score);
    }
    public float getLaMoyenneCandidat(String nom)
    {
        return this.lesCandidats.get(nom).getMoyenne();
    }
    public String getImageSmileyCandidat(String nom, String generique){
        return this.lesCandidats.get(nom).getImageSmiley(generique);
    }

    //Retour sous forme d'une ArrayList
    public ArrayList<String> listerCandidats()
    {
        ArrayList<String> laListe = new ArrayList<String>();
        for(Candidat unCandidat : this.lesCandidats.values())
        {
            laListe.add("Candidat : " + unCandidat.getNom() + " Moyenne "
                    + this.getLaMoyenneCandidat(unCandidat.getNom()));
        }
        return laListe;
    }

    public ArrayList<Integer> listerSmiley()
    {
        ArrayList<Integer> laListe = new ArrayList<Integer>();
        for(Candidat unCandidat : this.lesCandidats.values())
        {
            if(unCandidat.getMoyenne() < 10)
            {
                laListe.add(R.drawable.s1);
            }
            else if(unCandidat.getMoyenne() <= 14)
            {
                laListe.add(R.drawable.s2);
            }
            else
            {
                laListe.add(R.drawable.s3);
            }
        }
        return laListe;
    }

}
