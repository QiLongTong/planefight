package per.plane.shoot;

public class Weapon {
    public Bullet[] fire(Hero hero){
        //双发
        Bullet[] a = new Bullet[2];
        a[0] = new Bullet();
        a[1] = new Bullet();
        a[0].x = hero.x+hero.img.getWidth()-78;
        a[1].x = hero.x+hero.img.getWidth()-18-a[1].img.getWidth();
        a[0].y = hero.y+40;
        a[1].y = hero.y+40;
        //判断两个子弹是否在画面外
        for(int i=0;i<a.length;i++){
            Bullet b = a[i];
            if(b.isOut()){
                a[i]=null;
            }
        }
        return a;
    }
}
