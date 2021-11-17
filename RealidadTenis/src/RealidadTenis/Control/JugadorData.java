/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agostina
 */
public class JugadorData {
    private Connection conexion;
    
    public JugadorData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión UsuarioData");
        }

    }
    
    public void guardarJugador(Jugador jugador){
        String comandoSql = "INSERT INTO jugador (id_jugador, nombre, apellido, dni, fecha_nacimiento, altura, peso, estilo, diestro, activo) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setInt(1, jugador.getIdJugador());
            prepStat.setString(2, jugador.getNombre());
            prepStat.setString(3, jugador.getApellido());
            prepStat.setLong(4, jugador.getDni());
            prepStat.setDate(5, Date.valueOf(jugador.getFechaNacimiento()));
            prepStat.setDouble(6, jugador.getAltura());
            prepStat.setDouble(7, jugador.getPeso());
            prepStat.setString(8, jugador.getEstilo());
            prepStat.setBoolean(9, jugador.isDiestro());
            prepStat.setBoolean(10, jugador.isActivo());
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar" + ex);
        }
    }
    
    public void activarJugador(int id){
        String comandoSql = "UPDATE jugador activo=? WHERE id_jugador=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, true);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar jugador");
        }
    }
    
    public void desactivarJugador(int id){
        String comandoSql = "UPDATE jugador activo=? WHERE id_jugador=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, false);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al desactivar jugador");
        }
    }
    
    public void actualizarJugador(Jugador jugador) {
        
        String comandoSql = "UPDATE jugador " +
                "SET nombre=?,apellido=?,dni=?,fecha_nacimiento=?, altura=?, peso=?, estilo=?, diestro=?, activo=? WHERE id_jugador=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setString(1, jugador.getNombre());
            prepStat.setString(2, jugador.getApellido());
            prepStat.setLong(3, jugador.getDni());
            prepStat.setDate(4, Date.valueOf(jugador.getFechaNacimiento()));
            prepStat.setDouble(5, jugador.getAltura());
            prepStat.setDouble(6, jugador.getPeso());
            prepStat.setString(7, jugador.getEstilo());
            prepStat.setBoolean(8, jugador.isDiestro());
            prepStat.setBoolean(9, jugador.isActivo());
            
            prepStat.setInt(10, jugador.getIdJugador());
            
            System.out.println("prep act jugador: " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar jugador");
        }
    }
    
    public Jugador buscarJugador(int id){
        String comandoSql = "SELECT * FROM jugador WHERE id_jugador=?";
        Jugador jugador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                jugador = new Jugador();
                
                jugador.setIdJugador(resultSet.getInt("id_jugador"));
                jugador.setNombre(resultSet.getString("nombre"));
                jugador.setApellido(resultSet.getString("apellido"));
                jugador.setDni(resultSet.getLong("dni"));
                jugador.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
                jugador.setAltura(resultSet.getDouble("altura"));
                jugador.setPeso(resultSet.getDouble("peso"));
                jugador.setEstilo(resultSet.getString("estilo"));
                jugador.setDiestro(resultSet.getBoolean("diestro"));
                jugador.setActivo(resultSet.getBoolean("activo"));
                
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugador");
        }
        
        return jugador;
    }
    
    public List<Jugador> obtenerJugadores(){
        String comandoSql = "SELECT * FROM jugador";
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                
                jugador = new Jugador();
                
                jugador.setIdJugador(resultSet.getInt("id_jugador"));
                jugador.setNombre(resultSet.getString("nombre"));
                jugador.setApellido(resultSet.getString("apellido"));
                jugador.setDni(resultSet.getLong("dni"));
                jugador.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
                System.out.println("fecha de nac: " + Date.valueOf(resultSet.getDate("fecha_nacimiento").toLocalDate()).toString());
                jugador.setAltura(resultSet.getDouble("altura"));
                jugador.setPeso(resultSet.getDouble("peso"));
                jugador.setEstilo(resultSet.getString("estilo"));
                jugador.setDiestro(resultSet.getBoolean("diestro"));
                jugador.setActivo(resultSet.getBoolean("activo"));
                                
                jugadores.add(jugador);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugadores");
        }
        
        return jugadores;
    }
    
    public List<Jugador> obtenerUsuariosActivos(){
        String comandoSql = "SELECT * FROM jugador WHERE activo=true";
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                
                jugador = new Jugador();
                
                jugador.setIdJugador(resultSet.getInt("id_jugador"));
                jugador.setNombre(resultSet.getString("nombre"));
                jugador.setApellido(resultSet.getString("apellido"));
                jugador.setDni(resultSet.getLong("dni"));
                jugador.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
                System.out.println("fecha de nac: " + Date.valueOf(resultSet.getDate("fecha_nacimiento").toLocalDate()).toString());
                jugador.setAltura(resultSet.getDouble("altura"));
                jugador.setPeso(resultSet.getDouble("peso"));
                jugador.setEstilo(resultSet.getString("estilo"));
                jugador.setDiestro(resultSet.getBoolean("diestro"));
                jugador.setActivo(resultSet.getBoolean("activo"));
                                
                jugadores.add(jugador);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar jugadores activos");
        }
        
        return jugadores;
    }
    
    public void borrarJugador(int id){
        String comandoSql = "DELETE FROM jugador WHERE id_jugador=?";
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            System.out.println("prep para borrar jugador " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Jugador");
        }
    }
    
}
