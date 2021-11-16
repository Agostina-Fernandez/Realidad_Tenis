/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealidadTenis.Vistas;

/**
 *
 * @author Win10
 */
public class MenuListados extends javax.swing.JInternalFrame {
    MenuPrincipal menu;

    /**
     * Creates new form MenuListados
     */
    public MenuListados(MenuPrincipal menu) {
        initComponents();
        
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
        jButtonVerJugadores = new javax.swing.JButton();
        jButtonVerCanchas = new javax.swing.JButton();
        jButtonVerTorneos = new javax.swing.JButton();
        jButtonVerPatrocinadores = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu de Listados");

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonVerJugadores.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVerJugadores.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonVerJugadores.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerJugadores.setText("Ver a todos los Jugadores");
        jButtonVerJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerJugadoresActionPerformed(evt);
            }
        });

        jButtonVerCanchas.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVerCanchas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonVerCanchas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerCanchas.setText("Ver todas las Canchas");
        jButtonVerCanchas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCanchasActionPerformed(evt);
            }
        });

        jButtonVerTorneos.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVerTorneos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonVerTorneos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerTorneos.setText("Ver Torneos de un Jugador");
        jButtonVerTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTorneosActionPerformed(evt);
            }
        });

        jButtonVerPatrocinadores.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVerPatrocinadores.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonVerPatrocinadores.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerPatrocinadores.setText("Ver a todos los Patrocinadores");
        jButtonVerPatrocinadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPatrocinadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVerCanchas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVerJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVerTorneos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVerPatrocinadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButtonVerJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonVerCanchas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonVerPatrocinadores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonVerTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerJugadoresActionPerformed
        // TODO add your handling code here:
        menu.verVistaVerJugadores();
    }//GEN-LAST:event_jButtonVerJugadoresActionPerformed

    private void jButtonVerCanchasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCanchasActionPerformed
        // TODO add your handling code here:
        
        menu.verVistaVerCanchas();
    }//GEN-LAST:event_jButtonVerCanchasActionPerformed

    private void jButtonVerTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerTorneosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVerTorneosActionPerformed

    private void jButtonVerPatrocinadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPatrocinadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVerPatrocinadoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVerCanchas;
    private javax.swing.JButton jButtonVerJugadores;
    private javax.swing.JButton jButtonVerPatrocinadores;
    private javax.swing.JButton jButtonVerTorneos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
