/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package RealidadTenis.Vistas;

import RealidadTenis.Control.TorneoData;
import RealidadTenis.Modelo.Jugador;
import RealidadTenis.Modelo.Torneo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Agostina
 */
public class VistaVerJugadoresPorTorneo extends javax.swing.JInternalFrame {
    private MenuPrincipal menu;
    private TorneoData torneoData;
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<Jugador> jugadores;
    private ArrayList<Torneo> torneos;

    /**
     * Creates new form VistaRanking
     */
    public VistaVerJugadoresPorTorneo(MenuPrincipal menu, TorneoData torneoData) {
        initComponents();
        
        this.menu = menu;
        this.torneoData = torneoData;
        Torneo torneo = (Torneo) jComboBoxTorneos.getSelectedItem();
        
        torneos = (ArrayList<Torneo>) torneoData.obtenerTorneos();
        
        llenarCombo();
        vaciarTabla();
        armarCabecera();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEncuentrosJugador = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRanking = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTorneos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabelEncuentrosJugador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEncuentrosJugador.setText("Ranking");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRanking);

        jLabel1.setText("Seleccionar torneo:");

        jComboBoxTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTorneosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326))))
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabelEncuentrosJugador)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabelEncuentrosJugador)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        menu.verMenuTorneo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTorneosActionPerformed
        // TODO add your handling code here:
        vaciarTabla();
        Torneo torneo = (Torneo) jComboBoxTorneos.getSelectedItem();
        jugadores = (ArrayList<Jugador>) torneoData.obtenerJugadoresPorTorneo(torneo);
        llenarTabla();
    }//GEN-LAST:event_jComboBoxTorneosActionPerformed

    private void armarCabecera() {
        ArrayList<Object> titulos = new ArrayList<>();

        titulos.add("ID");
        titulos.add("Torneo");
        titulos.add("Apellido");
        titulos.add("Nombre");

        for (Object titulo: titulos) {
            modelo.addColumn(titulo);
        }

        jTableRanking.setModel(modelo);
    }

    private void llenarTabla() {
        Torneo torneo = (Torneo) jComboBoxTorneos.getSelectedItem();
        for (Jugador j : jugadores) {
            modelo.addRow(new Object[]{j.getIdJugador(), torneo.getNombreCopa(), j.getApellido(), j.getNombre()});
        }
    }
    
    private void vaciarTabla(){
        int filas = modelo.getRowCount() - 1;

        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void llenarCombo() {
        for (Torneo t: torneos) {
            if (t.isActivo()) {
                jComboBoxTorneos.addItem(t);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Torneo> jComboBoxTorneos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEncuentrosJugador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableRanking;
    // End of variables declaration//GEN-END:variables
}
