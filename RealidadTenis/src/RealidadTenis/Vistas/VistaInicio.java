/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealidadTenis.Vistas;

import RealidadTenis.Modelo.Conexion;
import javax.swing.JOptionPane;

/**
 * Esta es una vista de prueba para probar algo
 * @author Aryl
 */
public class VistaInicio extends javax.swing.JInternalFrame {
    private Conexion conexion;
    private MenuPrincipal menu;
    
    /**
     * Creates new form VistaInicio
     */
    public VistaInicio(Conexion conexion, MenuPrincipal menu) {
        initComponents();
        
        this.conexion = conexion;
        this.menu = menu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButtonZonaDeCarga = new javax.swing.JButton();
        jButtonMenuTorneo = new javax.swing.JButton();
        jButtonMenuEncuentro = new javax.swing.JButton();
        jButtonMenuContrato = new javax.swing.JButton();
        jButtonMenuListado = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Organizador de Torneos AMA");

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonZonaDeCarga.setBackground(new java.awt.Color(153, 153, 153));
        jButtonZonaDeCarga.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonZonaDeCarga.setForeground(new java.awt.Color(255, 255, 255));
        jButtonZonaDeCarga.setText("Zona de carga");
        jButtonZonaDeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZonaDeCargaActionPerformed(evt);
            }
        });

        jButtonMenuTorneo.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMenuTorneo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonMenuTorneo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenuTorneo.setText("Torneos");
        jButtonMenuTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuTorneoActionPerformed(evt);
            }
        });

        jButtonMenuEncuentro.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMenuEncuentro.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonMenuEncuentro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenuEncuentro.setText("Encuentros");
        jButtonMenuEncuentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuEncuentroActionPerformed(evt);
            }
        });

        jButtonMenuContrato.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMenuContrato.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonMenuContrato.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenuContrato.setText("Contratos");
        jButtonMenuContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuContratoActionPerformed(evt);
            }
        });

        jButtonMenuListado.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMenuListado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonMenuListado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenuListado.setText("Listados");
        jButtonMenuListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuListadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMenuListado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenuContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenuEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMenuTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonZonaDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonZonaDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMenuTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMenuEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMenuContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMenuListado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonZonaDeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZonaDeCargaActionPerformed
        // TODO add your handling code here:
        menu.verMenuZonaDeCarga();
    }//GEN-LAST:event_jButtonZonaDeCargaActionPerformed

    private void jButtonMenuTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuTorneoActionPerformed

    private void jButtonMenuEncuentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuEncuentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuEncuentroActionPerformed

    private void jButtonMenuContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuContratoActionPerformed

    private void jButtonMenuListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuListadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuListadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenuContrato;
    private javax.swing.JButton jButtonMenuEncuentro;
    private javax.swing.JButton jButtonMenuListado;
    private javax.swing.JButton jButtonMenuTorneo;
    private javax.swing.JButton jButtonZonaDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
