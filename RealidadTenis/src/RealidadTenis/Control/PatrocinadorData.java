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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
            System.out.println("Error en la conexión PatrocinadorData");
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
                patrocinador.setArticulo(resultSet.getString("articulo"));
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
    
    public boolean patrocinadorExiste(int id){
        boolean ret = false;
        String sql = "SELECT * FROM `patrocinador` WHERE `id_patrocinador`=?";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret = true;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar el patrocinador en la base de datos");
        }
        return ret;
    }
    
    public void modificarEstado(int id){
        String sql = "UPDATE patrocinador SET activo=? WHERE id_patrocinador=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Patrocinador p = this.buscarPatrocinador(id);
            ps.setBoolean(1,!p.isActivo());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar el estado de la materia en la base de datos.");
        }
    }
    
    public void actualizarPatrocinador(Patrocinador patrocinador){
        String comandoSql = "UPDATE patrocinador "
                + "SET marca=?, articulo=?, activo=? WHERE id_patrocinador=?";
        
        PreparedStatement prepStat;
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setString(1, patrocinador.getMarca());
            prepStat.setString(2, patrocinador.getArticulo());
            prepStat.setBoolean(3, patrocinador.isActivo());
            
            prepStat.setInt(4, patrocinador.getIdPatrocinador());
            
            prepStat.executeUpdate();
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar");
        }
    }
    
    public List<Patrocinador> obtenerPatrocinadores(){
        Patrocinador patrocinador;
        String comandoSql = "SELECT * FROM patrocinador";
        List<Patrocinador> patrocinadores = new ArrayList<>();
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                patrocinador = new Patrocinador();
                
                patrocinador.setIdPatrocinador(resultSet.getInt("id_patrocinador"));
                patrocinador.setMarca(resultSet.getString("marca"));
                patrocinador.setActivo(resultSet.getBoolean("activo"));
                
                patrocinadores.add(patrocinador);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugador");
        }
        
        return patrocinadores;
    }
    
    public List<Patrocinador> obtenerPatrocinadoresActivos(){
        Patrocinador patrocinador;
        String comandoSql = "SELECT * FROM patrocinador WHERE activo=true";
        List<Patrocinador> patrocinadores = new ArrayList<>();
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                patrocinador = new Patrocinador();
                
                patrocinador.setIdPatrocinador(resultSet.getInt("id_patrocinador"));
                patrocinador.setMarca(resultSet.getString("marca"));
                patrocinador.setActivo(resultSet.getBoolean("activo"));
                
                patrocinadores.add(patrocinador);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugador");
        }
        
        return patrocinadores;
    }
}
