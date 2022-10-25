package com.Pigeon;

import java.util.Date;


public class Nourriture {
    final int tempsPeremption = 10000;
    private int coordonnee;
    private enum etatNourriture{PlusFraiche, Fraiche, Perimee};
    private etatNourriture etat;
    private Date date;

    public Nourriture(int coordonneeNew) {
        this.etat = etatNourriture.PlusFraiche;
        this.date = new Date();
        this.coordonnee = coordonneeNew;
    }

    public etatNourriture getEtat(){
        return etat;
    }

    public Date getDate(){
        return date;
    }

    public void setEtat(){
        Date dateActuelle = new Date();
        long difference = dateActuelle.getTime() - getDate().getTime();
        if (difference > tempsPeremption) {
            etat = etatNourriture.Perimee;
        }
    }

}
