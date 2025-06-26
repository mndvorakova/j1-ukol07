package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import cz.czechitas.ukol07.KnihaSluzba;
import cz.czechitas.ukol07.Kniha;


public class KnihaSluzbaTest {
    private final KnihaSluzba sluzba = new KnihaSluzba();

    @Test
    void celkovyPocetKnih() {
        List<Kniha> knihy = sluzba.getKnihy();
        assertEquals(14, knihy.size());
    }

    @Test
    void knihaPouzeJedna(){
        List<Kniha> knihy = sluzba.getKnihyPodleNazvu("R.U.R.");
        assertEquals(1, knihy.size(), "R.U.R. skladem 1 kus");
    }

    @Test
    void knihyPodleAutora(){
        List<Kniha> knihy = sluzba.getKnihyOdZadanehoAutora("Božena Němcová");
        assertEquals(4, knihy.size(), "Nalezeny 4 knihy");
    }

    @Test
    void knihyOdNeexistujicihoAutora(){
        List<Kniha> knihy = sluzba.getKnihyOdZadanehoAutora(null);
        assertTrue(knihy.isEmpty(), "Nalezeno 0 knih");
    }

    @Test
    void knihyRoku1856(){
        List<Kniha> knihy = sluzba.getKnihyZRoku(1856);
        assertEquals(2, knihy.size(), "Nalezeny 2 knihy");
    }

    @Test
    void knihyNeexistujicihoRoku(){
        List<Kniha> knihy = sluzba.getKnihyZRoku(2000);
        assertTrue(knihy.isEmpty(), "Nalezeno 0 knih z roku 2000");
    }

}
