package ba.unsa.etf.rpr.tutorijal03;

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

    @Override
    public int hashCode() {
        if(this.grad==Grad.TRAVNIK)return 30;
        if(this.grad==Grad.ORASJE)return 31;
        if(this.grad==Grad.ZENICA)return 32;
        if(this.grad==Grad.SARAJEVO)return 33;
        if(this.grad==Grad.LIVNO)return 34;
        if(this.grad==Grad.TUZLA)return 35;
        if(this.grad==Grad.MOSTAR)return 36;
        if(this.grad==Grad.BIHAC)return 37;
        if(this.grad==Grad.GORAZDE)return 38;
        if(this.grad==Grad.SIROKIBRIJEG)return 39;
        if(this.grad==Grad.BRCKO)return 49;
        return 0;
    }
    @Override
    public String ispisi(){
        return "0" + grad.hashCode() + "/" + broj; //format npr 033/123-456
    }
}
