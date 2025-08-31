package service;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Carro {
    private final int TAM = 4;
    @Setter
    @Getter
    private Llanta []llantas;
    public Carro(){
        llantas = new Llanta[TAM];
        for (int i = 0; i < TAM; i++)
            llantas[ i ] = new Llanta();
    }

    public void setLlantas(Llanta[] llantas) {

        this.llantas = llantas;
    }

    public int getTAM() {
        return TAM;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "TAM=" + TAM +
                ", llantas=" + Arrays.toString(llantas) +
                '}';
    }

    public Llanta[] getLlantas() {
        return llantas;
    }
}
