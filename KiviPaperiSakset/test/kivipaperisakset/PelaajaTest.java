package kivipaperisakset;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {
    static Pelaaja pelaaja = new Pelaaja();

    @BeforeEach
    void setUp() {
        pelaaja.setVoitot(1);
    }

    @Test
    void pelaajanValinta() {
        PelausVaihtoehdot pelaajanValinta = pelaaja.pelaajanValinta();
        assertTrue(pelaajanValinta == PelausVaihtoehdot.KIVI || pelaajanValinta == PelausVaihtoehdot.PAPERI || pelaajanValinta == PelausVaihtoehdot.SAKSET);
    }

    @Test
    void setVoitot() {
        pelaaja.setVoitot(2);
        assertEquals(2, pelaaja.getVoitot());
    }

    @Test
    void getVoitot() {
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    void lisaaVoitto() {
        pelaaja.lisaaVoitto();
        assertEquals(2, pelaaja.getVoitot());
    }

    @Test
    void pelaa() {
        Pelaaja vastustaja = new Pelaaja();
        Tulokset tulos = pelaaja.pelaa(vastustaja);
        assertTrue(tulos == Tulokset.VOITTO || tulos == Tulokset.HAVIO || tulos == Tulokset.TASAPELI);
    }
}