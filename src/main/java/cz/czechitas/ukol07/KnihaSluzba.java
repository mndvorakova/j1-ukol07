package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class KnihaSluzba {
    private List<Kniha> knihy;


    public KnihaSluzba() {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("/cz/czechitas/ukol07/knihy.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            knihy = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {});
        } catch (IOException | NullPointerException e) {
            System.err.println("Chyba při načítání knih: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Kniha> getKnihy() {
        return knihy;
    }

    public List<Kniha> getKnihyOdZadanehoAutora(String autor) {
        return knihy.stream()
                .filter(kniha -> kniha.getAutor()
                        .equalsIgnoreCase(autor)) //ošetření malá velká písmena
                .toList(); //vrátíme zpět na List

    }

    public List<Kniha> getKnihyZRoku(int rok) {
        return knihy.stream()
                .filter(kniha -> kniha.getRokVydani() == rok)
                .toList();
    }

    public List<Kniha> getKnihyPodleNazvu(String nazev) {
        return knihy.stream()
                .filter(kniha -> kniha.getNazev().equalsIgnoreCase(nazev))
                .toList();

    }

}
