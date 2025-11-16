package service;
@lombok.ToString
public class FlyLikeRocket implements FlyBehavior{
    public FlyLikeRocket() {
    }
    @Override
    public void fly() {
        System.out.println("Volar cual cohete y atacar como bolido");
    }
}
