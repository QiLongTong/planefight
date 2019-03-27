package per.plane.shoot;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {//相当于单发子弹
    BufferedImage img = Main.bullet;
    int x;
    int y;
    int stepPx = 6;
    public void step(){
        y -=stepPx;
    }
    public void paint(Graphics g){
        g.drawImage(img,x,y,null);
    }
    public boolean isOut(){
        return y<=-img.getHeight();
    }
}
