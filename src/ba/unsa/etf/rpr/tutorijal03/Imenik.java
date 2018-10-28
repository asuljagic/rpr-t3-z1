package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {
    private static final Object Map = "" ;

    public enum Grad{SARAJEVO,ZENICA,TUZLA,ORASJE,BIHAC,TRAVNIK,
        LIVNO, SIROKIBRIJEG,MOSTAR,BRCKO, GORAZDE};
    private HashMap<String, TelefonskiBroj> imenikMapa;
    //konst bez param cisto da kreira novi imenik
    public Imenik() {
        imenikMapa = new HashMap<String, TelefonskiBroj>();
    }

    public void dodaj(String ime, TelefonskiBroj broj){
        imenikMapa.put(ime,broj);
    }

    public String dajBroj(String ime){
        return imenikMapa.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj){
        //bice implementirano naknadno
    }

    public String naSlovo(char s){
        Map.Entry<String, TelefonskiBroj> prolaz;
        int i = 1;
        String brojevi = "";
        for(prolaz : imenikMapa.entrySet()){ //prolazi kroz imenik
            if(prolaz.getKey().charAt(0) == s) //ako se prvo slovo poklapa
                brojevi = i++ + ". " + prolaz.getKey() + " - " + prolaz.getValue().ispisi() + "\n";
        }
        return brojevi;
    }
}
