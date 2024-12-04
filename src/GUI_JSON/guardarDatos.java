package GUI_JSON;

import data.Producto;
import data.Venta;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class guardarDatos {
    
    private static final String RUTA_FICHERO_VENTAS = ".\\res\\storage\\ventas.dat";
    private static final String RUTA_FICHERO_PRODUCTOS = ".\\res\\storage\\productos.dat";
    private static File archivo;
    
   
    public void guardarProducto(List<Producto> productos) throws IOException {
        File archivo = new File(RUTA_FICHERO_PRODUCTOS);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(productos);
            System.out.println("Productos guardados correctamente en " + RUTA_FICHERO_PRODUCTOS);
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
            throw e;
        }
    }

    void guardarVentas(List<Venta> ventas)throws IOException {
        File archivo = new File(RUTA_FICHERO_VENTAS);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(ventas);
            System.out.println("Ventas guardadas correctamente en " + RUTA_FICHERO_VENTAS);
        } catch (IOException e) {
            System.err.println("Error al guardar las ventas: " + e.getMessage());
            throw e;
        }
    }

    
    
}
