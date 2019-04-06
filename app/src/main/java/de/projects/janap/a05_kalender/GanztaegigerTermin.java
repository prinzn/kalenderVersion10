package de.projects.janap.a05_kalender;

import java.util.Calendar;

public class GanztaegigerTermin {

    private String id;
    protected Boolean ganztaegig;
    protected String titel;
    private int startTagImMonat, startTagInWelchemMonat, startTagInWelchemJahr;

    public Tag getStartTag(){
        Tag startTag = new Tag(startTagImMonat, startTagInWelchemMonat, startTagInWelchemJahr);
        return startTag;
    }

    public int getStartTagImMonat() {
        return startTagImMonat;
    }

    public int getStartTagInWelchemMonat() {
        return startTagInWelchemMonat;
    }

    public int getStartTagInWelchemJahr() {
        return startTagInWelchemJahr;
    }

    public String getId() {
        return id;
    }
    public String getTitel() {
        return titel;
    }

    public GanztaegigerTermin(String pTitel, Tag pStartTag) {
        titel = pTitel;
        startTagImMonat = pStartTag.getTagImMonat();
        startTagInWelchemMonat = pStartTag.getInWelchemMonat();
        startTagInWelchemJahr = pStartTag.getInWelchemJahr();
        ganztaegig  = true;
    }

}
