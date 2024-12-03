
package GUI;

import controller.FloristeriaApp;
import data.Flor;
import data.Planta;
import data.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class panelInformacionDeProductos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private FloristeriaApp floristeriaApp;
    private Image backgroundImage;
    private int posicion = 0;   //USAREMOS ESTA VARIABLE PARA PINTAR EL FONDO DE LA TABLA CON COLORES MAS RESARTABLES
    
    public panelInformacionDeProductos(JPanel panelPrincipal, JPanel panelOpciones, FloristeriaApp floristeriaApp, Color colorPrimario) {
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
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        //Dibujo la imagen de fondo
//        if (backgroundImage != null) {
//            g.drawImage(backgroundImage, 0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight(), this);
//        }else{
//            System.out.println("No se encontro la imagen");
//        }
//    }

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
                panelPrincipal.remove(panelInformacionDeProductos.this);
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
        labelInfo.setText("SELECCIONA QUE TIPO DE PRODUCTO QUIERES VER                   ");
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

    // Añadir un campo para la referencia del panel de la tabla
    private JPanel tableContent;

    private void minitComponents() {
        //PANEL GLOBAL
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        //Panel para el selector
        JPanel selectorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        selectorPanel.setOpaque(false);

        //Crear los botones (labels estilizados)
        JLabel lblTodo = createSelectorLabel("TODO");
        JLabel lblPlantas = createSelectorLabel("PLANTAS");
        JLabel lblFlores = createSelectorLabel("FLORES");

        //Añadir funcionalidad a los botones
        lblTodo.addMouseListener(new SelectorListener("TODO"));
        lblPlantas.addMouseListener(new SelectorListener("PLANTAS"));
        lblFlores.addMouseListener(new SelectorListener("FLORES"));

        //Añadir botones al selector
        selectorPanel.add(lblTodo);
        selectorPanel.add(lblPlantas);
        selectorPanel.add(lblFlores);

        //Panel para la tabla
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setOpaque(false);

        //Tabla con GridLayout
        tableContent = new JPanel(new GridLayout(0, 4, 10, 10));
        tableContent.setOpaque(false);

        //Encabezados de la tabla
        JLabel headerNombre = createTableHeaderLabel("Nombre");
        JLabel headerStock = createTableHeaderLabel("Stock");
        JLabel headerDetalle = createTableHeaderLabel("Detalle");
        JLabel headerPrecio = createTableHeaderLabel("Precio");

        JPanel headerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        headerPanel.setBorder(new EmptyBorder(0,0,0,17));   //PARA QUE NO QUEDE DESAJUSTADO :v
        headerPanel.setOpaque(false);
        headerPanel.add(headerNombre);
        headerPanel.add(headerStock);
        headerPanel.add(headerDetalle);
        headerPanel.add(headerPrecio);

        // Envolver el contenido de la tabla en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tableContent);
        scrollPane.setBorder(null); // Sin bordes para mantener el estilo
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Velocidad del scroll
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        tablePanel.add(headerPanel, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Añadir ambos paneles al layout principal
        panelCentral.add(selectorPanel, BorderLayout.NORTH);
        panelCentral.add(tablePanel, BorderLayout.CENTER);
        this.add(panelCentral, BorderLayout.CENTER);
        // Inicializar con todos los productos
        actualizarTabla("TODO");
    }

    //Listener para manejar clics en el selector
    private class SelectorListener extends MouseAdapter {
        private String tipo;

        public SelectorListener(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            actualizarTabla(tipo);
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setBackground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setBackground(colorPrimario);
        }
    }

    //Método para actualizar la tabla según el tipo seleccionado
    private void actualizarTabla(String tipo) {
        tableContent.removeAll();

        //Filtrar productos según el tipo
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : floristeriaApp.obtenerProductos()) {
            if (tipo.equals("TODO") || 
               (tipo.equals("PLANTAS") && producto instanceof Planta) || 
               (tipo.equals("FLORES") && producto instanceof Flor)) {
                productosFiltrados.add(producto);
            }
        }

        // Agregar filas de productos
        for (Producto producto : productosFiltrados) {
            JLabel labelNombre = createTableContentLabel(producto.getNombre());
            JLabel labelStock = createTableContentLabel(String.valueOf(producto.getStock()));
            JLabel labelDetalle = createTableContentLabel(producto instanceof Planta
                ? "Tamaño: " + ((Planta) producto).getTamaño()
                : "Color: " + ((Flor) producto).getColor());
            JLabel labelPrecio = createTableContentLabel("€" + producto.getPrecio());

            tableContent.add(labelNombre);
            tableContent.add(labelStock);
            tableContent.add(labelDetalle);
            tableContent.add(labelPrecio);
            
            posicion++;
        }

        // Actualizar panel
        tableContent.revalidate();
        tableContent.repaint();
    }


    //Método auxiliar para crear celdas de tabla
    private JLabel createTableContentLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        if (posicion % 2 == 0){
            label.setBackground(new Color(189, 234, 193));
        }else{
            label.setBackground(Color.white);
        }
            
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    //Método auxiliar para crear encabezados de tabla
    private JLabel createTableHeaderLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JLabel createSelectorLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(colorPrimario);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(5, 15, 5, 15));
        return label;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
