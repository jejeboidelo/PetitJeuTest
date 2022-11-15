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
        // Distance max = 1460, min =0
        int largeurrayon = 5;
        int originGauche=window.getCanva().getWidth()-570;
        int hauteurMaxMure = 1460/2;

//        int distPrec = p1.listeRay.get(0).distance;
        for(Rayon r: p1.listeRay){
//            int distAct = r.distance;
//            if(distAct-distPrec<0){
//                g.setColor(Color.black);
//            }else {
//                g.setColor(Color.gray);
//            }
            g.setColor(Color.gray);
            int hauteurMur = (1460-r.distance)/2;
            g.fillRect(originGauche,(hauteurMaxMure-hauteurMur)/2,largeurrayon,hauteurMur);

            g.setColor(new Color(97, 16, 3));
            g.fillRect(originGauche,((hauteurMaxMure-hauteurMur)/2)+hauteurMur,largeurrayon,(hauteurMaxMure-hauteurMur)/2);


            originGauche+=largeurrayon;
        }
    }
}
