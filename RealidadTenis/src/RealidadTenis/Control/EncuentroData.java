/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Encuentro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Agostina
 */
public class EncuentroData {
    private Connection conexion;

    public EncuentroData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
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
            prepStat.setInt(2, encuentro.getGanador().getIdJugador());
            prepStat.setInt(5, encuentro.getCancha().getIdCancha());
            prepStat.setDate(6, Date.valueOf(encuentro.getFecha()));
            //prepStat.setTime(7, Time.valueOf(encuentro.getHora())); CONVERTIR HORA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            prepStat.setString(8, encuentro.getEstado());
            prepStat.setBoolean(9, encuentro.isActivo());
            prepStat.setInt(10, encuentro.getResultadoJ1());
            prepStat.setInt(10, encuentro.getResultadoJ2());
            
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
}
