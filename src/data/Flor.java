
package data;

import java.io.Serializable;


public class Flor extends Producto implements Serializable{
    
    private String color;

    public Flor(String nombre, int stock, double precio, String color) {
        super(nombre, stock, precio);
        this.color = color;
    }

    @Override
    public String getDetalle() {
        return getNombre() + " (" + color + ")";
    }

    public String getColor() {
        return color;
    }
    
    
}
