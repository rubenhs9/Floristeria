
package GUI;

import controller.FloristeriaApp;
import data.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class panelAgregarAlStock extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private FloristeriaApp floristeriaApp;
    private Image backgroundImage;
    
    private JTextField searchField;
    private JList<String> productList;
    private DefaultListModel<String> productListModel;
    private JPanel productDetailsPanel;
    
    public panelAgregarAlStock(JPanel panelPrincipal, JPanel panelOpciones, FloristeriaApp floristeriaApp, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
        this.floristeriaApp = floristeriaApp;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
//        ImageIcon imagen = new ImageIcon(campeonato.getBackground());
//        backgroundImage = imagen.getImage();
        
        botonVolverAtras();
        minitComponents();
    }

        private void botonVolverAtras(){
        //CREAMOS EL PANEL DE ARRIBA DONDE ESTARA EL BOTON DE VOLVER
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.setOpaque(false);
        JPanel panelIrHaciaAtras = new JPanel();
        panelIrHaciaAtras.setOpaque(false);
        panelIrHaciaAtras.setLayout(new FlowLayout(FlowLayout.LEFT));
        //BOTON PARA VOLVER ATRAS
        JLabel volverAtras = new JLabel();
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(new EmptyBorder(0,10,0,10));
        volverAtras.setFont(new Font("Arial",Font.BOLD,25));
        volverAtras.setText("VOLVER");
        volverAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelAgregarAlStock.this);
                panelPrincipal.add(panelOpciones);
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                volverAtras.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                volverAtras.setBackground(colorPrimario);
            }
        });
        panelIrHaciaAtras.add(volverAtras);
        panelInfo.add(panelIrHaciaAtras, BorderLayout.WEST);
        
        //CREAMOS EL Label QUE INIDICARA QUE ESTAMOS HACIENDO
        JLabel labelInfo = new JLabel();
        labelInfo.setText("ESCRIBE EL NOMBRE DEL PRODUCTO AL QUE REPONER                   ");
        labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
        labelInfo.setForeground(Color.BLACK);
        labelInfo.setFont(new Font("Arial",Font.BOLD,25));
        panelInfo.add(labelInfo,BorderLayout.CENTER);
        
        this.add(panelInfo, BorderLayout.NORTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void minitComponents() {
        // Crear el panel central para contener el campo de búsqueda y la lista de productos
        JPanel panelCentral = new JPanel(new BorderLayout());

        // Crear el campo de búsqueda
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 30));
        searchField.setText(" Escribe aqui");
        searchField.setForeground(Color.gray);
        searchField.setBorder(new LineBorder(Color.BLACK,3));
        // Listener para detectar el foco
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals(" Escribe aqui")) {
                    searchField.setText(" ");
                    searchField.setForeground(Color.BLACK);
                }
            }

        });
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarListaProductos();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarListaProductos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarListaProductos();
            }
        });
        panelCentral.add(searchField, BorderLayout.NORTH);

        // Crear el modelo y la lista para mostrar los productos
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productList.setFont(new Font("Arial", Font.PLAIN, 14));
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic para seleccionar un producto
                    String productoSeleccionado = productList.getSelectedValue();
                    mostrarDetallesProducto(productoSeleccionado);
                }
            }
        });

        // Envolver la lista en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(productList);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel central al centro del panel principal
        this.add(panelCentral, BorderLayout.CENTER);

        // Panel para mostrar los detalles del producto seleccionado
        productDetailsPanel = new JPanel();
        productDetailsPanel.setLayout(new BorderLayout());
        this.add(productDetailsPanel, BorderLayout.SOUTH);
    }
    
    private void actualizarListaProductos() {
        String filtro = searchField.getText().toLowerCase();
        List<String> productosFiltrados = floristeriaApp.obtenerProductos().stream()
                .filter(producto -> producto.getNombre().toLowerCase().contains(filtro))
                .map(producto -> producto.getNombre())
                .collect(Collectors.toList());

        productListModel.clear();
        productosFiltrados.forEach(productListModel::addElement);
    }

    private void mostrarDetallesProducto(String productoSeleccionado) {
        productDetailsPanel.removeAll();

        // Obtener el producto seleccionado desde la floristeriaApp
        Producto producto = floristeriaApp.buscarProductoPorNombre(productoSeleccionado);

        if (producto == null) {
            JLabel errorLabel = new JLabel("Error: Producto no encontrado");
            errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            productDetailsPanel.add(errorLabel, BorderLayout.CENTER);
        } else {
            // Mostrar los detalles del producto
            JPanel detallesPanel = new JPanel(new BorderLayout());
            JLabel detalles = new JLabel("<html><strong>Producto:</strong> " + producto.getNombre() + 
                                          "<br><strong>Stock actual:</strong> " + producto.getStock() + "</html>");
            detalles.setFont(new Font("Arial", Font.PLAIN, 30));
            detalles.setBorder(new EmptyBorder(10, 10, 10, 10));
            detallesPanel.add(detalles, BorderLayout.NORTH);

            // Campo para cambiar el stock
            JPanel stockPanel = new JPanel(new FlowLayout());
            JLabel stockLabel = new JLabel("Nuevo stock: ");
            stockLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            JSpinner stockSpinner = new JSpinner(new SpinnerNumberModel(producto.getStock(), 0, Integer.MAX_VALUE, 1));
            stockSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
            JLabel actualizarButton = new JLabel("Actualizar Stock");
            actualizarButton.setBackground(colorPrimario);
            actualizarButton.setOpaque(true);
            actualizarButton.setForeground(Color.white);
            actualizarButton.setBorder(new EmptyBorder(0,10,0,10));
            actualizarButton.setFont(new Font("Microsoft YaHei UI",Font.BOLD,25));
            actualizarButton.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    int nuevoStock = (int) stockSpinner.getValue();
                    producto.setStock(nuevoStock);
    //                floristeriaApp.actualizarProducto(producto);
                    detalles.setText("<html><strong>Producto:</strong> " + producto.getNombre() + 
                                     "<br><strong>Stock actual:</strong> " + producto.getStock() + "</html>");
                    detallesPanel.revalidate();
                    detallesPanel.repaint();
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                    actualizarButton.setBackground(Color.DARK_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    actualizarButton.setBackground(colorPrimario);
                }

            });

            stockPanel.add(stockLabel);
            stockPanel.add(stockSpinner);
            stockPanel.add(actualizarButton);

            detallesPanel.add(stockPanel, BorderLayout.CENTER);
            productDetailsPanel.add(detallesPanel, BorderLayout.CENTER);
        }

        productDetailsPanel.revalidate();
        productDetailsPanel.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
