
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
import java.awt.MediaTracker;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class panelPrincipal extends javax.swing.JPanel {

    private Vpal vpal;
//    private String nombreApp = "PRUEBA";
    private Color colorPrimario = new Color(15, 135, 44); //Color principal de la app, se puede cambiar si no gusta
    private FloristeriaApp floristeriaApp;
    private String logo = "res/img/logo.png";
    
    
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

    /**
     * <b 
     *               ||Rubén|| 
     * Buenas Jesús, he añadido imágenes y logos. 
     * Esta línea es para ajustar la imagen del logo x si no te gusta.
     * Está en este minitComponents().
     * 
     *              double scaleFactor = 2;
     * 
     * 
     */
    private void minitComponents() {
    // Crear el JPanel superior
    JPanel panelTituloApp = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            Color colorInicio = new Color(10, 66, 23); 
            Color colorFin = new Color(15, 135, 44);  
            Paint degradado = new LinearGradientPaint(
                0, 0, getWidth(), 0, 
                new float[] {0.0f, 1.0f}, 
                new Color[] {colorInicio, colorFin}
            );

            g2d.setPaint(degradado);
            g2d.fill(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));

            ImageIcon icon = new ImageIcon(logo);
            Image image = icon.getImage();

            if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("ERROR CARGA IMAGEN");
                return;
            }

            int imageWidth = icon.getIconWidth();
            int imageHeight = icon.getIconHeight();

            double scaleX = (double) getWidth() / imageWidth;
            double scaleY = (double) getHeight() / imageHeight;
            double scale = Math.min(scaleX, scaleY);
            
            double scaleFactor = 2; /* → → → ESTO AJUSTA LA ESCALA DE LA FOTO */
            int newWidth = (int) (imageWidth * scale * scaleFactor);
            int newHeight = (int) (imageHeight * scale * scaleFactor);
            
            int x = (getWidth() - newWidth) / 2;
            int y = (getHeight() - newHeight) / 2;

            g2d.drawImage(image, x, y, newWidth, newHeight, this);
        }
    };
    
    panelTituloApp.setPreferredSize(new java.awt.Dimension(0, 150)); 
    panelTituloApp.setLayout(new FlowLayout());

    this.add(panelTituloApp, BorderLayout.NORTH);

    panelOpciones panelOpciones = new panelOpciones(vpal, this, colorPrimario, floristeriaApp);
    this.add(panelOpciones, BorderLayout.CENTER);
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
