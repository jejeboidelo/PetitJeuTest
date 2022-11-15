public class Vecteur {
    public int vitesseX, vitesseY;

    public Vecteur(int vitesseX, int vitesseY) {
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    @Override
    public String toString() {
        return "Vecteur{" +
                "vitesseX=" + vitesseX +
                ", vitesseY=" + vitesseY +
                '}';
    }
}
