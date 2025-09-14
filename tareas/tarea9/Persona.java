package service;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellidos;
    private ArrayList<Lugar> lugaresVisitados;
    private Fotografia fotografia;
    private Perfil perfil;

    public Persona(String nombre, String apellidos, Fotografia fotografia, Perfil perfil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fotografia = fotografia;
        this.perfil = perfil;
        this.lugaresVisitados = new ArrayList<Lugar>();
    }

    public Persona() {
        this("", "", new Fotografia(), new Perfil());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public ArrayList<Lugar> getLugaresVisitados() {
        return lugaresVisitados;
    }

    public void setLugaresVisitados(ArrayList<Lugar> lugaresVisitados) {
        this.lugaresVisitados = lugaresVisitados;
    }

    public Fotografia getFotografia() {
        return fotografia;
    }

    public void setFotografia(Fotografia fotografia) {
        this.fotografia = fotografia;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void agregarLugar(Lugar lugar) {
        lugaresVisitados.add(lugar);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return toString().equals(persona.toString());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", lugaresVisitados=" + lugaresVisitados +
                ", fotografia=" + fotografia +
                ", perfil=" + perfil +
                '}';
    }
}