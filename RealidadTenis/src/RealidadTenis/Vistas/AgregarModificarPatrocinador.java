/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealidadTenis.Vistas;

import RealidadTenis.Control.PatrocinadorData;
import RealidadTenis.Modelo.Patrocinador;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author Win10
 */
public class AgregarModificarPatrocinador extends javax.swing.JInternalFrame {
    private PatrocinadorData pd;
    private MenuPrincipal menu;
    /**
     * Creates new form AgregarModificarPatrocinador
     */
    public AgregarModificarPatrocinador(MenuPrincipal menu, PatrocinadorData pd) {
        initComponents();
        this.pd = pd;
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

        jButtonGuardar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextIdPatrocinador = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextMarca = new javax.swing.JTextField();
        jCheckBoxEstado = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonEditable = new javax.swing.JButton();

        jButtonGuardar.setBackground(new java.awt.Color(0, 153, 51));
        jButtonGuardar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(204, 0, 51));
        jButtonSalir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AGREGAR/MODIFICAR PATROCINADOR");

        jTextIdPatrocinador.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jTextIdPatrocinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdPatrocinadorActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonBuscar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel1.setText("ID del Patrocinador");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel2.setText("Marca");

        jTextMarca.setEditable(false);
        jTextMarca.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N

        jCheckBoxEstado.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jCheckBoxEstado.setText("Actualmente ACTIVA");
        jCheckBoxEstado.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel6.setText("* Busque para ver disponibilidad");

        jButtonLimpiar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonLimpiar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonEditable.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jButtonEditable.setText("Habilitar edición");
        jButtonEditable.setEnabled(false);
        jButtonEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(jTextIdPatrocinador, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(145, 145, 145)
                                .addComponent(jTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEditable)
                                    .addComponent(jCheckBoxEstado))))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextIdPatrocinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditable)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonGuardar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        int id = 0;
        String nomb = "";
        boolean exc = false;
        Patrocinador p = new Patrocinador();
        try{
            id = parseInt(jTextIdPatrocinador.getText());
            nomb = jTextMarca.getText();
            exc = true; //Verifico si hay elementos en cada uno de los jText
        }catch(Exception ex){
            exc = false;
        }
        if (exc){
            if (pd.patrocinadorExiste(id)){
                p = pd.buscarPatrocinador(id);
                p.setMarca(nomb);
                if(jCheckBoxEstado.isSelected()!= p.isActivo())
                pd.modificarEstado(id);
                pd.actualizarPatrocinador(p);
                p = pd.buscarPatrocinador(id);
            }else{
                p.setMarca(nomb);
                p.setIdPatrocinador(id);
                if(jCheckBoxEstado.isSelected())
                p.setActivo(true);
                else
                p.setActivo(false);
                pd.guardarPatrocinador(p);
            }
            JOptionPane.showMessageDialog(null,"Patrocinador guardado con éxito");
        }else
        JOptionPane.showMessageDialog(null,"Alguno de los campos no cumple con el tipo de dato o se encuentra vacio.");
        jButtonLimpiarActionPerformed(evt);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        menu.verMenuZonaDeCarga();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextIdPatrocinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdPatrocinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdPatrocinadorActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        int id = 0;
        try{
            id = Integer.valueOf(jTextIdPatrocinador.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"El campo ID solo admite caracteres numéricos mayores a cero");
        }
        if(id>0){
            Patrocinador p = new Patrocinador();
            if(pd.patrocinadorExiste(id)){
                p = pd.buscarPatrocinador(id);
                
                jTextMarca.setText(p.getMarca());
                jCheckBoxEstado.setEnabled(true);
                jCheckBoxEstado.setSelected(p.isActivo());
                jButtonLimpiar.setEnabled(true);
                jButtonEditable.setEnabled(true);
                
                jTextMarca.setEditable(false);
                jCheckBoxEstado.setEnabled(false);
                
                if(p.isActivo())
                jCheckBoxEstado.setSelected(true);
                JOptionPane.showMessageDialog(null, id + " , ya pertenece un patrocinio en el sistema, si desea puede editar la información");
            }else{
                JOptionPane.showMessageDialog(null, id + " , se encuentra disponible. Complete los campos");
                jButtonGuardar.setEnabled(true);
                jTextIdPatrocinador.setEditable(false);
                jTextMarca.setText("");
                jTextMarca.setEditable(true);
                jCheckBoxEstado.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        jTextMarca.setText("");
        jTextIdPatrocinador.setText("");
        jButtonLimpiar.setEnabled(true);
        jTextIdPatrocinador.setEditable(true);
        jTextMarca.setEditable(false);
        jCheckBoxEstado.setEnabled(false);
        jButtonEditable.setEnabled(false);
        jButtonGuardar.setEnabled(false);
        jCheckBoxEstado.setSelected(false);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditableActionPerformed
        jTextIdPatrocinador.setEditable(false);
        jButtonLimpiar.setEnabled(false);
        jTextMarca.setEditable(true);
        jCheckBoxEstado.setEnabled(true);
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButtonEditableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditable;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextIdPatrocinador;
    private javax.swing.JTextField jTextMarca;
    // End of variables declaration//GEN-END:variables
}
