
package data;


public class Planta extends Producto{
    
    private String tamaño;

    public Planta(String nombre, int stock, double precio, String tamaño) {
        super(nombre, stock, precio);
        this.tamaño = tamaño;
    }

    @Override
    public String getDetalle() {
        return getNombre() + " (" + tamaño + ")";
    }
}
