package model;

import model.Venta;

public class ListaVenta {

    private final Venta[] ventas;
    private int cantidadVentas;
    private final int cantidadMaxima;

    public ListaVenta(int cantidadMaxima) {
        this.ventas = new Venta[cantidadMaxima];
        this.cantidadVentas = 0;
        this.cantidadMaxima = cantidadMaxima;
    }

    public void agregarVenta(Venta venta) {
        if (cantidadVentas < cantidadMaxima) {
            ventas[cantidadVentas] = venta;
            cantidadVentas++;
        } else {
            throw new RuntimeException("No se pueden agregar más ventas");
        }
    }




}
