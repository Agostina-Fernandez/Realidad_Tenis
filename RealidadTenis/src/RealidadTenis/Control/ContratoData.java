/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Contrato;
import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Jugador;
import RealidadTenis.Modelo.Patrocinador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauri
 */
public class ContratoData {
    private Connection conexion;
    private Conexion conex;

    public ContratoData(Conexion conexion) {
        try {
            this.conexion = conexion.getConexion();
            this.conex = conexion;
        }catch (SQLException ex) {
            System.out.println("Error de conexión");
        }
    }
    
    public void guardarContrato(Contrato contrato, int idJ, int idP){
        String comandoSql = "INSERT INTO contrato (id_jugador, id_patrocinador, inicio_contrato, fin_contrato, activo) VALUES (?,?,?,?,?)";  
        
        PreparedStatement prepStat;
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setInt(1, contrato.getJugador().getIdJugador());
            prepStat.setInt(2, contrato.getPatrocinador().getIdPatrocinador());
            prepStat.setDate(3, Date.valueOf(contrato.getInicioContrato()));
            prepStat.setDate(4, Date.valueOf(contrato.getFinContrato()));
            prepStat.setBoolean(5, contrato.isActivo());
            
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys(); //recupero el Id
            
            if (resultSet.next()){
                contrato.setIdContrato(resultSet.getInt("id_contrato"));
            }
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
    }
    
    public Contrato buscarContrato(int id){
        String comandoSql="SELECT contrato.id, jugador.apellido, jugador.nombre, "
                + "patrocinador.marca"
                + "FROM contrato, jugador, patrocinador WHERE contrato.id_jugador = jugador.id_jugador"
                + "AND contrato.id_patrocinador = patrocinador.id_patrocinador AND id_contrato=?";
        Contrato contrato = new Contrato();
        Jugador jugador;
        Patrocinador patrocinador;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            prepStat.setInt(1, id);

            ResultSet rs = prepStat.executeQuery();
            
               if(rs.next()) {
                   contrato = new Contrato();
                   
                   jugador = buscarJugador(rs.getInt("id_jugador"));
                   patrocinador = buscarPatrocinador(rs.getInt("id_patrocinador"));
                   contrato.setJugador(jugador);
                   contrato.setPatrocinador(patrocinador);
                   contrato.setInicioContrato(rs.getDate("inicio_contrato").toLocalDate());
                   contrato.setInicioContrato(rs.getDate("fin_contrato").toLocalDate());
               }
               
               prepStat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contrato;
    }
    
    public List<Contrato> obtenerContratoPatrocinador(int id){
        ArrayList<Contrato> listaPatrocinador = new ArrayList<>();
        String comandoSql = "SELECT * FROM contrato, jugador, patrocinador WHERE "
                + "contrato.id_jugador=jugador.idJugador and "
                + "contrato.id_patrocinador=patrocinador.idPatrocinador and patrocinador.idPatrocinador = ?";
        Contrato contrato;
        Jugador jugador;
        Patrocinador patrocinador;
        
            try {
               PreparedStatement ps = conexion.prepareStatement(comandoSql);

               ps.setInt(1, id);

               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   contrato = new Contrato();
                   jugador = buscarJugador(rs.getInt("id_jugador"));
                   patrocinador = buscarPatrocinador(rs.getInt("id_patrocinador"));
                   contrato.setJugador(jugador);
                   contrato.setPatrocinador(patrocinador);
                   contrato.setInicioContrato(rs.getDate("inicio_contrato").toLocalDate());
                   contrato.setInicioContrato(rs.getDate("fin_contrato").toLocalDate());

                   listaPatrocinador.add(contrato);
               }
               
               ps.close();

           } catch (SQLException ex) {
               System.out.println("Error en buscar");
           }

        return listaPatrocinador;
    }
    
    public List<Contrato> obtenerContratoPatrocinadorActivas(int id){
        ArrayList<Contrato> listaPatrocinador = new ArrayList<>();
        String comandoSql = "SELECT * FROM contrato,jugador,patrocinador WHERE "
                + "contrato.id_jugador=jugador.idJugador and "
                + "contrato.id_patrocinador=patrocinador.idPatrocinador AND activo = true and patrocinador.idPatrocinador = ?";
        Contrato contrato;
        Jugador jugador;
        Patrocinador patrocinador;
        
            try {
               PreparedStatement ps = conexion.prepareStatement(comandoSql);

               ps.setInt(1, id);

               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   contrato = new Contrato();
                   jugador = buscarJugador(rs.getInt("idAlumno"));
                   patrocinador = buscarPatrocinador(rs.getInt("idMateria"));
                   contrato.setJugador(jugador);
                   contrato.setPatrocinador(patrocinador);
                   contrato.setInicioContrato(rs.getDate("inicio_contrato").toLocalDate());
                   contrato.setInicioContrato(rs.getDate("fin_contrato").toLocalDate());

                   listaPatrocinador.add(contrato);
               }
               
               ps.close();

           } catch (SQLException ex) {
               System.out.println("Error en buscar");
           }

        return listaPatrocinador;
    }
    
    public List<Contrato> obtenerContratoDeJugadores(int id){
        ArrayList<Contrato> listaJugadores = new ArrayList<>();
        String comandoSql = "SELECT * FROM contrato,jugador,patrocinador WHERE "
                + "contrato.id_jugador=jugador.idJugador and "
                + "contrato.id_patrocinador=patrocinador.idPatrocinador and jugador.idJugador = ?";
        Contrato contrato;
        Jugador jugador;
        Patrocinador patrocinador;
        
            try {
               PreparedStatement ps = conexion.prepareStatement(comandoSql);

               ps.setInt(1, id);

               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   contrato = new Contrato();
                   jugador = buscarJugador(rs.getInt("idJugador"));
                   patrocinador = buscarPatrocinador(rs.getInt("idPatrocinador"));
                   contrato.setJugador(jugador);
                   contrato.setPatrocinador(patrocinador);
                   contrato.setInicioContrato(rs.getDate("inicio_contrato").toLocalDate());
                   contrato.setInicioContrato(rs.getDate("fin_contrato").toLocalDate());

                   listaJugadores.add(contrato);
               }
               
               ps.close();

           } catch (SQLException ex) {
               System.out.println("Error en buscar");
           }

        return listaJugadores;
    }
    
    public List<Contrato> obtenerContratoDeJugadoresActivos(int id){
        ArrayList<Contrato> listaJugadores = new ArrayList<>();
        String comandoSql = "SELECT * FROM contrato,jugador,patrocinador WHERE "
                + "contrato.id_jugador=jugador.idJugador and "
                + "contrato.id_patrocinador=patrocinador.idPatrocinador AND activo = true and jugador.idJugador = ?";
        Contrato contrato;
        Jugador jugador;
        Patrocinador patrocinador;
        
            try {
               PreparedStatement ps = conexion.prepareStatement(comandoSql);

               ps.setInt(1, id);

               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   contrato = new Contrato();
                   jugador = buscarJugador(rs.getInt("idJugador"));
                   patrocinador = buscarPatrocinador(rs.getInt("idPatrocinador"));
                   contrato.setJugador(jugador);
                   contrato.setPatrocinador(patrocinador);
                   contrato.setInicioContrato(rs.getDate("inicio_contrato").toLocalDate());
                   contrato.setInicioContrato(rs.getDate("fin_contrato").toLocalDate());

                   listaJugadores.add(contrato);
               }
               
               ps.close();

           } catch (SQLException ex) {
               System.out.println("Error en buscar");
           }

        return listaJugadores;
    }

    public Jugador buscarJugador(int id) {
        JugadorData jd = new JugadorData(conex);

        return jd.buscarJugador(id);
    }

    public Patrocinador buscarPatrocinador(int id) {
        PatrocinadorData pd = new PatrocinadorData(conex);

        return pd.buscarPatrocinador(id);
    }
}
