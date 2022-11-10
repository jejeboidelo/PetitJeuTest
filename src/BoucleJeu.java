import java.awt.*;

public class BoucleJeu {

    public Player p1= new Player(new Point(100,100));;
    public GameWindow window;
    public BoucleJeu() {
        this.window = new GameWindow();
        this.window.addKeyListener(new KeyBoardEvent(p1));
        boucle();
    }

    public void boucle(){

        window.getCanva().addKeyListener(new KeyBoardEvent(p1));



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
                System.out.println(frames + " FPS");
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

        p1.render(g);

        g.dispose();
        window.getBuffer().show();

    }
}
