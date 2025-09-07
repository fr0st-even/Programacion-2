package service;

import lombok.Getter;


@Getter
public class Estudiante {

    private int carnet;

    public Estudiante(int carnet) {
        setCarnet( carnet);
    }

    public Estudiante() {
        this(0);
    }


    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = (carnet > 0) ? carnet: 1000;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "carnet=" + carnet +
                '}';
    }
}
