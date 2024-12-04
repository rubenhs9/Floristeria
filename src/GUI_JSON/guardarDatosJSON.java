package GUI_JSON;

import controller.FloristeriaApp;
import data.Flor;
import data.Planta;
import data.Producto;
import data.Venta;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class guardarDatosJSON {
    
    private static final String RUTA_FICHERO_VENTAS = ".\\res\\storage\\ventas.json";
    private static final String RUTA_FICHERO_PRODUCTOS = ".\\res\\storage\\productos.json";   
    private FloristeriaApp floristeriaApp;

    public guardarDatosJSON(FloristeriaApp floristeriaApp) {
        this.floristeriaApp = floristeriaApp;
    }
    
    
    
    
    public void guardarVentas(List<Venta> ventas) throws IOException {
        JSONArray ventasArray = new JSONArray();

        // Recorrer las ventas y convertirlas en JSON
        for (Venta venta : ventas) {
            JSONObject ventaJSON = new JSONObject();

            // Convertir el producto a JSON
            Producto producto = venta.getProducto();
            JSONObject productoJSON = new JSONObject();
            productoJSON.put("nombre", producto.getNombre());
            productoJSON.put("precio", producto.getPrecio());

            // Poner los detalles de la venta en el objeto JSON
            ventaJSON.put("producto", productoJSON);
            ventaJSON.put("cantidad", venta.getCantidad());
            ventaJSON.put("fecha", venta.getFecha().toString());

            // Añadir la venta al array de ventas
            ventasArray.put(ventaJSON);
        }

        // Guardar el array de ventas en el archivo JSON
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_FICHERO_VENTAS))) {
            writer.write(ventasArray.toString(4)); // Indentado para mayor legibilidad
            System.out.println("Ventas guardadas correctamente en " + RUTA_FICHERO_VENTAS);
        }
    }
    
      // Método para guardar los productos en un archivo JSON
    public void guardarProductos(List<Producto> productos) throws IOException {
        JSONArray productosArray = new JSONArray();

        for (Producto producto : productos) {
            JSONObject productoJSON = new JSONObject();
            productoJSON.put("nombre", producto.getNombre());
            productoJSON.put("precio", producto.getPrecio());
            productoJSON.put("stock", producto.getStock());
            if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                productoJSON.put("color", flor.getColor());
            }else{
                Planta planta = (Planta) producto;
                productoJSON.put("tamaño", planta.getTamaño());
            }
            
            productosArray.put(productoJSON);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_FICHERO_PRODUCTOS))) {
            writer.write(productosArray.toString(4)); // Indentado para mayor legibilidad
            System.out.println("Productos guardados correctamente en " + RUTA_FICHERO_PRODUCTOS);
        }
    }
    
    //Método para cargar los productos desde un archivo JSON
    public void cargarProductos() throws IOException {
        File archivo = new File(RUTA_FICHERO_PRODUCTOS);
        if (!archivo.exists()) {
            System.out.println("El archivo de productos no existe.");
            return;
        }

        //Leemos el contenido del archivo JSON
        String contenido = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));

        //Convertimos el contenido del archivo en un JSONArray
        JSONArray productosArray = new JSONArray(contenido);

        //Iterar sobre el JSONArray y convertir cada objeto en un Producto (hay que tener en cuenta si es una Flor o Planta :) )
        for (int i = 0; i < productosArray.length(); i++) {
            JSONObject productoJSON = productosArray.getJSONObject(i);

            String nombre = productoJSON.getString("nombre");
            double precio = productoJSON.getDouble("precio");
            int stock = productoJSON.getInt("stock");

            Producto producto = null;
            if (productoJSON.has("color")) {
                //Es una Flor
                String color = productoJSON.getString("color");
                producto = new Flor(nombre, stock, precio, color);  
            } else if (productoJSON.has("tamaño")) {
                //Es una Planta
                String tamaño = productoJSON.getString("tamaño");
                producto = new Planta(nombre, stock, precio, tamaño); 
            }

            //Agregamos el producto a la lista
            if (producto != null) {
                floristeriaApp.agregarProducto(producto);
            }
        }
    }
    
    //Método para cargar las ventas desde un archivo JSON
    public void cargarVentas() throws IOException {
        // Ruta del archivo JSON de ventas
        File archivo = new File(RUTA_FICHERO_VENTAS);
        if (!archivo.exists()) {
            System.out.println("El archivo de ventas no existe.");
            return;
        }

        // Leer el contenido del archivo JSON
        String contenido = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));

        // Convertir el contenido del archivo en un JSONArray
        JSONArray ventasArray = new JSONArray(contenido);

        // Iterar sobre el JSONArray y convertir cada objeto en una Venta
        for (int i = 0; i < ventasArray.length(); i++) {
            JSONObject ventaJSON = ventasArray.getJSONObject(i);

            // Obtener la fecha en el formato String (se mantiene igual que en guardarVentas)
            String fechaString = ventaJSON.getString("fecha");

            // Obtener los detalles del producto
            JSONObject productoJSON = ventaJSON.getJSONObject("producto");
            String nombre = productoJSON.getString("nombre");
            double precio = productoJSON.getDouble("precio");

            // Buscar el producto en la lista de productos existentes
            Producto productoExistente = null;
            for (Producto producto : floristeriaApp.obtenerProductos()) {
                if (producto.getNombre().equals(nombre)) {
                    productoExistente = producto;
                    break;
                }
            }

            // Si no se encuentra el producto, se puede manejar el error o crear un nuevo producto
            if (productoExistente == null) {
                System.out.println("Producto no encontrado: " + nombre);
                continue; // O lanzar una excepción, dependiendo de cómo quieras manejarlo
            }

            // Obtener la cantidad
            int cantidad = ventaJSON.optInt("cantidad", 1); // Valor por defecto de cantidad es 1

            // Crear el objeto Venta con el producto encontrado y la fecha como String
            Venta venta = new Venta(productoExistente, cantidad, fechaString);

            // Agregar la venta a la lista de ventas
            floristeriaApp.getVentas().add(venta);
            System.out.println("Venta cargada: " + venta.getProducto().getNombre() + ", Cantidad: " + venta.getCantidad());
        }

        System.out.println("Ventas cargadas correctamente.");
    }

    
    
    
}
