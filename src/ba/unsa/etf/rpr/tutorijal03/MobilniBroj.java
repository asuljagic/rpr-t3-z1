package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public int hashCode(){
        return mobilnaMreza;
    }

    @Override
    public String ispisi(){
        return "0" + mobilnaMreza + "/" + broj;
    }


}
