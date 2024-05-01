package util;

import system.ISistema;
import system.SistemaAlmacen;

public class Instalador {

    private SistemaAlmacen sistemaAlmacen;

    public Instalador(){
        this.sistemaAlmacen = new SistemaAlmacen();
    }

    public ISistema inyectarSistema(){
        return this.sistemaAlmacen;
    }


}
