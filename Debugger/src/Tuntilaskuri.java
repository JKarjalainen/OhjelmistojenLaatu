public class Tuntilaskuri {
    private int tunti;
    public Tuntilaskuri() {
        tunti = 0;
    }
    public void etene() {
        tunti++;
        if (tunti == 24) {
            tunti = 0;
        }
    }
    public int getTunti() {
        return tunti;
    }
}
