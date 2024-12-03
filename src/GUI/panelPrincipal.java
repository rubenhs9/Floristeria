
package GUI;

import controller.FloristeriaApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class panelPrincipal extends javax.swing.JPanel {

    private Vpal vpal;
    private String nombreApp = "PRUEBA";
    private Color colorPrimario = new Color(15, 135, 44); //Color principal de la app, se puede cambiar si no gusta
    private FloristeriaApp floristeriaApp;
    
    public panelPrincipal(Vpal vpal, FloristeriaApp floristeriaApp) {
        this.vpal = vpal; 
        this.floristeriaApp = floristeriaApp;
        
        this.setLayout(new BorderLayout());
        minitComponents();
    }

    public Vpal getVpal() {
        return vpal;
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
        //Creo el Jpanel superior que estara en todo momento enseñando el nombre del insituto
        JPanel panelTituloApp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                Color colorInicio = new Color(10, 66, 23); // Negro
                Color colorFin = new Color(15, 135, 44);  // Granate muy oscuro

                Paint degradado = new LinearGradientPaint(
                    getWidth(), 0, 0, 0, 
                    new float[] {0.0f, 1.0f}, 
                    new Color[] {colorFin, colorInicio}
                );

                g2d.setPaint(degradado);
                g2d.fill(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));
                
                // Cargar la imagen que quieres centrar
//                ImageIcon icon = new ImageIcon(".\\res\\imgInterfaz\\logo.png"); // Ruta de la imagen
//                Image image = icon.getImage();
//
//                // Calcular las coordenadas para centrar la imagen en el panel
//                int x = (getWidth() - image.getWidth(null)) / 2;
//                int y = (getHeight() - image.getHeight(null)) / 2;
//
//                // Dibujar la imagen centrada
//                g2d.drawImage(image, x, y, this);
            }
        };
        panelTituloApp.setLayout(new FlowLayout());
//        panelTituloApp.setBackground(colorPrimario);
        
        
        JLabel titulo = new JLabel();
        titulo.setForeground(Color.WHITE);
        titulo.setText("| PRUEBA |");
        titulo.setFont(new Font("Arial",Font.BOLD,70));
        
        panelTituloApp.add(titulo);
        this.add(panelTituloApp, BorderLayout.NORTH);
        
        //CREAMOS EL PANEL DE OPCIONES
//        panelTextArea panelTextArea = new panelTextArea("HOLA",this, colorPrimario);
//        panelTextArea.cambiarTamñoLetra(20);
//        this.add(panelTextArea,BorderLayout.CENTER);

        panelOpciones panelOpciones = new panelOpciones(vpal, this, colorPrimario, floristeriaApp);
        this.add(panelOpciones);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
