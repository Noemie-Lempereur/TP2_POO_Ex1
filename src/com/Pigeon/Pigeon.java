package com.Pigeon;

import java.lang.Thread;

public class Pigeon {
    private int coordonnee;
    private enum etatPigeon{Endormi, Reveille};
    private Pigeon.etatPigeon etat;

    public Pigeon(int coordonneeNew) {
        this.etat = etatPigeon.Reveille;
        this.coordonnee = coordonneeNew;
    }

    public int getCoordonnee(){
        return coordonnee;
    }

    public etatPigeon getEtat(){
        return etat;
    }

    public void setCoordonnee(int coordonneeNew){
        coordonnee=coordonneeNew;
    }

    public void setEtat(etatPigeon etatNew){
        etat=etatNew;
    }

}
