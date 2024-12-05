
package data;

import java.io.Serializable;
import java.util.Date;


public class Venta implements Serializable {
    
    private Producto producto;
    private int cantidad;
    private String fecha;

    public Venta(Producto producto, int cantidad, String fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public double getTotal() {
        return producto.getPrecio() * cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    
    
    
}
