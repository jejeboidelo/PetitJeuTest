import java.awt.*;
import java.util.ArrayList;

public class Player {
    public Point position = new Point(10,10);
    public int orientation ;

    public int vitessex=0, vitessey=0;
    public Point
            pointun,
            pointeTria,
            pointtrois;

    ArrayList<Rayon> listeRay = new ArrayList<>();

    public Player(Point position, int nBRayon, GameWindow window) {
        this.position = position;
        this.orientation = 90;
        pointun = new Point(position.posx-40,position.posy+60);
        pointeTria = new Point(position.posx,position.posy-60);
        pointtrois = new Point(position.posx+40,position.posy+60);

        for(int i =-50; i<=50; i= i+1){
            System.out.println(i);
            listeRay.add(new Rayon(position, (double) i, window));
        }
//        listeRay.add(new Rayon(position, (double) -5));
//        listeRay.add(new Rayon(position, (double) 0));
//        listeRay.add(new Rayon(position, (double) 5));

    }

    public void update(){


//        this.position.setPosy(position.posy+=vitessey);
//        pointun = rotate(pointun,position,10);
//        pointdeux = rotate(pointdeux,position,10);
//        pointtrois = rotate(pointtrois,position,10);

        if (vitessex != 0){
            orientation-=vitessex*5;
            if (360< orientation)orientation%=360;
            if (orientation<0)orientation=360-orientation;

        }

//        this.position.setPosy(position.posy+=vitessey);
        double angleradian = (orientation * (Math.PI / 180));
//        System.out.println(angleradian);
        Vecteur deplacement = new Vecteur((int) -Math.round(Math.cos(angleradian)*vitessey*10), (int) Math.round(Math.sin(angleradian)*vitessey*10));
//        System.out.println(deplacement);
        nextPosOutside(deplacement);

        pointun = new Point(position.posx-6,position.posy-4);
        pointeTria = new Point(position.posx+6,position.posy);
        pointtrois = new Point(position.posx-6,position.posy+4);
//
        pointun = rotate(pointun,orientation);
        pointeTria = rotate(pointeTria,orientation);
        pointtrois = rotate(pointtrois,orientation);

        for(Rayon r: listeRay){
            r.update(position, orientation);
        }


    }
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        g.fillPolygon(new int[] {pointun.posx, pointeTria.posx, pointtrois.posx}, new int[] {pointun.posy, pointeTria.posy, pointtrois.posy}, 3);

        for(Rayon r: listeRay){
            r.render(g);
        }
    }

    public Point rotate (Point M, double angle) { //M = point a transformer, O = centre de la transfo, angle = angle en degrée
        long xM, yM;
        double x, y;
        angle *= (Math.PI / 180);
        xM = M.posx - this.position.posx;
        yM = M.posy - this.position.posy;
        x = (xM * Math.cos (angle) + yM * Math.sin (angle) + this.position.posx);
        y = (- xM * Math.sin (angle) + yM * Math.cos (angle) + this.position.posy);
        return new Point((int) Math.round(x), (int) Math.round(y));
    }

    public void nextPosOutside(Vecteur v){
        if ((position.posx+v.vitesseX<0 || position.posx+v.vitesseX>GameWindow.dimension.width) && (position.posy+v.vitesseY<0 || position.posy+v.vitesseY>GameWindow.dimension.height-50)){
            position.move(new Vecteur(0, 0));
        } else if(position.posx+v.vitesseX<0 || position.posx+v.vitesseX>GameWindow.dimension.width){
            position.move(new Vecteur(0, v.vitesseY));
        } else if (position.posy+v.vitesseY<0 || position.posy+v.vitesseY>GameWindow.dimension.height-50) {
            position.move(new Vecteur(v.vitesseX,0));
        } else {
            position.move(v);
        }
    }
}
