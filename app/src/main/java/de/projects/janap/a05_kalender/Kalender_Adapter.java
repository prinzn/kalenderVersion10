package de.projects.janap.a05_kalender;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Kalender_Adapter extends ArrayAdapter<Tag> {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Attribute
    private LayoutInflater inflater;
    private Kalender_GUI strg;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Konstruktor
    public Kalender_Adapter(Context pContext, ArrayList<Tag> pTage, Kalender_GUI pStrg){
        super(pContext, R.layout.zelle_aktueller_monat, pTage);
        inflater = LayoutInflater.from(pContext);
        strg = pStrg;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Methoden

    @Override
    public View getView(int position, View view, ViewGroup parent){
        try {
            Tag tag = getItem(position);

            //wenn covertView = 0 ist, wird eine neue Zelle festgelegt
            if (view == null) {
                view = inflater.inflate(R.layout.zelle_aktueller_monat, parent, false);
            }

            TextView textView = view.findViewById(R.id.textview_tag);
            textView.setText(String.valueOf(tag.getTagImMonat()));

            if ((tag.getTagImMonat() == Kalender_Steuerung.heute.get(Calendar.DAY_OF_MONTH))
                    && (tag.getInWelchemMonat() == Kalender_Steuerung.heute.get(Calendar.MONTH))
                    && (tag.getInWelchemJahr() == Kalender_Steuerung.heute.get(Calendar.YEAR))) {
                String aktuelleFarbedesMonats = Kalender_Steuerung.FARBEN[Kalender_Steuerung.kalender.get(Calendar.MONTH)];
                textView.setTextColor(Color.parseColor(aktuelleFarbedesMonats));  //beim heutigen Tag soll es eingefärbt werden
            }

            for (int i = 0; i < Kalender_Steuerung.termine.size(); i++) {
                if ((tag.getTagImMonat() == Kalender_Steuerung.termine.get(i).getStartTagImMonat())
                        && (tag.getInWelchemMonat()-1 == Kalender_Steuerung.termine.get(i).getStartTagInWelchemMonat()-1)
                        && (tag.getInWelchemJahr() == Kalender_Steuerung.termine.get(i).getStartTagInWelchemJahr())) {
                    textView.setTextColor(Color.parseColor("#960000"));  //beim heutigen Tag soll es eingefärbt werden
                }
            }

        return view;

    } catch (Exception e) {
        e.printStackTrace();
    }

     return view;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Ende der Klasse
}
