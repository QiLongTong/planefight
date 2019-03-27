package per.plane.shoot;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero {
    BufferedImage[] imgs = Main.heros;
    BufferedImage img = imgs[1];
    //当前位置坐标
    int x=200-img.getWidth()/2,y=654-img.getHeight()-100;
    int tx=x,ty=y;//移动的目标位置
    Weapon weapon = new Weapon();
    /**
     * 接收的参数是鼠标位置
     * 把鼠标位置，设置成下一步移动的目标位置
     * @param tx
     * @param ty
     */
    public void moveTo(int tx,int ty){
        this.tx = tx-img.getWidth()/2;
        this.ty = ty-img.getWidth()/2;
    }

    //移动一帧
    public void step(){
        if(x==tx&&y==ty){
            img = imgs[1];//没有移动
        }else{//把x,y移动到tx,ty
          img=imgs[0];//使用加速图片
          x=tx;
          y=ty;
        }
    }

    //从参数中拿到画布，把自己画在画布上这里是英雄机的
    public void paint(Graphics g){
        g.drawImage(img,x,y,null);//画英雄机自己
    }
    //英雄射击
    public Bullet[] shoot(){
        return weapon.fire(this);
    }
}
