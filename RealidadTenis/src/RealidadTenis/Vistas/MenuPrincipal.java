/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealidadTenis.Vistas;

import RealidadTenis.Control.*;
import RealidadTenis.Modelo.Conexion;
/**
 *
 * @author Mauri
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private Conexion conexion;
    private CanchaData canchaData;
    private ContratoData contratoData;
    private EncuentroData encuentroData;
    private JugadorData jugadorData;
    private PatrocinadorData patrocinadorData;
    private TorneoData torneoData;
    
    /**
     * Creates new form MenuPrincipal
     */
    
    public MenuPrincipal() {
        initComponents();
        
        try {
            conexion = new Conexion();
            canchaData = new CanchaData(conexion);
            contratoData = new ContratoData(conexion);
            encuentroData = new EncuentroData(conexion);
            jugadorData = new JugadorData(conexion);
            patrocinadorData = new PatrocinadorData(conexion);
            torneoData = new TorneoData(conexion);

            this.iniciarSesion();

            verMunuListados();
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo crear conexion");
        }
    }
    
    public void iniciarSesion(){
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        VistaInicio vista = new VistaInicio(conexion, this);
        jDesktopPane.add(vista);
        jDesktopPane.moveToFront(vista);
        vista.setVisible(true); 
    }
    
    public void verMenuZonaDeCarga(){
        MenuZonaDeCarga vista = new MenuZonaDeCarga(this);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verMunuListados(){
        MenuListados vista = new MenuListados(this);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verAgregarModificarJugador(){
        AgregarModificarJugador vista = new AgregarModificarJugador(this, jugadorData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verAgregarModificarCancha(){
        AgregarModificarCancha vista = new AgregarModificarCancha(this, canchaData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verAgregarModificarPatrocinador(){
        AgregarModificarPatrocinador vista = new AgregarModificarPatrocinador(this, patrocinadorData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    

    public void verVistaVerJugadores() {
        VistaVerJugadores vista = new VistaVerJugadores(this, jugadorData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verMenuTorneo(){
        MenuTorneo vista = new MenuTorneo(this);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    public void verAgregarNuevoTorneo(){
        AgregarNuevoTorneo vista = new AgregarNuevoTorneo(this, torneoData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verMenuEncuentro(){
        MenuEncuentro vista = new MenuEncuentro(this, encuentroData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verCargarEncuentro(){
        VerCargarEncuentro vista = new VerCargarEncuentro(this, encuentroData, torneoData, jugadorData, canchaData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verModificarEncuentro(){
        VerModificarEncuentro vista = new VerModificarEncuentro(this, encuentroData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verProxEncuentros(){
        VerProxEncuentros vista = new VerProxEncuentros(this, encuentroData);
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }
    
    public void verVistaVerCanchas() {
        VistaVerCanchas vista = new VistaVerCanchas(this, canchaData);
        
        jDesktopPane.removeAll();
        jDesktopPane.moveToFront(vista);
        jDesktopPane.repaint();
        jDesktopPane.add(vista);

        vista.setVisible(true);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        jMenu1.setText("Admin");

        jMenuItem.setText("Salir");
        jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSesionActionPerformed

    private void jMenuItemCambiarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCambiarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCambiarSesionActionPerformed

    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem;
    // End of variables declaration//GEN-END:variables

}