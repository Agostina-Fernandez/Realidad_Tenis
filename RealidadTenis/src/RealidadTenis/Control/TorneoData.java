/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Torneo;
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
public class TorneoData {
    private Connection conexion;

    public TorneoData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    public void guardarTorneo(Torneo torneo){
        String comandoSql = "INSERT INTO torneo (nombre_copa, fecha_inicio, "
                + "fecha_fin, activo) VALUES (?,?,?,?)";
        
        PreparedStatement prepStat;
        System.out.println("guardar alumno: " + torneo);
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setString(1, torneo.getNombreCopa());
            prepStat.setDate(2, Date.valueOf(torneo.getFechaInicio()));
            prepStat.setDate(3, Date.valueOf(torneo.getFechaFin()));
            prepStat.setBoolean(4, torneo.isActivo());
            
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys();
            
            if (resultSet.next()){
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
            }
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
    }
}
