
package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitot;      // Voittojen lukumäärä

    /**
     * Konstruktori, joka alustaa voitot nollaksi.
     */
    public Pelaaja() {
        voitot = 0;
    }

    /**
     * Metodi, joka arpoo pelaajan valinnan.
     * @return pelaajan valinta
     */
    public PelausVaihtoehdot pelaajanValinta() {
        int valinta = (int) (Math.random() * 3);
        switch (valinta) {
            case 0:
                return PelausVaihtoehdot.KIVI;
            case 1:
                return PelausVaihtoehdot.PAPERI;
            case 2:
                return PelausVaihtoehdot.SAKSET;
            default:
                return PelausVaihtoehdot.KIVI;
        }
    }


    public void setVoitot(int voitot) {
        this.voitot = voitot;
    }

    public int getVoitot() {
        return voitot;
    }


    /**
     * Metodi, joka lisää voiton.
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Metodi, joka pelaa yhden kierroksen.
     * @param vastustaja vastustaja
     * @return kierroksen tulos
     */
    public Tulokset pelaa(Pelaaja vastustaja) {
        PelausVaihtoehdot pelaajanValinta = pelaajanValinta();
        PelausVaihtoehdot vastustajanValinta = vastustaja.pelaajanValinta();

        System.out.println("Pelaaja 1 valitsi: " + pelaajanValinta);
        System.out.println("Pelaaja 2 valitsi: " + vastustajanValinta);

        if(pelaajanValinta == vastustajanValinta) {
            return Tulokset.TASAPELI;
        } else if (pelaajanValinta == PelausVaihtoehdot.KIVI && vastustajanValinta == PelausVaihtoehdot.SAKSET) {
            return Tulokset.VOITTO;
        } else if (pelaajanValinta == PelausVaihtoehdot.PAPERI && vastustajanValinta == PelausVaihtoehdot.KIVI) {
            return Tulokset.VOITTO;
        } else if (pelaajanValinta == PelausVaihtoehdot.SAKSET && vastustajanValinta == PelausVaihtoehdot.PAPERI) {
            return Tulokset.VOITTO;
        } else {
            return Tulokset.HAVIO;
        }
    }
}
