package GUI;

import controller.FloristeriaApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelConsultarGanancias extends JPanel{
    private JPanel panelOpciones;
    private JPanel panelPrincipal;
    private Color colorPrimario;
    private FloristeriaApp floristeriaApp;

    public panelConsultarGanancias(JPanel panelPrincipal, JPanel panelOpciones,FloristeriaApp floristeriaApp,Color colorPrimario) {
        this.panelOpciones = panelOpciones;
        this.panelPrincipal = panelPrincipal;
        this.colorPrimario = colorPrimario;
        this.floristeriaApp = floristeriaApp;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setBackground(colorPrimario);
        botonVolverAtras();
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
