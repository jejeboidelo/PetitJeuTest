import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoucleJeu{
    public GameWindow window;
    public Player p1;


    public boolean isSpace = false;
    public BoucleJeu() {

        this.window = new GameWindow();

        p1 = new Player(new Point(100,100),3, window);

        this.window.addKeyListener(new KeyBoardEvent(p1,this));



        boucle();
    }

    public void boucle(){


        boolean isRunning= true;
        long wait;
        long before =System.currentTimeMillis();
        long after;
        long tempsdUpdate;
        long cummulTempsUpdate=0;

        int frames=0;

        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;


        while (isRunning) {

            after = System.currentTimeMillis();

            tempsdUpdate = after - before;
            before = System.currentTimeMillis();

            update();
            render();
            frames++;

            cummulTempsUpdate+=tempsdUpdate;


            while(cummulTempsUpdate >= 1000){
//                System.out.println(frames + " FPS");
                cummulTempsUpdate -= 1000;
                frames = 0;
            }


            wait = (OPTIMAL_TIME - tempsdUpdate) / 1000000;

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public void update(){
        p1.update();

    }
    public void render(){
        Toolkit.getDefaultToolkit().sync();
        Graphics2D g = (Graphics2D) window.getBuffer().getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,window.getWidth(), window.getHeight());
        g.setColor(Color.white);
        g.drawLine(window.getCanva().getWidth()-600,0,window.getCanva().getWidth()-600,window.getCanva().getHeight());

        p1.render(g);
        renderFps(g);

        g.dispose();
        window.getBuffer().show();

    }

    public void renderFps(Graphics2D g){
        int largeurrayon = 5;
        int coinhautgauche=window.getCanva().getWidth()-570;

        for(Rayon r: p1.listeRay){
            g.setColor(Color.white);
            g.fillRect(coinhautgauche,100+((365-(1460-r.distance)/2)/2),largeurrayon,(1460-r.distance)/2);
            coinhautgauche+=largeurrayon;
        }
    }
}
