package per.plane.shoot;

public class Bee extends Enemy {

    int dx;

    public Bee() {
        img = Main.bees[0];
        stepPx=6;
        init();
    }
    //这里蜜蜂重写了初始化方法
    @Override
    public void init() {
        super.init();
        if(Math.random()<0.5){
            dx=-1;
        }else{
            dx=1;
        }
    }
    //重写移动的方法
    @Override
    public void step() {
        super.step();
        x +=dx;
    }
}
