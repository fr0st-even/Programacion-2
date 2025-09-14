package service;

public class Fotografia {
    private String tipoArchivo;
    private String pathArchivo;
    private double tamanoKbytes;

    public Fotografia(String tipoArchivo, String pathArchivo, double tamanoKbytes) {
        this.tipoArchivo = tipoArchivo;
        this.pathArchivo = pathArchivo;
        setTamanoKbytes(tamanoKbytes);
    }

    public Fotografia() {
        this("jpg", "", 0.0);
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public double getTamanoKbytes() {
        return tamanoKbytes;
    }

    public void setTamanoKbytes(double tamanoKbytes) {
        this.tamanoKbytes = (tamanoKbytes > 0 && tamanoKbytes <= 100) ? tamanoKbytes : 10.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fotografia f = (Fotografia) obj;
        return toString().equals(f.toString());
    }

    @Override
    public String toString() {
        return "Fotografia{" +
                "tipoArchivo='" + tipoArchivo + '\'' +
                ", pathArchivo='" + pathArchivo + '\'' +
                ", tamanoKbytes=" + tamanoKbytes +
                '}';
    }
}