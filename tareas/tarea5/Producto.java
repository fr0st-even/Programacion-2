package service;

public class Producto {
    private String sku;

    public Producto(){
    }
    public Producto(String sku){
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String toString(){
        return "Producto: " + sku;
    }
}
