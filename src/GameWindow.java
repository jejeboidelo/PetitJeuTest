import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedInputStream;

public class GameWindow extends JFrame {

    public static Dimension dimension = new Dimension(1750,900);
    private Canvas canva = new Canvas();
    private Canvas fps = new Canvas();


    public GameWindow() {
        this.setTitle("ma fenetre");

        this.setSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
//        this.setResizable(false);
//        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        canva.setSize(500,500);
        this.add(canva);
        canva.setSize(500,500);


        canva.createBufferStrategy(3);


    }

    public BufferStrategy getBuffer(){
        return canva.getBufferStrategy();
    }
    public Canvas getCanva(){return canva;}
}
