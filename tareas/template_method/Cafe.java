package service;

import lombok.ToString;

@ToString
public class Cafe extends BebidaTemplate{
    private String tipoGrano;

    public Cafe(int agua, int temperatura, String tipoGrano) {
        super(agua, temperatura);
        setTipoGrano(tipoGrano);
    }

    public Cafe(String tipoGrano) {
        super(250, 95);
        setTipoGrano(tipoGrano);
    }

    public Cafe() {
        this("Arábica");
    }

    public String getTipoGrano() {
        return tipoGrano;
    }

    public void setTipoGrano(String tipoGrano) {
        this.tipoGrano = (tipoGrano != null && !tipoGrano.isEmpty()) ? tipoGrano : "Arábica";
    }

    @Override
    protected void prepararIngrediente() {
        System.out.println("Moliendo granos de café " + tipoGrano);
        System.out.println("Filtrando café con agua caliente");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando azúcar y leche");
    }
}
