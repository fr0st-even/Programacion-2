package service;

import lombok.ToString;

@ToString
public class Te extends BebidaTemplate{
    private String tipoHoja;

    public Te(int agua, int temperatura, String tipoHoja) {
        super(agua, temperatura);
        setTipoHoja(tipoHoja);
    }

    public Te(String tipoHoja) {
        super(250, 90);
        setTipoHoja(tipoHoja);
    }

    public Te() {
        this("Verde");
    }

    public String getTipoHoja() {
        return tipoHoja;
    }

    public void setTipoHoja(String tipoHoja) {
        this.tipoHoja = (tipoHoja != null && !tipoHoja.isEmpty()) ? tipoHoja : "Verde";
    }

    @Override
    protected void prepararIngrediente() {
        System.out.println("Remojando hojas de té " + tipoHoja);
        System.out.println("Dejando reposar por 3 minutos");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando limón y miel");
    }
}
