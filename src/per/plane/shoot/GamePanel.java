package per.plane.shoot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 自定义面板
 * 将背景放入到面板中
 */
public class GamePanel extends JPanel {
    Background bg = new Background();
    Hero hero = new Hero();

    //定义一个敌机数组
    ArrayList<Enemy> enemies = new ArrayList<>();
    //定义一个静态帧数
    static int counter;
    ArrayList<Bullet> bullets = new ArrayList<>();

    public GamePanel(){
        //设置面板的期望大小
        setPreferredSize(new Dimension(400,654));
    }

    @Override
    public void paint(Graphics g) {
        bg.paint(g);//这里是调用游戏背景绘制自身
        hero.paint(g);//此处是调用英雄机自己绘制
        //绘制所有敌人
        paintEnemy(g);
        paintBullet(g);
    }

    private void paintBullet(Graphics g) {
        for(Iterator iterator=bullets.iterator();iterator.hasNext();){
            Bullet b = (Bullet)iterator.next();
            b.paint(g);
        }
    }

    private void paintEnemy(Graphics g) {
        //遍历敌人绘制敌人
        for(Iterator iterator = enemies.iterator();iterator.hasNext();){
            Enemy e =(Enemy)iterator.next();
            e.paint(g);
        }
    }

    //动起来
    public void action(){
        //监听器，监听鼠标在面板上的动作
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //设置英雄要移动到的新的目标位置
                hero.moveTo(e.getX(),e.getY());
            }
        });
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                counter++;
                bg.step();
                hero.step();
                //敌人随机出现
                enemyIn();
                //敌人移动一步
                enemyStep();
                bulletIn();
                bulletStep();
                repaint();//重新绘制
            }
        },0,1000/60);//以60fps帧速率来执行
    }

    private void bulletIn() {
        if(counter%15!=0) return ;
        Bullet[] a = hero.shoot();
        for(int i=0;i<a.length;i++){
            Bullet b = a[i];
            if(b!=null){
                bullets.add(b);
            }
        }
    }

    private void bulletStep() {
        for(Iterator iterator=bullets.iterator();iterator.hasNext();){
            Bullet b = (Bullet)iterator.next();
            b.step();
            if(b.isOut()){
                iterator.remove();
            }
        }
    }

    private void enemyIn() {
        if(counter%30!=0) return ; //结束此方法
        double d = Math.random();
        if(d<0.6){
            enemies.add(new Airplane());
        }else if(d<0.9){
            enemies.add(new BigPlane());
        }else{
            enemies.add(new Bee());
        }
    }

    private void enemyStep() {
        for(Iterator iterator=enemies.iterator();iterator.hasNext();){
            Enemy e = (Enemy) iterator.next();
            e.step();
            if(e.isOut()){
                iterator.remove();
            }
        }
    }

}
