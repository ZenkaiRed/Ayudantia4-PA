package model;

public class Producto {

    private String nombre;
    private int precio;
    private int cantidad;
    private int cantidadVendidaHistorica;

    public Producto(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cantidadVendidaHistorica = 0;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadVendidaHistorica() {
        return cantidadVendidaHistorica;
    }

    public void setCantidadVendidaHistorica(int cantidadVendidaHistorica) {
        this.cantidadVendidaHistorica = cantidadVendidaHistorica;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nPrecio: " + this.precio +
                "\nCantidad Vendida: " + this.cantidadVendidaHistorica;
    }
}
