package model;

public class Venta {

    private String[] nombreProductos;
    private int precioTotal;
    private int cantidadProductos;

    public Venta(int precioTotal, int cantidadProductos) {
        this.nombreProductos = new String[999];
        this.precioTotal = precioTotal;
        this.cantidadProductos = cantidadProductos;
    }

    public String[] getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String[] nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
}
