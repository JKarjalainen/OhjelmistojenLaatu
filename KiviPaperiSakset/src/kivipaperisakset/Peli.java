package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private boolean peliKaynnissa;
    private int tasapelit;
    private int era;

    private final int VOITTOJEN_MAARA = 3;

    public Peli() {
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peliKaynnissa = true;
        tasapelit = 0;
        era = 1;
    }
    /**
     * Metodi, joka pelaa pelin.
     */
    public void pelaa() {
        do {
            System.out.println("Era: " + era);

            Tulokset tulos = pelaaja1.pelaa(pelaaja2);

            if(tulos == Tulokset.VOITTO) {
                System.out.println("Pelaaja 1 voitti!");
                pelaaja1.lisaaVoitto();
            } else if (tulos == Tulokset.HAVIO) {
                System.out.println("Pelaaja 2 voitti!");
                pelaaja2.lisaaVoitto();
            } else {
                System.out.println("Tasapeli!");
                tasapelit++;
            }

            if(pelaaja1.getVoitot() >= VOITTOJEN_MAARA || pelaaja2.getVoitot() >= VOITTOJEN_MAARA) {
                peliKaynnissa = false;
            }

            era++;

            tulostaTulos(pelaaja1, pelaaja2, tasapelit);

        } while (peliKaynnissa);

        katsoVoittaja(pelaaja1, pelaaja2);
    }

    /**
     * Metodi, joka tulostaa pelin tuloksen.
     * @param pelaaja1 pelaaja 1
     * @param pelaaja2 pelaaja 2
     * @param tasapelit tasapelien lukumäärä
     */
    private static void tulostaTulos(Pelaaja pelaaja1, Pelaaja pelaaja2, int tasapelit) {
        System.out.println("Pelaaja 1 voitot: " + pelaaja1.getVoitot());
        System.out.println("Pelaaja 2 voitot: " + pelaaja2.getVoitot());
        System.out.println("Tasapelit: " + tasapelit);
        System.out.println();
    }
    /**
     * Metodi, joka katsoo kumpi pelaaja voitti pelin. Ja tulostaa sen.
     * @param pelaaja1 pelaaja 1
     * @param pelaaja2 pelaaja 2
     */
    private static void katsoVoittaja(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        if(pelaaja1.getVoitot() > pelaaja2.getVoitot()) {
            System.out.println("Pelaaja 1 voitti pelin!");
        } else {
            System.out.println("Pelaaja 2 voitti pelin!");
        }
    }
}
