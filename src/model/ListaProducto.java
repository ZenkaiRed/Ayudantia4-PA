package model;

import model.Producto;

public class ListaProducto {

    private final Producto[] productos;
    private int cantidadProductos;
    private final int cantidadMaxima;

    public ListaProducto(int cantidadMaxima) {
        this.productos = new Producto[cantidadMaxima];
        this.cantidadProductos = 0;
        this.cantidadMaxima = cantidadMaxima;
    }

    public void agregarProducto(Producto producto) {
        if (cantidadProductos < cantidadMaxima) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
        } else {
            throw new RuntimeException("No se pueden agregar más productos");
        }
    }

    public boolean agregarCantidad(int cantidad, String nombre){

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                productos[i].setCantidad(productos[i].getCantidad() + cantidad);
                return true;
            }
        }

        return false;
    }

    public boolean disminuirCantidad(int cantidad, String nombre){

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                if (productos[i].getCantidad() >= cantidad) {

                    int cantidadNueva = productos[i].getCantidad() - cantidad;

                    if (cantidadNueva < 0) { throw new RuntimeException("No se pueden disminuir más productos"); }

                    productos[i].setCantidad(productos[i].getCantidad() - cantidad);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean modificarPrecio(int precio, String nombre){

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                productos[i].setPrecio(precio);
                return true;
            }
        }

        return false;
    }

    public Producto[] obtenerProductosMasVendidos(){

        // Copiar los productos a un nuevo arreglo para ordenarlos.
        Producto[] prodOrdenados = new Producto[cantidadProductos];
        System.arraycopy(productos, 0, prodOrdenados, 0, cantidadProductos);

        // Ordenar los productos por cantidad vendida histórica.
        for (int i = 0; i < prodOrdenados.length; i++) {
            for (int j = 0; j < prodOrdenados.length - i - 1; j++) {
                if (prodOrdenados[j].getCantidadVendidaHistorica() < prodOrdenados[j + 1].getCantidadVendidaHistorica()) {
                    // Intercambiar productos[j] y productos[j + 1]
                    Producto temp = prodOrdenados[j];
                    prodOrdenados[j] = prodOrdenados[j + 1];
                    prodOrdenados[j + 1] = temp;
                }
            }
        }

        return prodOrdenados;
    }

    public boolean existeProducto(String nombre){
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }
}
