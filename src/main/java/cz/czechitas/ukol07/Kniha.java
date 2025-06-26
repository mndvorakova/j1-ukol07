package cz.czechitas.ukol07;



public class Kniha {
    private String autor;
    private String nazev;
    private int rokVydani;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazevKnihy) {
        this.nazev = nazevKnihy;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    @Override
    public String toString() {
        return autor + ": " + nazev + "("+ rokVydani + ") " + rokVydani;
    }
}


