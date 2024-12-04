
package data;

import java.io.Serializable;


public class Planta extends Producto implements Serializable{
    
    private String tamaño;

    public Planta(String nombre, int stock, double precio, String tamaño) {
        super(nombre, stock, precio);
        this.tamaño = tamaño;
    }

    @Override
    public String getDetalle() {
        return getNombre() + " (" + tamaño + ")";
    }

    public String getTamaño() {
        return tamaño;
    }
    
    
}
