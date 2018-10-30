package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;
import ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad;

public class Imenik {
    private static final Object Map = "" ;

    public enum Grad{SARAJEVO,ZENICA,TUZLA,ORASJE,BIHAC,TRAVNIK,
        LIVNO, SIROKIBRIJEG,MOSTAR,BRCKO, GORAZDE};
    private HashMap<String, TelefonskiBroj> imenikMapa = new HashMap<>();
    //konst bez param cisto da kreira novi imenik
    public Imenik() {
        imenikMapa = new HashMap<String, TelefonskiBroj>();
    }

     void dodaj(String ime, TelefonskiBroj broj){
        imenikMapa.put(ime,broj);
    }

    public String dajBroj(String ime){
        return imenikMapa.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj){
        String s="Ne postoji ime i prezime";
        for(Map.Entry<String, TelefonskiBroj> entry : imenikMapa.entrySet()){
            if(entry.getValue().equals(broj))
                return entry.getKey();
        }
        return s;
    }

    public String naSlovo(char s){
        int i = 0;
        String brojevi = "";
        for(Map.Entry<String, TelefonskiBroj> entry : imenikMapa.entrySet()){ //prolazi kroz imenik
            if(entry.getKey().charAt(0) == s) { //ako se prvo slovo poklapa
                ++i;
                brojevi = i + ". " + entry.getKey() + " - " + entry.getValue().ispisi() + "\n";
            }
        }
        return brojevi;
    }

    public Set<String> izGrada(FiksniBroj.Grad g){
        TreeSet<String> skupinaImena = new TreeSet<>(); //pogodno zbog sortiranja skupa
        for (Map.Entry<String,TelefonskiBroj> entry : imenikMapa.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                if(( (FiksniBroj)entry.getValue()).getGrad().equals(g))
                    skupinaImena.add(entry.getKey());
            }
        }
        return skupinaImena;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){

        TreeSet<TelefonskiBroj> imenaLjudi = new TreeSet<>();
        for (Map.Entry<String,TelefonskiBroj> entry : imenikMapa.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                if(( (FiksniBroj)entry.getValue()).getGrad().equals(g))
                    imenaLjudi.add(entry.getValue());
            }
        }

        return imenaLjudi;

    }
}
