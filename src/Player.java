import java.awt.*;

public class Player {
    public Point position;
    public int orientaion;

    public int vitessex=0, vitessey=0;

    public Player(Point position) {
        this.position = position;
        this.orientaion = 180;
    }

    public void update(){

        this.position.setPosx(position.posx+=vitessex);
        this.position.setPosy(position.posy+=vitessey);

    }
    public void render(Graphics2D g) {
        g.setColor(Color.white);
//        g.fillRect(position.posx-5, position.posy-5, 10,10);
        g.fillPolygon(new int[] {position.posx-4, position.posx, position.posx+4}, new int[] {position.posy+6, position.posy-6, position.posy+6}, 3);
    }
}
