package service.edd;

public class Lista {
    private String nombre;
    private Nodo ini;
    private Nodo fin;

    public Lista(String nombre, Nodo ini, Nodo fin) {
        this.nombre = nombre;
        this.ini = ini;
        this.fin = fin;
    }

    public Lista(String nombre) {
        this(nombre, null, null);
    }

    public Lista() {
        this("", null, null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public boolean estaVacia() {
        return ini == null;
    }

    public void insertarAlFrente(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            ini = fin = nuevoNodo;
        } else {
            nuevoNodo.setSig(ini);
            ini = nuevoNodo;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lista lista = (Lista) obj;
        return toString().equals(lista.toString());
    }

    @Override
    public String toString() {
        return "Lista{" +
                "nombre='" + nombre + '\'' +
                ", ini=" + (ini != null ? "Nodo" : null) +
                ", fin=" + (fin != null ? "Nodo" : null) +
                '}';
    }
}
