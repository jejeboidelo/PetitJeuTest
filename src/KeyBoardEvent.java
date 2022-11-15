import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEvent implements KeyListener {

    public int avance = 0;
    public Player p;
    public BoucleJeu boucle;

    public KeyBoardEvent(Player p, BoucleJeu b) {
        this.p = p;
        this.boucle = b;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        presse(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pluspresse(e);
    }

    public void presse(KeyEvent e){
        if(e.getKeyCode() == 38)p.vitessey = -1;
        if(e.getKeyCode() == 40)p.vitessey = 1;
        if(e.getKeyCode() == 37)p.vitessex = -1;
        if(e.getKeyCode() == 39)p.vitessex = 1;

        if(e.getKeyCode() == 32){
            System.out.println(boucle.isSpace);
            boucle.isSpace = true;
        }
    }
    public void pluspresse(KeyEvent e){
        if(e.getKeyCode() == 38 || e.getKeyCode() == 40) p.vitessey = 0;
        if(e.getKeyCode() == 37 || e.getKeyCode() == 39) p.vitessex = 0;
        if(e.getKeyCode() == 32){
            boucle.isSpace = false;
        }
    }
}
