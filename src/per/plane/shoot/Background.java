
package per.plane.shoot;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 背景图片大小480*852
 * 背景要向下移动
 * 背景图片上下绘制两张
 * 一张向下移出画面，瞬间回到顶部
 */
public class Background {
    BufferedImage img = Main.background;//加载背景
    int x1,y1,x2,y2=-852,stepPx=2;   //移动步调
    //移动一帧
    public void step(){
        y1 +=stepPx;
        y2 +=stepPx;
        if(y1>=852) y1= -852;
        if(y2>=852) y2=-852;
    }
    //绘制自身方法
    public void paint(Graphics g){
        g.drawImage(img,x1,y1,null);
        g.drawImage(img,x2,y2,null);
    }
}
