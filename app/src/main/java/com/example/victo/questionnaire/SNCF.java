package com.example.victo.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by victo on 23/02/2018.
 */

public class SNCF {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<String, Enquete>();

    public static void remplir(){
        if(! SNCF.lesEnquetes.containsKey("rera"))
        {
            SNCF.lesEnquetes.put("rera", new Enquete());
        }
        if(! SNCF.lesEnquetes.containsKey("rerb"))
        {
            SNCF.lesEnquetes.put("rerb", new Enquete());
        }
        if(! SNCF.lesEnquetes.containsKey("rerc"))
        {
            SNCF.lesEnquetes.put("rerc", new Enquete());
        }
    }

    public static void ajouterCandidat(String rer, Candidat unCandidat)
    {
        SNCF.lesEnquetes.get(rer).ajouterCandidat(unCandidat);
    }

    public static void ajouterReponse(String rer, String nom, String question, int score)
    {
        SNCF.lesEnquetes.get(rer).ajouterReponse(nom, question, score);
    }

    //Retour sous forme d'une ArrayList
    public static ArrayList<String> listerCandidats(String rer)
    {
        return SNCF.lesEnquetes.get(rer).listerCandidats();
    }

    public static ArrayList<Integer> listerSmiley(String rer)
    {
        return SNCF.lesEnquetes.get(rer).listerSmiley();
    }

}
