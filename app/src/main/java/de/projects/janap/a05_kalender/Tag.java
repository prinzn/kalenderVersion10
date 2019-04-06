package de.projects.janap.a05_kalender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tag {
    private int tagImMonat;
    private int inWelchemMonat;
    private int inWelchemJahr;
    private int anzahlTermine;

    public int getWieVieleTermineVorhanden(){
        return anzahlTermine;
    }


    public int getTagImMonat(){
        return tagImMonat;
    }
    public int getInWelchemMonat(){
        return inWelchemMonat;
    }
    public int getInWelchemJahr(){
        return inWelchemJahr;
    }
    public void addNeuenTermin(){
        anzahlTermine++;
    }

    public Tag (int pTagImMonat, int pInWelchemMonat, int pInWelchemJahr){
        tagImMonat = pTagImMonat;
        inWelchemMonat = pInWelchemMonat;
        inWelchemJahr = pInWelchemJahr;
    }

}
