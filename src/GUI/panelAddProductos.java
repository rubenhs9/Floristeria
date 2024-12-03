package GUI;

import controller.FloristeriaApp;
import data.Flor;
import data.Planta;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private boolean flor = true;

    public panelAddProductos(JPanel panelPrincipal, JPanel panelOpciones, FloristeriaApp floristeriaApp, Color colorPrimario) {
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
    gbc.insets = new Insets(20, 10, 40, 0); // Espacio entre componentes
    gbc.fill = GridBagConstraints.HORIZONTAL;

    gbc.gridy = 0;

    // FILA 2: NOMBRE DE CLIENTE
    JLabel nombreLabel = new JLabel("Nombre: ");
    nombreLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panelCentral.add(nombreLabel, gbc);

    JTextField campoNombre = new JTextField(35);
    campoNombre.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
    gbc.gridx = 1;
    gbc.gridy = 1;
    panelCentral.add(campoNombre, gbc);

    // FILA 3: STOCK
    JLabel stockLabel = new JLabel("Stock: ");
    stockLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    gbc.gridx = 0;
    gbc.gridy = 2;
    panelCentral.add(stockLabel, gbc);

    JTextField campoStock = new JTextField(35);
    campoStock.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
    gbc.gridx = 1;
    gbc.gridy = 2;
    panelCentral.add(campoStock, gbc);

    campoStock.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char caracter = e.getKeyChar();
            if (!Character.isDigit(caracter)) {
                e.consume(); // Ignorar caracteres no numéricos
            }
        }
    });

    // FILA 4: PRECIO
    JLabel precioLabel = new JLabel("Precio: ");
    precioLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    gbc.gridx = 0;
    gbc.gridy = 3;
    panelCentral.add(precioLabel, gbc);

    JTextField campoPrecio = new JTextField(35);
    campoPrecio.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
    gbc.gridx = 1;
    gbc.gridy = 3;
    panelCentral.add(campoPrecio, gbc);

    campoPrecio.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char caracter = e.getKeyChar();
            String textoActual = campoPrecio.getText() + caracter;

            // Permitir solo números y un punto decimal
            if (!textoActual.matches("\\d*\\.?\\d*")) {
                e.consume(); // Ignorar caracteres no válidos
            }
        }
    });

    // FILA 5: COLOR / TAMAÑO
    JLabel cambiante = new JLabel("Color: ");
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
    JLabel botonConfirmar = new JLabel("CONFIRMAR", JLabel.CENTER);
    botonConfirmar.setBackground(colorPrimario);
    botonConfirmar.setOpaque(true);
    botonConfirmar.setForeground(Color.WHITE);
    botonConfirmar.setFont(new Font("Arial", Font.BOLD, 35));
    botonConfirmar.setPreferredSize(new Dimension(200, 45));
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 2;
    panelCentral.add(botonConfirmar, gbc);

    // Acción del botón
    botonConfirmar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                String nombre = campoNombre.getText().trim();
                String stockText = campoStock.getText().trim();
                String precioText = campoPrecio.getText().trim();
                String color = campoColor.getText().trim();

                // Validar datos
                if (nombre.isEmpty() || nombre.length() > 20) {
                    JOptionPane.showMessageDialog(panelCentral, "El nombre no puede estar vacío ni exceder 20 caracteres.");
                    return;
                }
                if (stockText.isEmpty()) {
                    JOptionPane.showMessageDialog(panelCentral, "El stock debe ser un número válido.");
                    return;
                }
                if (precioText.isEmpty()) {
                    JOptionPane.showMessageDialog(panelCentral, "El precio debe ser un número válido.");
                    return;
                }
                if (color.isEmpty() || color.length() > 40) {
                    JOptionPane.showMessageDialog(panelCentral, "El color no puede estar vacío ni exceder 40 caracteres.");
                    return;
                }

                int stock = Integer.parseInt(stockText);
                double precio = Double.parseDouble(precioText);

                // Agregar producto a la floristería
                if (flor) {
                    floristeriaApp.agregarProducto(new Flor(nombre, stock, precio, color));
                } else {
                    floristeriaApp.agregarProducto(new Planta(nombre, stock, precio, color));
                }

                JOptionPane.showMessageDialog(panelCentral, "Producto agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panelCentral, "Por favor, ingresa valores válidos.");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            botonConfirmar.setBackground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            botonConfirmar.setBackground(colorPrimario);
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
