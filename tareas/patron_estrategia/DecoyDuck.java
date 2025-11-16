package service;
@lombok.ToString

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        soundBehavior = new muteSound();
    }

    @Override
    public void display() {
        System.out.println("... ...");
    }
}
