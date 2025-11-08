package service;

import lombok.ToString;

@ToString
public abstract class BebidaTemplate {
    protected int agua;
    protected int temperatura;

    public BebidaTemplate(int agua, int temperatura) {
        setAgua(agua);
        setTemperatura(temperatura);
    }

    public BebidaTemplate() {
        this(250, 100);
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = (agua > 0) ? agua : 250;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = (temperatura > 0 && temperatura <= 100) ? temperatura : 100;
    }

    public final void prepararBebida() {
        hervirAgua();
        prepararIngrediente();
        servirEnTaza();
        agregarCondimentos();
        hook();
    }

    protected void hervirAgua() {
        System.out.println("Hirviendo " + agua + "ml de agua a " + temperatura + "°C");
    }

    protected void servirEnTaza() {
        System.out.println("Sirviendo en la taza");
    }

    protected abstract void prepararIngrediente();

    protected abstract void agregarCondimentos();

    protected void hook() {}
}
