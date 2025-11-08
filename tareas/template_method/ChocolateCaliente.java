package service;

public class ChocolateCaliente extends BebidaTemplate {
    private double porcentajeCacao;

    public ChocolateCaliente(int agua, int temperatura, double porcentajeCacao) {
        super(agua, temperatura);
        setPorcentajeCacao(porcentajeCacao);
    }

    public ChocolateCaliente(double porcentajeCacao) {
        super(300, 85);
        setPorcentajeCacao(porcentajeCacao);
    }

    public ChocolateCaliente() {
        this(70.0);
    }

    public double getPorcentajeCacao() {
        return porcentajeCacao;
    }

    public void setPorcentajeCacao(double porcentajeCacao) {
        this.porcentajeCacao = (porcentajeCacao > 0 && porcentajeCacao <= 100) ? porcentajeCacao : 70.0;
    }

    @Override
    protected void prepararIngrediente() {
        System.out.println("Derritiendo chocolate al " + porcentajeCacao + "% de cacao");
        System.out.println("Mezclando con agua caliente");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando crema batida");
    }

    @Override
    protected void hook() {
        System.out.println("Espolvoreando canela en polvo");
        System.out.println("Agregando malvaviscos");
    }
}
