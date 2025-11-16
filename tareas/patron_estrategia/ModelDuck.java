package service;

@lombok.ToString
public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior = new FlyLikeRocket();
        soundBehavior = new muteSound();
    }
    @Override
    public void display() {
        System.out.println("... ...");
    }
}
