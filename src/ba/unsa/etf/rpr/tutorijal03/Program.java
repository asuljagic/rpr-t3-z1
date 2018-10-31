package ba.unsa.etf.rpr.tutorijal03;


import java.util.Set;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.SARAJEVO;

public class Program {

    public static void main(String[] args) {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj: set) {
            result += broj.ispisi() + ",";
        }

        System.out.println(result);

    }
}
