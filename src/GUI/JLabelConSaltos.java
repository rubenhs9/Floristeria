
package GUI;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class JLabelConSaltos extends JLabel{
    
    private String texto;
    
    public JLabelConSaltos(String text) {
        super(text);
        this.texto = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        
       super.paintComponent(g);  // Llamada a super para que se dibuje el fondo, borde, etc.
       setText("");  // Elimina el texto predeterminado

       // Convertir Graphics a Graphics2D para mayor control
       Graphics2D g2d = (Graphics2D) g;

       // Activar antialiasing para mejorar la calidad del texto
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

       // Se configura la fuente y el color
       g2d.setFont(getFont());
       g2d.setColor(getForeground());

       // Dividir el texto en líneas usando el salto de línea '\n'
       String[] lineas = texto.split("\n");

       // Obtener las métricas de la fuente
       FontMetrics fm = g2d.getFontMetrics();

       // Se calcula la posición inicial para dibujar las líneas
       int y = getInsets().top + fm.getAscent();  // Posición y inicial (margen superior)

       // Dibujar solo la primera línea centrada
       for (String linea : lineas) {
           // Línea centrada
           int xCentro = (getWidth() - fm.stringWidth(linea)) / 2;  // Centrado horizontal
           g2d.drawString(linea, xCentro, y);

           // Incrementar la posición y para la siguiente línea
           y += fm.getHeight() - 5;
       }
       
   }
}
