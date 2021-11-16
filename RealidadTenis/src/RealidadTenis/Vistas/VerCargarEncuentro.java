/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealidadTenis.Vistas;

import RealidadTenis.Control.EncuentroData;
import RealidadTenis.Modelo.Encuentro;
import RealidadTenis.Modelo.Jugador;
import RealidadTenis.Modelo.Cancha;
import RealidadTenis.Control.TorneoData;
import RealidadTenis.Control.JugadorData;
import RealidadTenis.Control.CanchaData;
import RealidadTenis.Modelo.Torneo;
import static java.lang.Integer.parseInt;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauri
 */
public class VerCargarEncuentro extends javax.swing.JInternalFrame {
    private boolean ok;
    private EncuentroData ed;
    private Encuentro modEncuentro;
    private TorneoData td;
    private JugadorData jd;
    private CanchaData cd;
    
    private MenuPrincipal menu;
    private int id;
    /**
     * Creates new form AgregarModificarJugador
     */
    public VerCargarEncuentro(MenuPrincipal menu, EncuentroData ed, TorneoData td, JugadorData jd, CanchaData cd) {
        initComponents();
        this.ed = ed;
        modEncuentro = new Encuentro();
        this.menu = menu;
        
        Iterator<Torneo> it2 = td.obtenerTorneosActivos().iterator();
        //jComboBoxMateria.addItem(null);
        while(it2.hasNext()){
            Torneo t1 = it2.next();
            
            jComboBoxTorneo.addItem(t1.toString());
            
        }
        
        Iterator<Jugador> it3 = jd.obtenerJugadores().iterator();
        //jComboBoxMateria.addItem(null);
        while(it3.hasNext()){
            Jugador j1 = it3.next();
            if(j1.isActivo()){
                jComboBoxJ1.addItem(j1.toString());
                jComboBoxJ2.addItem(j1.toString());
            }
        }
        Iterator<Cancha> it4 = cd.obtenerCanchasEnUso().iterator();
        //jComboBoxMateria.addItem(null);
        while(it4.hasNext()){
            Cancha c1 = it4.next();
            jComboBoxCancha.addItem(c1.toString());
        }
        
        jComboBoxTorneo.setSelectedIndex(-1);
        jComboBoxJ1.setSelectedIndex(-1);
        jComboBoxJ2.setSelectedIndex(-1);
        jComboBoxCancha.setSelectedIndex(-1);
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
        jButtonLimpiar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jCheckBoxEstado = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTextIdEncuentro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFecha = new javax.swing.JTextField();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBoxTorneo = new javax.swing.JComboBox<>();
        jComboBoxJ1 = new javax.swing.JComboBox<>();
        jComboBoxJ2 = new javax.swing.JComboBox<>();
        jComboBoxCancha = new javax.swing.JComboBox<>();

        jButtonGuardar.setBackground(new java.awt.Color(0, 153, 51));
        jButtonGuardar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonLimpiar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
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

        jCheckBoxEstado.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jCheckBoxEstado.setText("Jugado");
        jCheckBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEstadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel2.setText("Jugador 1:");

        jTextIdEncuentro.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel1.setText("Id de Encuentro");

        jButtonBuscar.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("* Busque para ver disponibilidad");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MENU ENCUENTRO: NUEVO ENCUENTRO");

        jLabel3.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel3.setText("Torneo:");

        jLabel8.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel8.setText("Jugador 2:");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel9.setText("Cancha:");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel10.setText("Fecha:");

        jTextFecha.setEditable(false);
        jTextFecha.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N

        jCheckBoxActivo.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jCheckBoxActivo.setText("Activo");
        jCheckBoxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(110, 110, 110)
                .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTorneo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextIdEncuentro)
                            .addComponent(jComboBoxJ1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 244, Short.MAX_VALUE)
                            .addComponent(jComboBoxJ2, 0, 244, Short.MAX_VALUE)
                            .addComponent(jComboBoxCancha, javax.swing.GroupLayout.Alignment.TRAILING, 0, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addComponent(jCheckBoxEstado)
                            .addComponent(jCheckBoxActivo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextIdEncuentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBoxEstado)
                    .addComponent(jComboBoxJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBoxActivo)
                    .addComponent(jComboBoxCancha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonLimpiar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        
        /*
        int ID=0;
        try{
            ID=Integer.parseInt(jTextIdEncuentro.getText());
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Volver a cargar, en campo numero de cancha ingresar solo numeros");
        }
        String ciudad = jTextTorneo.getText();
        String categoria = jTextJ1.getText();
        int ancho = parseInt(jTextJ2.getText());
        int largo = parseInt(jTextCancha.getText());
        int capacidad = parseInt(jTextFecha.getText());
        

        if(ciudad==null||ID==0||categoria==null||ancho==0||largo==0||capacidad==0){
            JOptionPane.showMessageDialog(this,"Rellene todos los campos");
        }
        else{
            if (ok == false) {
                modEncuentro.setCiudad(ciudad);
                modEncuentro.setCategoria(categoria);
                modEncuentro.setAncho(ancho);
                modEncuentro.setLargo(largo);
                modEncuentro.setCapacidad(capacidad);
                modEncuentro.setEnUso(jCheckBoxJugado.isSelected());
                
                ed.guardarEncuentro(modEncuentro);
            }
            else {
                modEncuentro.setCiudad(ciudad);
                modEncuentro.setCategoria(categoria);
                modEncuentro.setAncho(ancho);
                modEncuentro.setLargo(largo);
                modEncuentro.setCapacidad(capacidad);
                modEncuentro.setEnUso(jCheckBoxJugado.isSelected());
                
                ed.guardarEncuentro(modEncuentro);
            }
            jButtonGuardar.setEnabled(false);
            JOptionPane.showMessageDialog(this,"La cancha fue ingresada al sistema con exito");
            this.jButtonLimpiarActionPerformed(evt);
        }
        this.jButtonLimpiarActionPerformed(evt);
    */
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        
        jTextIdEncuentro.setText("");
        jComboBoxTorneo.setSelectedIndex(-1);
        jComboBoxJ1.setSelectedIndex(-1);
        jComboBoxJ2.setSelectedIndex(-1);
        jComboBoxCancha.setSelectedIndex(-1);
        jTextFecha.setText("");
        jButtonGuardar.setEnabled(false);

    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        //menu.sesionDocente(user);
        menu.verMenuZonaDeCarga();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jCheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxEstadoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        
        int ID = 0;
        ok = false;

        try{
            ID = Integer.parseInt(jTextIdEncuentro.getText());
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Volver a cargar, en campo numero de encuentro ingresar solo numeros");
        }
        if(ID==0){
            JOptionPane.showMessageDialog(this,"Volver a cargar, en campo numero de encuentro ingresar solo numeros");
        }
        else {
            Iterator it = ed.obtenerEncuentros().iterator();
            while(it.hasNext()){
                Encuentro e1 = (Encuentro)it.next();
                if(ID == e1.getIdEncuentro()){
                    id = e1.getIdEncuentro();
                    
                    for(int i = 0; i <= jComboBoxTorneo.getItemCount(); i++){
                        jComboBoxTorneo.setSelectedIndex(i);
                        Torneo m1 = (Torneo)jComboBoxTorneo.getSelectedItem();
                        System.out.println("Id torneo: " + m1.getIdTorneo());
                        if(m1.getIdTorneo() == e1.getTorneo().getIdTorneo()){
                            break;
                        }
                    }
                }
                    //jComboBoxTorneo.setSelectedIndex(e1.getTorneo());
                    /*
                    jTextFecha.setText(e1.getFecha().toString());
                    

                    if(e1.getEstado().equals("Jugado")){
                        jCheckBoxEstado.setSelected(true);
                    }
                    else {
                        jCheckBoxEstado.setSelected(false);
                    }
                    if(e1.isActivo()){
                        jCheckBoxActivo.setSelected(true);
                    }
                    else {
                        jCheckBoxActivo.setSelected(false);
                    }
                    modEncuentro.setIdEncuentro(id);
                    jTextJ1.setEditable(true);
                    jTextTorneo.setEditable(true);
                    jTextJ2.setEditable(true);
                    jTextCancha.setEditable(true);
                    jTextFecha.setEditable(true);
                    jCheckBoxEstado.setEnabled(true);
                    jCheckBoxActivo.setEnabled(true);
                    jButtonGuardar.setEnabled(true);
                    ok = true;
                }
            }
            if(ok == false){
                this.jButtonLimpiarActionPerformed(evt);
                jTextJ1.setEditable(true);
                jTextTorneo.setEditable(true);
                jTextJ2.setEditable(true);
                jTextCancha.setEditable(true);
                jTextFecha.setEditable(true);
                jTextIdEncuentro.setText(String.valueOf(ID));
                jCheckBoxEstado.setEnabled(true);
                jCheckBoxActivo.setEnabled(true);
                JOptionPane.showMessageDialog(this , ID+" ,está disponible para usar");
                jButtonGuardar.setEnabled(true);
            }
        }
*/}
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jCheckBoxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxActivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JCheckBox jCheckBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxCancha;
    private javax.swing.JComboBox<String> jComboBoxJ1;
    private javax.swing.JComboBox<String> jComboBoxJ2;
    private javax.swing.JComboBox<String> jComboBoxTorneo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField jTextIdEncuentro;
    // End of variables declaration//GEN-END:variables
}