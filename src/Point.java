import java.awt.*;

public class Point {
    public int posx;
    public int posy;

    public Point(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    @Override
    public String toString() {
        return "{" +
                "posx=" + posx +
                ", posy=" + posy +
                '}';
    }

    public void move(Vecteur v){
        posx+= v.vitesseX;
        posy+= v.vitesseY;
    }


}
