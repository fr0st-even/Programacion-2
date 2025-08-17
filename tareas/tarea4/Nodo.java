package service.edd;

public class Nodo {
    private Object dato;
    private Nodo sig;

    public Nodo(Object dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public Nodo(Object dato) {
        this(dato, null);
    }

    public Nodo() {
        this(null, null);
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return toString().equals(nodo.toString());
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", sig=" + (sig != null ? "Nodo" : null) +
                '}';
    }
}
