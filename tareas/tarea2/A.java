package service;

public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    public A(){

        this(new B());
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
