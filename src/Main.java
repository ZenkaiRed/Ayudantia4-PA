import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
import system.ISistema;
import util.Instalador;

public class Main {

    public static void main(String[] args) { configuracion(); }

    public static void configuracion() {
        // se instala el sistema
        ISistema sistemaAlmacen = instalarSistema();
        menuPrincipal(sistemaAlmacen);
    }

    public static ISistema instalarSistema() {
        return new Instalador().inyectarSistema();
    }

    /**
     * Método que muestra el menú principal.
     * @param sistemaAlmacen Sistema a utilizar.
     */
    public static void menuPrincipal(ISistema sistemaAlmacen) {
        int opcion = 0;

        while(opcion != 8){
            StdOut.println("--------->Bienvenido al Almacén<---------");
            StdOut.println("[1] Agregar producto.");
            StdOut.println("[2] Agregar cantidad a un producto.");
            StdOut.println("[3] Disminuir cantidad a un producto.");
            StdOut.println("[4] Modificar precio de un producto.");
            StdOut.println("[5] Registrar venta.");
            StdOut.println("[6] Ver productos más vendidos.");
            StdOut.println("[7] Ver ventas.");
            StdOut.println("[8] Salir.");

            StdOut.print("Ingrese su opción: ");
            String opcionStr = StdIn.readLine();
            int opcionInt;

            while (true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if (1 <= opcionInt && opcionInt <= 8){
                        break;
                    }else{
                        StdOut.println("Error, la opción ingresada no existe");
                        StdOut.print("Ingrese su opción nuevamente: ");
                        opcionStr = StdIn.readString();
                    }
                }catch(Exception e){
                    StdOut.println("Error, la opción ingresada no existe");
                    StdOut.print("Ingrese su opción nuevamente: ");
                    opcionStr = StdIn.readString();
                }
            }
            opcion = opcionInt;

            switch (opcion) {
                case 1 -> agregarProducto(sistemaAlmacen);
                case 2 -> agregarCantidadProducto(sistemaAlmacen);
                case 3 -> disminuirCantidadProducto(sistemaAlmacen);
                case 6 -> desplegarProductosMasVendidos(sistemaAlmacen);
            }
        }


    }

    /**
     * Método que agrega un producto al sistema.
     * @param sistemaAlmacen Sistema a utilizar.
     */
    private static void agregarProducto(ISistema sistemaAlmacen) {

        StdOut.println("\n--------->Agregar nuevo producto<---------");

        // Solicitar nombre del producto.
        StdOut.print("Ingrese el nombre del producto: ");
        String nombre = StdIn.readLine();

        // Solicitar precio del producto.
        int precio = 0;

        while (precio == 0){
            try {
                StdOut.print("Ingrese el precio del producto: ");
                precio = StdIn.readInt();

                // Validar que el precio sea un número entero mayor a 0.
                if (precio <= 0) {
                    StdOut.println("Error, el precio debe ser un número entero mayor a 0.");
                    precio = 0;
                }

            } catch (Exception e) {
                StdOut.println("Error, el precio debe ser un número.");
            }
        }


        // Solicitar cantidad del producto.
        int cantidad = 0;

        while (cantidad == 0){
            try {
                StdOut.print("Ingrese la cantidad del producto: ");
                cantidad = StdIn.readInt();

                // Validar que la cantidad sea un número entero mayor a 0.
                if (cantidad <= 0) {
                    StdOut.println("Error, la cantidad debe ser un número entero mayor a 0.");
                    cantidad = 0;
                }

            } catch (Exception e) {
                StdOut.println("Error, la cantidad debe ser un número.");
            }
        }


        try {
            // Agregar producto al sistema.
            boolean productoAgregado = sistemaAlmacen.agregarProducto(nombre, precio, cantidad);

            if (productoAgregado) {
                StdOut.println("Producto agregado correctamente.");
            } else {
                StdOut.println("Error, no se pudo agregar el producto.");
            }

        } catch (Exception resultado) {

            // Mostrar mensaje de error si no se pudo agregar el producto.
            StdOut.println(resultado.getMessage());
        }
    }

    /**
     * Método que agrega cantidad a un producto.
     * @param sistemaAlmacen Sistema a utilizar.
     */
    private static void agregarCantidadProducto(ISistema sistemaAlmacen) {
        StdOut.println("\n--------->Agregar cantidad<---------");

        // Solicitar nombre del producto.
        StdOut.print("Ingrese el nombre del producto: ");
        String nombre = StdIn.readString();

        // Solicitar precio del producto.
        int precio = 0;

        while (precio == 0) {
            try {
                StdOut.print("Ingrese el precio del producto: ");
                precio = StdIn.readInt();

                // Validar que el precio sea un número entero mayor a 0.
                if (precio <= 0) {
                    StdOut.println("Error, el precio debe ser un número entero mayor a 0.");
                    precio = 0;
                }

            } catch (Exception e) {
                StdOut.println("Error, el precio debe ser un número.");
            }
        }

        try {
            // Agregar cantidad al producto.
            boolean cantidadAgregada = sistemaAlmacen.agregarCantidad(precio, nombre);

            if (cantidadAgregada) {
                StdOut.println("Cantidad agregada correctamente.");
            } else {
                StdOut.println("Error, no se pudo agregar la cantidad.");
            }

        } catch (Exception resultado) {

            // Mostrar mensaje de error si no se pudo agregar la cantidad.
            StdOut.println(resultado.getMessage());
        }

    }

    /**
     * Método que disminuye la cantidad de un producto.
     * @param sistemaAlmacen Sistema a utilizar.
     */
    private static void disminuirCantidadProducto(ISistema sistemaAlmacen) {
        StdOut.println("\n--------->Disminuir cantidad<---------");

        // Solicitar nombre del producto.
        StdOut.print("Ingrese el nombre del producto: ");
        String nombre = StdIn.readString();

        // Solicitar precio del producto.
        int precio = 0;

        while (precio == 0) {
            try {
                StdOut.print("Ingrese el precio del producto: ");
                precio = StdIn.readInt();

                // Validar que el precio sea un número entero mayor a 0.
                if (precio <= 0) {
                    StdOut.println("Error, el precio debe ser un número entero mayor a 0.");
                    precio = 0;
                }

            } catch (Exception e) {
                StdOut.println("Error, el precio debe ser un número.");
            }
        }

        try {
            // Disminuir cantidad del producto.
            boolean cantidadDisminuida = sistemaAlmacen.disminuirCantidad(precio, nombre);

            if (cantidadDisminuida) {
                StdOut.println("Cantidad disminuida correctamente.");
            } else {
                StdOut.println("Error, no se pudo disminuir la cantidad.");
            }

        } catch (Exception resultado) {

            // Mostrar mensaje de error si no se pudo disminuir la cantidad.
            StdOut.println(resultado.getMessage());
        }
    }

    /**
     * Método que despliega los productos más vendidos.
     * @param sistemaAlmacen Sistema a utilizar.
     */
    private static void desplegarProductosMasVendidos(ISistema sistemaAlmacen) {
        StdOut.println("\n--------->Productos más vendidos<---------");

        try {
            // Obtener productos más vendidos.
            String[] productosMasVendidos = sistemaAlmacen.obtenerProductosMasVendidos();

            if (productosMasVendidos.length > 0) {
                for (String producto : productosMasVendidos) {
                    StdOut.println(producto);
                }
            } else {
                StdOut.println("No hay productos.");
            }

        } catch (Exception resultado) {

            // Mostrar mensaje de error si no se pudo obtener los productos más vendidos.
            StdOut.println(resultado.getMessage());
        }
    }


}