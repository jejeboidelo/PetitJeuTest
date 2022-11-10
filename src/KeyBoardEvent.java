import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEvent implements KeyListener {

    public int avance = 0;
    public Player p;

    public KeyBoardEvent(Player p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 38) {
            p.vitessey = -1;
        }
        if(e.getKeyCode() == 40)p.vitessey = 1;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        p.vitessey = 0;
    }
}
