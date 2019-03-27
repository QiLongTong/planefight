package per.plane.shoot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    static BufferedImage[] airplanes = new BufferedImage[5];
    static BufferedImage background;
    static BufferedImage[] bees = new BufferedImage[5];
    static BufferedImage[] bigplanes = new BufferedImage[5];
    static BufferedImage bullet;
    static BufferedImage gameover;
    static BufferedImage[] heros = new BufferedImage[6];
    static BufferedImage pause;
    static BufferedImage start;
    public static void main(String[] args) throws IOException {
        background = ImageIO.read(Main.class.getResource("/imgs/background.png"));
        bullet = ImageIO.read(Main.class.getResource("/imgs/bullet.png"));
        gameover = ImageIO.read(Main.class.getResource("/imgs/gameover.png"));
        pause = ImageIO.read(Main.class.getResource("/imgs/pause.png"));
        start = ImageIO.read(Main.class.getResource("/imgs/start.png"));

        for(int i=0;i<airplanes.length;i++){
            airplanes[i] = ImageIO.read(Main.class.getResource("/imgs/airplane"+i+".png"));
        }
        for(int i=0;i<bees.length;i++){
            bees[i] = ImageIO.read(Main.class.getResource("/imgs/bee"+i+".png"));
        }
        for(int i=0;i<bigplanes.length;i++){
            bigplanes[i] = ImageIO.read(Main.class.getResource("/imgs/bigplane"+i+".png"));
        }
        for(int i=0;i<heros.length;i++){
            heros[i] = ImageIO.read(Main.class.getResource("/imgs/hero"+i+".png"));
        }
        //窗口
        JFrame f = new JFrame();
        f.setTitle("飞机大战");
        f.setSize(400,654);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //面板中放着背景，面板在窗口中，最后让游戏面板动起来
        GamePanel gamePanel = new GamePanel();
        f.add(gamePanel);
        //让窗口适应内部面板大小
        f.pack();

        f.setVisible(true);
        //游戏面板动起来
        gamePanel.action();
    }

}
