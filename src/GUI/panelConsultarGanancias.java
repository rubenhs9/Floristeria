package GUI;

import controller.FloristeriaApp;
import data.Venta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class panelConsultarGanancias extends JPanel{
    private JPanel panelOpciones;
    private JPanel panelPrincipal;
    private Color colorPrimario;
    private Date fecha;
    private FloristeriaApp floristeriaApp;
    

    public panelConsultarGanancias(JPanel panelPrincipal, JPanel panelOpciones,FloristeriaApp floristeriaApp,Color colorPrimario) {
        this.panelOpciones = panelOpciones;
        this.panelPrincipal = panelPrincipal;
        this.colorPrimario = colorPrimario;
        this.floristeriaApp = floristeriaApp;
        this.fecha = fecha;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setBackground(colorPrimario);
        botonVolverAtras();
        panelGanancias();
        verVentasGanancias();
        
    }
    
    private void verVentasGanancias() {
    JPanel p2 = new JPanel();
    p2.setPreferredSize(new Dimension(800, 480));
    p2.setBackground(colorPrimario);
    p2.setLayout(new BorderLayout()); // Asegura un diseño ordenado

    // Obtener las ventas
    ArrayList<Venta> ventas = floristeriaApp.getVentas();

    // Crear un JTextArea
    JTextArea textAreaVentas = new JTextArea();
    textAreaVentas.setFont(new Font("Arial", Font.PLAIN, 25));
    textAreaVentas.setEditable(false);
    textAreaVentas.setLineWrap(true);
    textAreaVentas.setWrapStyleWord(true);

    // Construir el texto para el JTextArea
    StringBuilder textoVentas = new StringBuilder();
    for (Venta venta : ventas) {
        textoVentas.append("Producto: ").append(venta.getProducto().getNombre())
                   .append("\nCantidad: ").append(venta.getCantidad())
                   .append("\nPrecio: ").append(venta.getProducto().getPrecio()).append("€")
                   .append("\nFecha: ").append(venta.getFecha())
                   .append("\n-----------------------\n");
    }

    // Establecer el texto completo después del bucle
    textAreaVentas.setText(textoVentas.toString());

    // Crear un JScrollPane
    JScrollPane scrollVentas = new JScrollPane(textAreaVentas);
    scrollVentas.setPreferredSize(new Dimension(780, 460));

    // Añadir el JScrollPane al panel
    p2.add(scrollVentas, BorderLayout.CENTER);

    // Añadir el panel al componente principal
    this.add(p2, BorderLayout.SOUTH);
    this.revalidate();
    this.repaint();
}

    private void panelGanancias(){
        JPanel p1 = new JPanel();
        this.add(p1, BorderLayout.CENTER);
        
        JLabel l1 = new JLabel();
        l1.setFont(new Font("Arial", Font.BOLD, 45));
        p1.add(l1);
        
        Date fecha = new Date();
        double ganancias = floristeriaApp.calcularGananciasHasta(fecha);
        
        l1.setText("Ganancias: " + ganancias + "€");
    }

    private void botonVolverAtras() {
         JPanel panelIrHaciaAtras = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIrHaciaAtras.setOpaque(false);
        JLabel volverAtras = new JLabel("VOLVER");
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        volverAtras.setFont(new Font("Arial", Font.BOLD, 25));
        volverAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelConsultarGanancias.this);
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
        this.add(panelIrHaciaAtras, BorderLayout.NORTH); // Este es el cambio
    }
    
    
    
}
