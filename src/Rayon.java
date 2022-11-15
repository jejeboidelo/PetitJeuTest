import java.awt.*;

public class Rayon {
    public Point depart;
    public Point arrive;
    public Double orientationRelativePerso;

    public GameWindow window;
    public int distance =0;


    public Rayon(Point depart, Double orientation, GameWindow window) {
        this.depart = new Point(depart.posx,depart.posy);
        this.arrive = new Point(depart.posx,depart.posy);
        this.orientationRelativePerso = orientation;
        this.window = window;
    }

    public void update(Point depart, int orien){
        this.depart = new Point(depart.posx,depart.posy);
        this.arrive = new Point(depart.posx,depart.posy);
        double orientation = orien + orientationRelativePerso;

        if (360< orientation)orientation%=360;
        if (orientation<0)orientation=360-orientation;



        double angleradian = (orientation * (Math.PI / 180));


        Vecteur deplacement = new Vecteur((int) Math.round(Math.cos(angleradian)*100), (int) Math.round(Math.sin(angleradian)*100));

//        System.out.println("depart (position) : "+this.depart+ " arrivé : "+this.arrive+ " vecteur : "+deplacement);

//        System.out.println(arrive);
//        System.out.println(arrive.posy>0 +" "+ arrive.posy< GameWindow.dimension.height-50 && arrive.posx <0 && arrive.posx < GameWindow.dimension.width);
        while (0 < arrive.posy && arrive.posy< window.getCanva().getHeight() && 0<arrive.posx  && arrive.posx < window.getCanva().getWidth()-600){
//            System.out.println("boucle");
            arrive.posx+= deplacement.vitesseX;
            arrive.posy-= deplacement.vitesseY;
//            System.out.println(arrive);
        }
        arrive.posx-= deplacement.vitesseX;
        arrive.posy+= deplacement.vitesseY;

        deplacement = new Vecteur((int) Math.round(Math.cos(angleradian)*5), (int) Math.round(Math.sin(angleradian)*5));

        while (0 < arrive.posy && arrive.posy< window.getCanva().getHeight() && 0<arrive.posx  && arrive.posx < window.getCanva().getWidth()-600){
//            System.out.println("boucle");
            arrive.posx+= deplacement.vitesseX;
            arrive.posy-= deplacement.vitesseY;
//            System.out.println(arrive);
        }
        arrive.posx-= deplacement.vitesseX;
        arrive.posy+= deplacement.vitesseY;


        distance = (int) Math.round(
                Math.sqrt(
                        Math.pow(arrive.posx-depart.posx,2)
                        +Math.pow(arrive.posy-depart.posy,2)
                ));
//        System.out.println("#####################################################################################################################");

    }

    public void render(Graphics2D g){
        g.setColor(Color.white);
        g.drawLine(depart.posx,depart.posy,arrive.posx,arrive.posy);
        g.setColor(Color.red);
        g.fillRect(arrive.posx-1, arrive.posy-1, 3,3);
    }
}
