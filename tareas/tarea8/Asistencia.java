package service;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
@ToString
@Getter
@Setter

public class Asistencia {


    private List<Estudiante> estudiantes; //Atributo colección


    public Asistencia() { //COnstructor
        estudiantes = new LinkedList<>();



    }
    public void addEstudiante (Estudiante e) throws MyException{
        if( null == e)
            throw new MyException("No se permiten estudiantes" );
        estudiantes.add( e );
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }


    
    //Para que funcione este lo tengo que sacar de comentario
        /*@Override
    public String toString() {
        return "Asistencia{" +
                "estudiantes=" + estudiantes +
                '}';o
    }*/
}

class MyException extends RuntimeException{

    public MyException (String nombre){
        super(nombre);
    }

}
