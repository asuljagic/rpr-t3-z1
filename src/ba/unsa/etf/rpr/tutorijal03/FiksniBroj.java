package ba.unsa.etf.rpr.tutorijal03;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    public enum Grad{SARAJEVO,ZENICA,TUZLA,ORASJE,BIHAC,TRAVNIK,
        LIVNO, SIROKIBRIJEG,MOSTAR,BRCKO, GORAZDE};
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        String pozivniBroj = new String();
        switch (getGrad()) {
            case TRAVNIK:
                pozivniBroj += "030";
                break;
            case ORASJE:
                pozivniBroj += "031";
                break;
            case ZENICA:
                pozivniBroj += "032";
                break;
            case SARAJEVO:
                pozivniBroj += "033";
                break;
            case LIVNO:
                pozivniBroj += "034";
                break;
            case TUZLA:
                pozivniBroj += "035";
                break;
            case MOSTAR:
                pozivniBroj += "036";
                break;
            case BIHAC:
                pozivniBroj += "037";
                break;
            case GORAZDE:
                pozivniBroj += "038";
                break;
            case SIROKIBRIJEG:
                pozivniBroj += "039";
                break;
            case BRCKO:
                pozivniBroj += "049";
                break;
        }

        pozivniBroj += "/" + broj;
        return pozivniBroj;
    }

        @Override
        public int hashCode() {
            return getGrad().hashCode() + broj.hashCode();
        }

    @Override
    public int compareTo(Object o){                                     // compareTo override za poredenje
        FiksniBroj broj = (FiksniBroj) o;
        return this.ispisi().compareTo(broj.ispisi());
    }


}
