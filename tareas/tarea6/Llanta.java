package service;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Llanta {

    private int rin;

    public Llanta(int rin) {
        setRin(rin);
    }

    public Llanta(){
        this( 0);
    }

    public void setRin(int rin){
        this.rin = (rin>0) ? rin : 10;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Llanta b = (Llanta) obj;
        return toString().equals(b.toString());
    }

    @Override
    public String toString() {
        return "Llanta{" +
                "\n\trin :" + rin +
                "\n}";
    }

}