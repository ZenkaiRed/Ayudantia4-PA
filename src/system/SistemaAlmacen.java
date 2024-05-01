package system;

import model.ListaProducto;
import model.ListaVenta;
import model.Producto;

public class SistemaAlmacen implements ISistema {

    private ListaProducto listaProducto;
    private ListaVenta listaVenta;

    public SistemaAlmacen() {
        this.listaProducto = new ListaProducto(999);
        this.listaVenta = new ListaVenta(999);
    }

    /**
     * Agrega un producto al almacén.
     * @param nombre   Corresponde al nombre del producto.
     * @param precio   Corresponde al precio del producto.
     * @param cantidad Corresponde a la cantidad del producto.
     * @return Retorna true si el producto fue agregado correctamente, de lo contrario retorna false.
     */
    @Override
    public boolean agregarProducto(String nombre, int precio, int cantidad) {

        // Validaciones
        if (precio < 0) throw new RuntimeException("El precio no puede ser negativo");

        if (cantidad < 0) throw new RuntimeException("La cantidad no puede ser negativa");

        if (listaProducto.existeProducto(nombre)) throw new RuntimeException("El producto ya existe");


        // Agregar producto
        Producto producto = new Producto(nombre, precio, cantidad);

        try {

            listaProducto.agregarProducto(producto);

        } catch (RuntimeException e) {

            return false;

        }

        return true;
    }

    @Override
    public boolean agregarCantidad(int cantidad, String nombre) {

        if (cantidad <= 0) throw new RuntimeException("La cantidad no puede ser negativa o 0.");

        if (!listaProducto.existeProducto(nombre)) throw new RuntimeException("El producto no existe.");

        return listaProducto.agregarCantidad(cantidad, nombre);

    }

    @Override
    public boolean disminuirCantidad(int cantidad, String nombre) {
        return false;
    }

    @Override
    public boolean modificarPrecio(int precio, String nombre) {
        return false;
    }

    @Override
    public String[] obtenerProductos() {
        return new String[0];
    }

    @Override
    public String registrarVenta(String[] nombreProductos) {
        return null;
    }

    @Override
    public String[] obtenerProductosMasVendidos() {

        Producto[] productos = listaProducto.obtenerProductosMasVendidos();

        String[] productosMasVendidos = new String[productos.length];

        for (int i = 0; i < productos.length; i++) {
            productosMasVendidos[i] = productos[i].getNombre();
        }

        return productosMasVendidos;

    }

    @Override
    public String[] obtenerVentas() {
        return new String[0];
    }
}
