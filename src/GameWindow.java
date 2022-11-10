import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedInputStream;

public class GameWindow extends JFrame {

    public static Dimension dimension = new Dimension(600,400);
    private Canvas canva = new Canvas();


    public GameWindow() {
        this.setTitle("Ma belle fenetre");
        this.setSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
//        this.setResizable(false);
//        this.pack();
        this.setLocationRelativeTo(null);
        this.add(canva);
        this.setVisible(true);

        canva.createBufferStrategy(3);




    }

    public BufferStrategy getBuffer(){
        return canva.getBufferStrategy();
    }
    public Canvas getCanva(){return canva;}
}
