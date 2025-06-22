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
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) { //načte soubory z knihy.json
            ObjectMapper objectMapper = new ObjectMapper();
            knihy = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {
            });  //načtení knih
        } catch (IOException e) {  //ošetření výjimky
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Kniha> getKnihy() {
        return knihy;
    }
}
