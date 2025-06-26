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


}
