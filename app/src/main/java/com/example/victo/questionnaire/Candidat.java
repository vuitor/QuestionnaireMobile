package com.example.victo.questionnaire;

import java.util.HashMap;

/**
 * Created by victo on 23/02/2018.
 */

public class Candidat {
    private String nom, prenom, ligne, profession, rer;
    private int annee;
    private HashMap<String, Integer> lesReponses;

    public Candidat(String nom, String prenom, String ligne, int annee, String profession, String rer)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.ligne = ligne;
        this.annee = annee;
        this.profession = profession;
        this.rer = rer;
        this.lesReponses = new HashMap<String, Integer>();
    }

    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put(question, score);
    }

    public float getMoyenne()
    {
        float moyenne = 0;
        for (Integer score : this.lesReponses.values())
        {
            moyenne += score;
        }
        moyenne /= this.lesReponses.size();
        return moyenne;
    }

    public String getImageSmiley (String generique)
    {
        if (this.getMoyenne() < 8 ) {
            return generique + "s1.png";
        }
        else if (this.getMoyenne() < 14) {
            return generique + "s2.png";
        }
        else return generique + "s3.png";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRer() {
        return rer;
    }

    public void setRer(String rer) {
        this.rer = rer;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String nom) {
        this.profession = profession;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
