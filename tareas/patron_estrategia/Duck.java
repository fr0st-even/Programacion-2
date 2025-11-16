package service;

import lombok.Getter;
import lombok.Setter;

@lombok.ToString
public abstract class Duck {
    @Setter
    protected FlyBehavior flyBehavior;
    @Getter
    @Setter
    protected SoundBehavior soundBehavior;

    public  abstract void display();

    public void swim(){
        System.out.println("nadar");
    }
    public void performfly(){
        flyBehavior.fly();
    }
    public void Quack(){
        soundBehavior.makeSound();
    }

}
