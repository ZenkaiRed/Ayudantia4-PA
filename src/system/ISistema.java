package system;

public interface ISistema {

    /**
     * Agrega un producto al almacen.
     * @param nombre Corresponde al nombre del producto.
     * @param precio Corresponde al precio del producto.
     * @param cantidad Corresponde a la cantidad del producto.
     * @return Retorna true si el producto fue agregado correctamente, de lo contrario retorna false.
     */
    boolean agregarProducto(String nombre, int precio, int cantidad);

    boolean agregarCantidad(int cantidad, String nombre);

    boolean disminuirCantidad(int cantidad, String nombre);

    boolean modificarPrecio(int precio, String nombre);

    String[] obtenerProductos();

    String registrarVenta(String[] nombreProductos);

    String[] obtenerProductosMasVendidos();

    String[] obtenerVentas();

}
