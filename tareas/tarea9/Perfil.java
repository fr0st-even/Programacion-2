package service;

public class Perfil {
    private String tipoPerfil;
    private String descripcion;

    public Perfil(String tipoPerfil, String descripcion) {
        this.tipoPerfil = tipoPerfil;
        this.descripcion = descripcion;
    }

    public Perfil() {
        this("", "");
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Perfil p = (Perfil) obj;
        return toString().equals(p.toString());
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "tipoPerfil='" + tipoPerfil + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}