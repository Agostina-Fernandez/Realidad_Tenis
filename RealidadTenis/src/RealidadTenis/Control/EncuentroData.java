/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Cancha;
import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Encuentro;
import RealidadTenis.Modelo.Jugador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 *
 * @author Agostina
 */
public class EncuentroData {
    private Connection conexion;
    private Conexion con;

    public EncuentroData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
            con = conexion;
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    public void guardarEncuentro(Encuentro encuentro){
        String comandoSql = "INSERT INTO encuentro (id_torneo, id_jugador1, "
                + "id_jugador2, id_ganador, id_cancha, fecha, hora, estado, "
                + "activo, resultado_j1, resultado;j2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement prepStat;
        System.out.println("guardar alumno: " + encuentro);
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setInt(1, encuentro.getTorneo().getIdTorneo());
            prepStat.setInt(2, encuentro.getJugador1().getIdJugador());
            prepStat.setInt(3, encuentro.getJugador2().getIdJugador());
            prepStat.setInt(4, encuentro.getGanador().getIdJugador());
            prepStat.setInt(5, encuentro.getCancha().getIdCancha());
            prepStat.setDate(6, Date.valueOf(encuentro.getFecha()));
            prepStat.setTime(7, Time.valueOf(encuentro.getHora()));
            prepStat.setString(8, encuentro.getEstado());
            prepStat.setBoolean(9, encuentro.isActivo());
            prepStat.setInt(10, encuentro.getResultadoJ1());
            prepStat.setInt(11, encuentro.getResultadoJ2());
            
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys();
            
            if (resultSet.next()){
                encuentro.setIdEncuentro(resultSet.getInt("id_encuentro"));
            }
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
    }
    
    public void activarEncuentro(int id){
        String comandoSql = "UPDATE encuentro activo=? WHERE id_encuentro=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, true);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar");
        }
    }
    
    public void desactivarEncuentro(int id){
        String comandoSql = "UPDATE encuentro activo=? WHERE id_encuentro=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, false);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar");
        }
    }
    
    public void actualizarEncuentro(Encuentro encuentro) {
        String comandoSql = "UPDATE encuentro " +
                "SET id_torneo=?, id_jugador1=?, id_jugador2=?, "
                + "id_ganador=?, id_cancha=?, fecha=?, hora=?, estado=?, "
                + "activo=?, resultado_j1=?, resultado_j2=? WHERE id_encuentro=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, encuentro.getTorneo().getIdTorneo());
            prepStat.setInt(2, encuentro.getJugador1().getIdJugador());
            prepStat.setInt(3, encuentro.getJugador2().getIdJugador());
            prepStat.setInt(4, encuentro.getGanador().getIdJugador());
            prepStat.setInt(5, encuentro.getCancha().getIdCancha());
            prepStat.setDate(6, Date.valueOf(encuentro.getFecha()));
            prepStat.setTime(7, Time.valueOf(encuentro.getHora()));
            prepStat.setBoolean(8, encuentro.isProgramado());
            prepStat.setBoolean(9, encuentro.isActivo());
            prepStat.setInt(10, encuentro.getResultadoJ1());
            prepStat.setInt(11, encuentro.getResultadoJ2());
            
            if(encuentro.isActivo()){
                prepStat.setInt(5, 1);
            }else{
                prepStat.setInt(5, 0);
            }
            prepStat.setInt(6, encuentro.getIdEncuentro());
            
            System.out.println("prep: " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar");
        }
    }
    
    public Encuentro buscarEncuentro(int id){
        String comandoSql = "SELECT * FROM encuentro WHERE id_encuentro=?";
        Encuentro encuentro = null;
        
        /*
        SET id_torneo=?, id_jugador1=?, id_jugador2=?, "
                + "id_ganador=?, id_cancha=?, fecha=?, hora=?, estado=?, "
                + "activo=?, resultado_j1=?, resultado_j2=? WHERE id_encuentro=?"
        */
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(); //CUANDO JUGADORDATA ESTE PUEDO SEGUIR
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                encuentro = new Encuentro();
                
                encuentro.setIdEncuentro(resultSet.getInt("id_encuentro"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return encuentro;
    }
}
