
package data;


public class Flor extends Producto{
    
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
