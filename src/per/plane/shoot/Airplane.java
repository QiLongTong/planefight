package per.plane.shoot;

public class Airplane extends Enemy{
    //构造函数初始化
    public Airplane(){
        img = Main.airplanes[0];
        stepPx = 4;
        init();
    }
}
