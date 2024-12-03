
package GUI;

import controller.FloristeriaApp;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;


public class Vpal extends javax.swing.JFrame {

    private FloristeriaApp floristeriaApp;


    public Vpal(FloristeriaApp floristeriaApp) {
        this.setSize(1280,720);
        this.setMinimumSize(new Dimension(1280,720));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout());
        
        this.floristeriaApp = floristeriaApp;
                
        minitComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minitComponents() {
        //Iniciamos el primer panel principal
        panelPrincipal panelPrincipal = new panelPrincipal(this, floristeriaApp); 
        this.add(panelPrincipal);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
