
package data;

import java.util.Date;


public class Venta {
    
    private Producto producto;
    private int cantidad;
    private Date fecha;

    public Venta(Producto producto, int cantidad, Date fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public double getTotal() {
        return producto.getPrecio() * cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    
    
    
}
