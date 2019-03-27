package per.plane.shoot;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 这里是父类
 */
public class Enemy {
    BufferedImage img;
    int x,y;
    int stepPx ;

    public void step(){
        y +=stepPx;
        //移除画面重新出来
        if(y>=654){//屏幕的宽向下为y轴正方向
            init();
        }

    }

    /**
     * 从屏幕上边界出发
     */
    public void init() {
        y = -img.getHeight();//屏幕的上边界是y=0
        x = new Random().nextInt(400-img.getWidth());

    }

    public void paint(Graphics g){
        g.drawImage(img,x,y,null);
    }


    public boolean isOut() {
        return x<=-img.getWidth()||x>=400||y>=654;
    }
}
