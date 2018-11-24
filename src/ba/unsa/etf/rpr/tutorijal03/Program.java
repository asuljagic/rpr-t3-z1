package ba.unsa.etf.rpr.tutorijal03;


import java.util.Scanner;
import java.util.Set;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad;

public class Program {

    private static Scanner scanner = new Scanner(System.in);
    private static Scanner lineScanner = new Scanner(System.in);

    private static void ispisiMeni() {
        System.out.println(" -- ODABERITE JEDNU OD SLJEDECIH OPCIJA ----------------");
        System.out.println("1. Dodajte novi broj u imenik");
        System.out.println("2. Pretrazite broj osobe kosisteci ime");
        System.out.println("3. Pretrazite ime osobe koristeci broj");
        System.out.println("4. Pretrazite osobe cije ime pocinje odredjenim slovom");
        System.out.println("5. Pretrazite imena osoba koje dolaze iz odredjenog grada");
        System.out.println("6. Pretrazite brojeve fiksnih telefona osoba koje dolaze iz odredjenog grada");
        System.out.println("7. Za kraj");
        System.out.print("UNESITE VASU OPCIJU: ");
    }

    private static TelefonskiBroj unesiBroj() {
        System.out.println(" -- ODABERITE VRSTU TELEFONSKOG BROJA ---- ");
        System.out.println("1. Fiksni broj unutar BiH");
        System.out.println("2. Mobilni broj unutar BiH");
        System.out.println("3. Medjunarodni broj");
        System.out.print("UNESITE VASU OPCIJU: ");
        int numberType = scanner.nextInt();

        if (numberType == 1) {
            System.out.println(" -- Odabrali ste fiksni broj unutar BiH --");

            System.out.print("Unesite ime grada kojem pripada broj ovog fiksnog telefona: ");
            String cityName = scanner.next();
            Grad city = Grad.valueOf(cityName.toUpperCase());

            System.out.print("Unesite broj fiksnog telefona bez pozivnog broja: ");
            String numberWithoutCall = scanner.next();

            return new FiksniBroj(city, numberWithoutCall);
        } else if (numberType == 2) {
            System.out.println(" -- Odabrali ste mobilni broj unutar BiH --");

            System.out.print("Unesite pozivni broj mobilne mreze kojem broj koji dodajete pripada (BEZ 0 ISPRED): ");
            int callNumber = scanner.nextInt();

            System.out.print("Unesite broj mobilnog telefona bez pozivnog broja: ");
            String numberWithoutCall = scanner.next();

            return new MobilniBroj(callNumber, numberWithoutCall);
        } else if (numberType == 3) {
            System.out.println(" -- Odabrali ste medjunardoni broj --");

            System.out.print("Unesite pozivni broj drzave kojem broj koji dodajete pripada: ");
            String callNumber = scanner.next();

            System.out.print("Unesite broj bez pozivnog broja: ");
            String numberWithoutCall = scanner.next();

            return new MedunarodniBroj(callNumber, numberWithoutCall);
        } else {
            System.out.println("OPCIJA NE POSTOJI");
            return null;
        }
    }

    public static void main(String[] args) {
		Imenik contacts = new Imenik();

        while (true) {
            ispisiMeni();
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Unesite ime osobe koju zelite da dodate: ");
                String name = lineScanner.nextLine().trim();

                TelefonskiBroj number = unesiBroj();
                if (number != null) {
                    contacts.dodaj(name, number);
                }
            } else if (choice == 2) {
                System.out.print("Unesite ime osobe ciji broj trazite: ");
                String name = lineScanner.nextLine().trim();

                String number = contacts.dajBroj(name);
                if (number != null) {
                    System.out.print("Broj telefona osobe koju trazite je: ");
                    System.out.println(number);
                } else {
                    System.out.println("Za osobu ne postoji broj u imeniku!");
                }
            } else if (choice == 3) {
                TelefonskiBroj number = unesiBroj();

                if (number == null)
                    continue;

                String name = contacts.dajIme(number);

                if (name != null) {
                    System.out.print("Ime osobe koju trazite je: ");
                    System.out.println(name);
                } else {
                    System.out.println("Broj nije dodat u imenik!");
                }
            } else if (choice == 4) {
                System.out.println("Unesite zeljeno slovo: ");
                String tmp = scanner.next();

                char letter = tmp.charAt(0);
                String people = contacts.naSlovo(letter);
                if (people != null) {
                    System.out.println("Osobe cije ime pocinje na slovo " + letter + " su:");
                    System.out.println(people);
                } else {
                    System.out.println("U imeniku nema osoba cije ime pocinje unijeto slovo!");
                }
            } else if (choice == 5) {
                System.out.print("Unesite ime grada koji zelite da pretrazite: ");
                String cityName = scanner.next();
                Grad city = Grad.valueOf(cityName.toUpperCase());

                Set<String> names = contacts.izGrada(city);
                if (!names.isEmpty()) {
                    System.out.println("Osobe koje zive u gradu kojeg ste unijeli su: ");
                    for (String name : names) {
                        System.out.println(name);
                    }
                } else {
                    System.out.println("U imeniku nema osoba koje zive u gradu kojeg ste unijeli!");
                }
            } else if (choice == 6) {
                System.out.print("Unesite ime grada koji zelite da pretrazite: ");
                String cityName = scanner.next();
                Grad city = Grad.valueOf(cityName.toUpperCase());

                Set<TelefonskiBroj> numbers = contacts.izGradaBrojevi(city);
                if (!numbers.isEmpty()) {
                    System.out.println("Brojevi telefona osoba koje zive u gradu kojeg ste unijeli su: ");
                    for (TelefonskiBroj broj : numbers) {
                        System.out.println(broj.ispisi());
                    }
                } else {
                    System.out.println("U imeniku nema osoba koje zive u gradu kojeg ste unijeli!");
                }
            } else if (choice == 7) {
                System.out.println(" -- PROGRAM ZAVRSEN --");
                break;
            } else {
                System.out.println("OPCIJA NE POSTOJI");
            }
        }
    }
}
