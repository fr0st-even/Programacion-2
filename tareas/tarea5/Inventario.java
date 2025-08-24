package service;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario(){
        productos = new ArrayList<Producto>();
    }

    public void agrgarProducto(Producto producto){
        productos.add(producto);
    }

    public String toString(){
        String resultado = "Inventario:\n";
        for(int i = 0; i < productos.size(); i++){
            resultado = resultado + productos.get(i).toString() + "\n";
        }
        return resultado;
    }
}
