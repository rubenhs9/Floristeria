
package controller;

import GUI.Vpal;
import data.Flor;
import data.Planta;
import data.Producto;
import data.Venta;
import java.util.ArrayList;
import java.util.Date;

public class FloristeriaApp {
    
    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;

    public FloristeriaApp(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
        
        datosDePrueba();
        modoGrafico();
        
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void venderProducto(String nombre, int cantidad) throws Exception {
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto == null) {
            throw new Exception("Producto no encontrado.");
        }
        if (producto.getStock() < cantidad) {
            throw new Exception("Stock insuficiente.");
        }
        producto.reducirStock(cantidad);
        ventas.add(new Venta(producto, cantidad, new Date()));
        if (producto.getStock() < 3) {
            System.out.println("Advertencia: Quedan menos de 3 unidades de " + nombre);
        }
    }

    public double calcularGananciasHasta(Date fecha) {
        double ganancias = 0;
        for (Venta venta : ventas) {
            if (!venta.getFecha().after(fecha)) {
                ganancias += venta.getTotal();
            }
        }
        return ganancias;
    }

    private void datosDePrueba() {
        //Flores
        productos.add(new Flor("Rosa roja", 10, 1.5, "Rojo"));
        productos.add(new Flor("Tulipán amarillo", 15, 2.0, "Amarillo"));
        productos.add(new Flor("Margarita blanca", 8, 1.0, "Blanco"));
        productos.add(new Flor("Lirio morado", 5, 3.0, "Morado"));
        productos.add(new Flor("Clavel rosado", 20, 1.8, "Rosado"));

        //Plantas
        productos.add(new Planta("Cactus pequeño", 12, 5.0, "50x100"));
        productos.add(new Planta("Helecho", 7, 7.5, "60x80"));
        productos.add(new Planta("Bonsái", 4, 25.0, "30x50"));
        productos.add(new Planta("Orquídea azul", 6, 15.0, "40x60"));
        productos.add(new Planta("Palma areca", 10, 20.0, "150x200"));

        //Más flores
        productos.add(new Flor("Rosa blanca", 18, 1.7, "Blanco"));
        productos.add(new Flor("Clavel rojo", 25, 1.5, "Rojo"));
        productos.add(new Flor("Tulipán rosado", 10, 2.5, "Rosado"));
        productos.add(new Flor("Jazmín", 8, 2.0, "Blanco"));
        productos.add(new Flor("Geranio rojo", 14, 1.8, "Rojo"));

        //Más plantas
        productos.add(new Planta("Suculenta", 20, 3.5, "15x20"));
        productos.add(new Planta("Lavanda", 9, 6.0, "30x50"));
        productos.add(new Planta("Ficus", 5, 18.0, "120x180"));
        productos.add(new Planta("Potos", 11, 12.0, "100x150"));
        productos.add(new Planta("Aloe vera", 10, 8.0, "40x60"));

    }


    private void modoGrafico() {
        Vpal vpal = new Vpal(this);
        vpal.setVisible(true);
    }

   
}

