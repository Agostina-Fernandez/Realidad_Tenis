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
}
