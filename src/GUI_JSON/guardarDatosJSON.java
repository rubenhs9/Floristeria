package GUI_JSON;

import data.Producto;
import data.Venta;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class guardarDatosJSON {
    private static final String RUTA_FICHERO_VENTAS = ".\\res\\storage\\ventas.json";
    private static final String RUTA_FICHERO_PRODUCTOS = ".\\res\\storage\\productos.json";   
    
    public void guardarVentas(List<Venta> ventas) throws IOException {
        JSONArray ventasArray = new JSONArray();

        for (Venta venta : ventas) {
            JSONObject ventaJSON = new JSONObject();
            ventaJSON.put("producto", new JSONObject()
                    .put("nombre", venta.getProducto().getNombre())
                    .put("precio", venta.getProducto().getPrecio()));
            ventaJSON.put("fecha", venta.getFecha().toString());
            ventasArray.put(ventaJSON);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_FICHERO_VENTAS))) {
            writer.write(ventasArray.toString(4)); // Indentado para mayor legibilidad
            System.out.println("Ventas guardadas correctamente en " + RUTA_FICHERO_VENTAS);
        }
    }
    
//     // Método para cargar las ventas desde un archivo JSON
//    public static List<Venta> cargarVentas() throws IOException {
//        List<Venta> ventas = new ArrayList<>();
//        if (!Files.exists(Paths.get(RUTA_FICHERO_VENTAS))) {
//            System.out.println("El archivo de ventas no existe.");
//            return ventas;
//        }
//
//        String contenido = new String(Files.readAllBytes(Paths.get(RUTA_FICHERO_VENTAS)));
//        JSONArray ventasArray = new JSONArray(contenido);
//
//        for (int i = 0; i < ventasArray.length(); i++) {
//            JSONObject ventaJSON = ventasArray.getJSONObject(i);
//            JSONObject productoJSON = ventaJSON.getJSONObject("producto");
//            Producto producto = new Producto(
//                    productoJSON.getString("nombre"),
//                    productoJSON.getDouble("precio"),
//                    null // Agrega una referencia de Flor si es necesario
//            ) {};
//            Venta venta = new Venta(producto, ventaJSON.getString("fecha")); // Ajusta el constructor de Venta
//            ventas.add(venta);
//        }
//
//        return ventas;
//    }
    
      // Método para guardar los productos en un archivo JSON
    public void guardarProductos(List<Producto> productos) throws IOException {
        JSONArray productosArray = new JSONArray();

        for (Producto producto : productos) {
            JSONObject productoJSON = new JSONObject();
            productoJSON.put("nombre", producto.getNombre());
            productoJSON.put("precio", producto.getPrecio());
            productosArray.put(productoJSON);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_FICHERO_PRODUCTOS))) {
            writer.write(productosArray.toString(4)); // Indentado para mayor legibilidad
            System.out.println("Productos guardados correctamente en " + RUTA_FICHERO_PRODUCTOS);
        }
    }
    
     // Método para cargar los productos desde un archivo JSON
//    public static List<Producto> cargarProductos() throws IOException {
//        List<Producto> productos = new ArrayList<>();
//        if (!Files.exists(Paths.get(RUTA_FICHERO_PRODUCTOS))) {
//            System.out.println("El archivo de productos no existe.");
//            return productos;
//        }
//
//        String contenido = new String(Files.readAllBytes(Paths.get(RUTA_FICHERO_PRODUCTOS)));
//        JSONArray productosArray = new JSONArray(contenido);
//
//        for (int i = 0; i < productosArray.length(); i++) {
//            JSONObject productoJSON = productosArray.getJSONObject(i);
//            Producto producto = new Producto(
//                    productoJSON.getString("nombre"),
//                    productoJSON.getDouble("precio"),
//                    null // Agrega una referencia de Flor si es necesario
//            );
//            productos.add(producto);
//        }
//
//        return productos;
//    }
}
