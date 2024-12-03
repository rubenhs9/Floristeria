
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
        super.paintComponent(g);  // Dibuja el fondo y bordes del componente
        setText("");

        // Convertir Graphics a Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Activar antialiasing para texto de mejor calidad
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //Configurar fuente y color
        g2d.setFont(getFont());
        g2d.setColor(getForeground());

        //Dividir el texto en líneas usando '\n'
        String[] lineas = texto.split("\n");

        //Obtener métricas de fuente
        FontMetrics fm = g2d.getFontMetrics();

        //Calcular la altura total del texto (considerando todas las líneas)
        int alturaTexto = lineas.length * fm.getHeight();

        //Calcular el punto inicial Y para centrar verticalmente
        int yInicio = (getHeight() - alturaTexto) / 2 + fm.getAscent();

        //Dibujar cada línea centrada horizontalmente
        for (String linea : lineas) {
            int xCentro = (getWidth() - fm.stringWidth(linea)) / 2;  //Centrado horizontal
            g2d.drawString(linea, xCentro, yInicio);
            yInicio += fm.getHeight();  //Incrementar para la siguiente línea
        }
    }

}
