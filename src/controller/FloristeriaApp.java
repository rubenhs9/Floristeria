
package controller;

import GUI.Vpal;
import GUI_JSON.guardarDatosJSON;
import data.Flor;
import data.Planta;
import data.Producto;
import data.Venta;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FloristeriaApp {
    
    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;
    
    private guardarDatosJSON guardarDatosJSON;

    public FloristeriaApp(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
        this.guardarDatosJSON = new guardarDatosJSON(this);
        
//        datosDePrueba();

        cargarDatosJSON();


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

    public ArrayList<Venta> getVentas() {
        return ventas;
    }
    
    
    public void venderProducto(String nombre, int cantidad) throws Exception {
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto == null) {
            throw new Exception("Producto no encontrado.");
        }
        if (producto.getStock() < cantidad) {
            JOptionPane.showMessageDialog(null,"Stock insuficiente","ERROR",0);
        }else{
            producto.reducirStock(cantidad);
            Date date = new Date();
            ventas.add(new Venta(producto, cantidad, date.toString()));
            if (producto.getStock() < 3) {
                JOptionPane.showMessageDialog(null,"Advertencia: Quedan menos de 3 unidades de " + nombre);
            }
        }
        
    }

    public double calcularGananciasHasta(Date fecha) {
        double ganancias = 0;

        // Definir el formato de fecha que usaste para guardar la fecha como String
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        for (Venta venta : ventas) {
            try {
                // Convertir el String de la fecha en un objeto Date
                java.util.Date fechaVenta = dateFormat.parse(venta.getFecha());  // Asumiendo que getFecha() devuelve un String

                // Comparar las fechas: si la fecha de la venta es antes o igual a la fecha pasada como parámetro
                if (!fechaVenta.after(fecha)) {
                    ganancias += venta.getTotal();  // Sumar las ganancias
                }
            } catch (Exception e) {
                System.out.println("Error al convertir la fecha de la venta: " + venta.getFecha());
                e.printStackTrace();
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
        productos.add(new Flor("Rosa amarilla", 12, 1.6, "Amarillo"));
        productos.add(new Flor("Peonía blanca", 9, 2.8, "Blanco"));
        productos.add(new Flor("Girasol", 15, 2.2, "Amarillo"));
        productos.add(new Flor("Hortensia azul", 7, 3.5, "Azul"));
        productos.add(new Flor("Gladiolo naranja", 8, 1.9, "Naranja"));
        productos.add(new Flor("Rosa negra", 3, 5.0, "Negro"));
        productos.add(new Flor("Clavel amarillo", 20, 1.4, "Amarillo"));
        productos.add(new Flor("Orquídea blanca", 5, 18.0, "Blanco"));
        productos.add(new Flor("Narciso", 10, 2.3, "Amarillo"));
        productos.add(new Flor("Violeta africana", 12, 1.7, "Morado"));


        //Plantas
        productos.add(new Planta("Cactus pequeño", 12, 5.0, "50x100"));
        productos.add(new Planta("Helecho", 7, 7.5, "60x80"));
        productos.add(new Planta("Bonsái", 4, 25.0, "30x50"));
        productos.add(new Planta("Orquídea azul", 6, 15.0, "40x60"));
        productos.add(new Planta("Palma areca", 10, 20.0, "150x200"));
        productos.add(new Planta("Cactus grande", 6, 12.0, "70x120"));
        productos.add(new Planta("Palo de agua", 5, 30.0, "150x200"));
        productos.add(new Planta("Sansevieria", 12, 10.0, "100x150"));
        productos.add(new Planta("Hiedra trepadora", 15, 8.5, "200x300"));
        productos.add(new Planta("Planta araña", 18, 6.5, "50x70"));
        productos.add(new Planta("Palma kentia", 8, 25.0, "120x180"));
        productos.add(new Planta("Drácena", 7, 20.0, "150x200"));
        productos.add(new Planta("Planta ZZ", 10, 15.0, "100x150"));
        productos.add(new Planta("Bamboo de la suerte", 25, 5.5, "50x100"));
        productos.add(new Planta("Crotón", 6, 12.5, "80x120"));

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

    private void cargarDatosJSON() {
        try {
            guardarDatosJSON.cargarProductos();
            guardarDatosJSON.cargarVentas();
        } catch (IOException ex) {
            Logger.getLogger(FloristeriaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}

