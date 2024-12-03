package GUI;

import controller.FloristeriaApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class panelAddProductos extends javax.swing.JPanel {
    
    private JPanel panelOpciones;
    private JPanel panelPrincipal;
    private Color colorPrimario;
    private JLabel cambiante;
    private FloristeriaApp floristeriaApp;

    public panelAddProductos(JPanel panelPrincipal, JPanel panelOpciones, FloristeriaApp flor, Color colorPrimario) {
        this.panelOpciones = panelOpciones;
        this.panelPrincipal = panelPrincipal;
        this.colorPrimario = colorPrimario;
        this.floristeriaApp = floristeriaApp;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setBackground(colorPrimario);
        botonVolverAtras();
        agregarBotones();
        agregarRegistro();
    }

    private void agregarBotones() {
    JPanel panelBotones = new JPanel();
    panelBotones.setBackground(Color.WHITE);

    // AÑADIR FLOR
    JLabel addFlor = new JLabel("Añadir Flor", JLabel.CENTER);
    addFlor.setBackground(colorPrimario);
    addFlor.setOpaque(true);
    addFlor.setForeground(Color.white);
    addFlor.setFont(new Font("Arial", Font.BOLD, 35));
    addFlor.setPreferredSize(new Dimension(200, 45));
    addFlor.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cambiante.setText("Color: ");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            addFlor.setBackground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            addFlor.setBackground(colorPrimario);
        }
    });

    // AÑADIR PLANTA
    JLabel addPlanta = new JLabel("Añadir Planta", JLabel.CENTER);
    addPlanta.setBackground(colorPrimario);
    addPlanta.setOpaque(true);
    addPlanta.setForeground(Color.white);
    addPlanta.setFont(new Font("Arial", Font.BOLD, 35));
    addPlanta.setPreferredSize(new Dimension(250, 45));
    addPlanta.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
             cambiante.setText("Tamaño: ");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            addPlanta.setBackground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            addPlanta.setBackground(colorPrimario);
        }
    });

    panelBotones.add(addFlor); // Añadir al panel
    panelBotones.add(addPlanta); // Añadir al panel

    // Añadir el panel de botones justo debajo del botón Volver
    this.add(panelBotones, BorderLayout.CENTER);
}

    private void agregarRegistro() {
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 40, 0); // Espacio que hay entre los componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;

        // FILA 2: NOMBRE DE CLIENTE
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelCentral.add(nombre, gbc);

        JTextField campoNombre = new JTextField(35);
        campoNombre.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCentral.add(campoNombre, gbc);

        // FILA 3: STOCK
        JLabel dni = new JLabel("Stock: ");
        dni.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentral.add(dni, gbc);

        JTextField campoDNI = new JTextField(35);
        campoDNI.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelCentral.add(campoDNI, gbc);

        // FILA 4: PRECIO
        JLabel precio = new JLabel("Precio: ");
        precio.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentral.add(precio, gbc);

        JTextField campoPrecio = new JTextField(35);
        campoPrecio.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelCentral.add(campoPrecio, gbc);

        // FILA 5: COLOR / TAMAÑO
        cambiante = new JLabel("Color: ");
        cambiante.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelCentral.add(cambiante, gbc);

        JTextField campoColor = new JTextField(35);
        campoColor.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelCentral.add(campoColor, gbc);

        // FILA 6: BOTÓN GUARDAR
        JButton botonConfirmar = new JButton("CONFIRMAR");
        botonConfirmar.setBackground(colorPrimario);
        botonConfirmar.setForeground(Color.WHITE);
        botonConfirmar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panelCentral.add(botonConfirmar, gbc);

        // HAZ EL ACTION LISTENER
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                String dni = campoDNI.getText().trim();
    //                guardarDatos(nombre, dni);
            }
        });

        this.add(panelCentral, BorderLayout.SOUTH);
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
                panelPrincipal.remove(panelAddProductos.this);
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
