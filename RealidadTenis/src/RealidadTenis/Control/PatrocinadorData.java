/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Patrocinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class PatrocinadorData {
    private Connection conexion;
    
    public PatrocinadorData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión UsuarioData");
        }

    }
    
    public void guardarPatrocinador(Patrocinador patrocinador){
        String comandoSql = "INSERT INTO patrocinador (marca, articulo, activo) "
                + "VALUES (?,?,?)";
        
        PreparedStatement prepStat;
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setString(1, patrocinador.getMarca());
            prepStat.setString(2, patrocinador.getArticulo());
            prepStat.setBoolean(3, patrocinador.isActivo());
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar patrocinador");
        }
    }
    
    public Patrocinador buscarPatrocinador(int id){
        String comandoSql = "SELECT * FROM patrocinador WHERE id_patrocinador=?";
        Patrocinador patrocinador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                patrocinador = new Patrocinador();
                
                patrocinador.setIdPatrocinador(resultSet.getInt("id_patrocinador"));
                patrocinador.setMarca(resultSet.getString("marca"));
                patrocinador.setActivo(resultSet.getBoolean("activo"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugador");
        }
        
        return patrocinador;
    }
    
    public void activarPatrocinador(int id){
        String comandoSql = "UPDATE patrocinador activo=? WHERE id_patrocinador=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, true);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar patrocinador");
        }
    }
    
    public void desactivarPatrocinador(int id){
        String comandoSql = "UPDATE patrocinador activo=? WHERE id_patrocinador=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, false);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar patrocinador");
        }
    }
    
}
