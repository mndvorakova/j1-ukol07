package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {

    private static List<Kniha> knihy1845;

    public static void main(String[] args) {
        KnihaSluzba sluzba = new KnihaSluzba(); //instance třídy KnihaSluzba

        System.out.println("Celkový počet knih " + sluzba.getKnihy().size());

        System.out.println("Knihy Karel Čapek: " + sluzba.getKnihyOdZadanehoAutora("Karel Čapek"));

        System.out.println("Knihy vydané roku 1845: ");
        List<Kniha> knihy1845 = sluzba.getKnihyZRoku(1845);
        for (Kniha kniha : knihy1845) {
            System.out.println(kniha.getAutor() + ": " + kniha.getNazev());
        }

    }

}
