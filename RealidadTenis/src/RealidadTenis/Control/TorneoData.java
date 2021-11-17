/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealidadTenis.Control;

import RealidadTenis.Modelo.Cancha;
import RealidadTenis.Modelo.Conexion;
import RealidadTenis.Modelo.Encuentro;
import RealidadTenis.Modelo.Jugador;
import RealidadTenis.Modelo.Torneo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agostina
 */
public class TorneoData {
    private Connection conexion;
    private Conexion con;

    public TorneoData(Conexion conexion) {
        
        try {
            this.conexion = conexion.getConexion();
            con = conexion;
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    public void guardarTorneo(Torneo torneo){
        String comandoSql = "INSERT INTO torneo (nombre_copa, fecha_inicio, "
                + "fecha_fin, activo) VALUES (?,?,?,?)";
        
        PreparedStatement prepStat;
        System.out.println("guardar torneo: " + torneo);
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setString(1, torneo.getNombreCopa());
            prepStat.setDate(2, Date.valueOf(torneo.getFechaInicio()));
            prepStat.setDate(3, Date.valueOf(torneo.getFechaFin()));
            prepStat.setBoolean(4, torneo.isActivo());
            
            System.out.println(torneo.getIdTorneo());
            
            prepStat.executeUpdate();
            /*ResultSet resultSet = prepStat.getGeneratedKeys();
            
            if (resultSet.next()){
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
            }*/
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar torneo");
        }
    }
    
    public void activarTorneo(int id){
        String comandoSql = "UPDATE torneo activo=? WHERE id_torneo=?";
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
    
    public void desactivarTorneo(int id){
        String comandoSql = "UPDATE torneo activo=? WHERE id_torneo=?";
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
    
    public void actualizarTorneo(Torneo torneo) {
        String comandoSql = "UPDATE torneo " +
                "SET nombre_copa=?, fecha_inicio=?, fecha_fin=?, "
                + "activo=? WHERE id_torneo=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setString(1, torneo.getNombreCopa());
            prepStat.setDate(2, Date.valueOf(torneo.getFechaInicio()));
            prepStat.setDate(3, Date.valueOf(torneo.getFechaFin()));
            prepStat.setBoolean(4, torneo.isActivo());
            
            if(torneo.isActivo()){
                prepStat.setInt(4, 1);
            }else{
                prepStat.setInt(4, 0);
            }
            prepStat.setInt(5, torneo.getIdTorneo());
            
            System.out.println("prep: " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar");
        }
    }
    
    public Torneo buscarTorneo(int id){
        String comandoSql = "SELECT * FROM torneo WHERE id_torneo=?";
        Torneo torneo = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                torneo = new Torneo();
                
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
                torneo.setNombreCopa(resultSet.getString("nombre_copa"));
                torneo.setFechaInicio(resultSet.getDate("fecha_inicio").toLocalDate());
                torneo.setFechaFin(resultSet.getDate("fecha_fin").toLocalDate());
                torneo.setActivo(resultSet.getBoolean("activo"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar un torneo");
        }
        
        return torneo;
    }
    
    public ArrayList<Torneo> obtenerTorneos(){
        String comandoSql = "SELECT * FROM torneo";
        ArrayList<Torneo> torneos = new ArrayList<>();
        Torneo torneo = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                torneo = new Torneo();
                
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
                torneo.setNombreCopa(resultSet.getString("nombre_copa"));
                torneo.setFechaInicio(resultSet.getDate("fecha_inicio").toLocalDate());
                torneo.setFechaFin(resultSet.getDate("fecha_fin").toLocalDate());
                torneo.setActivo(resultSet.getBoolean("activo"));
                
                System.out.println("torneo encontrado: " + torneo);
                torneos.add(torneo);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return torneos;
    }
    
    public List<Torneo> obtenerTorneosActivos(){
        String comandoSql = "SELECT * FROM torneo WHERE activo=true";
        List<Torneo> torneos = new ArrayList<>();
        Torneo torneo = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                torneo = new Torneo();
                
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
                torneo.setNombreCopa(resultSet.getString("nombre_copa"));
                torneo.setFechaInicio(resultSet.getDate("fecha_inicio").toLocalDate());
                torneo.setFechaFin(resultSet.getDate("fecha_fin").toLocalDate());
                torneo.setActivo(resultSet.getBoolean("activo"));
                
                torneos.add(torneo);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return torneos;
    }
    
    public List<Torneo> obtenerTorneosInactivos(){
        String comandoSql = "SELECT * FROM torneo WHERE activo=false";
        List<Torneo> torneos = new ArrayList<>();
        Torneo torneo = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                torneo = new Torneo();
                
                torneo.setIdTorneo(resultSet.getInt("id_torneo"));
                torneo.setNombreCopa(resultSet.getString("nombre_copa"));
                torneo.setFechaInicio(resultSet.getDate("fecha_inicio").toLocalDate());
                torneo.setFechaFin(resultSet.getDate("fecha_fin").toLocalDate());
                torneo.setActivo(resultSet.getBoolean("activo"));
                
                torneos.add(torneo);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return torneos;
    }
    
    public void borrarTorneo(int id){
        String comandoSql = "DELETE * FROM torneo WHERE id_torneo=?";
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Torneo");
        }
    }
    
    public List<Jugador> obtenerRanking(Torneo torneo){
                
        String comandoSql = "SELECT *, SUM(e.id_ganador = j.id_jugador AND e.id_torneo = ?)*3 AS puntos "
                + "FROM jugador j, encuentro e "
                + "WHERE e.id_ganador = j.id_jugador AND e.id_torneo = ? GROUP BY j.id_jugador "
                + "ORDER BY puntos DESC"; 
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            prepStat.setInt(1, torneo.getIdTorneo());
            prepStat.setInt(2, torneo.getIdTorneo());
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
                jugador.setPuntos(resultSet.getInt("puntos"));
                
                jugadores.add(jugador);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return jugadores;
    }
    
    public List<Jugador> obtenerJugadoresPorTorneo(Torneo torneo){
        
        String comandoSql = "SELECT *, SUM(e.id_ganador = j.id_jugador AND e.id_torneo = ?)*3 AS puntos "
                + "FROM jugador j, encuentro e "
                + "WHERE e.id_ganador = j.id_jugador AND e.id_torneo=? GROUP BY j.id_jugador";
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            prepStat.setInt(1, torneo.getIdTorneo());
            prepStat.setInt(2, torneo.getIdTorneo());
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
                jugador.setPuntos(resultSet.getInt("puntos"));
                
                jugadores.add(jugador);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return jugadores;
    }
    
    public List<Encuentro> obtenerEncuentrosTorneo(){
        String comandoSql = "SELECT id_encuentro FROM torneo, encuentro WHERE torneo.id_encuentro = encuentro.id_encuentro";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        Jugador jugador1;
        Jugador jugador2;
        Jugador ganador;
        Cancha cancha;
        JugadorData jugadorData;
        CanchaData canchaData;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            jugadorData = new JugadorData(con);
            canchaData = new CanchaData(con);
            
            if (resultSet.next()){
                encuentro = new Encuentro();
                
                jugador1 = jugadorData.buscarJugador(resultSet.getInt("id_jugador1"));
                jugador2 = jugadorData.buscarJugador(resultSet.getInt("id_jugador2"));
                ganador = jugadorData.buscarJugador(resultSet.getInt("id_ganador"));
                cancha = canchaData.buscarCancha(resultSet.getInt("id_cancha"));
                
                encuentro.setIdEncuentro(resultSet.getInt("id_encuentro"));
                encuentro.setJugador1(jugador1);
                encuentro.setJugador2(jugador2);
                encuentro.setGanador(ganador);
                encuentro.setCancha(cancha);
                encuentro.setFecha(resultSet.getDate("fecha").toLocalDate());
                encuentro.setHora(resultSet.getTime("hora").toLocalTime());
                encuentro.setEstado(resultSet.getString("estado"));
                encuentro.setActivo(resultSet.getBoolean("activo"));
                encuentro.setResultadoJ1(resultSet.getInt("resultado_j1"));
                encuentro.setResultadoJ2(resultSet.getInt("resultado_j2"));
                
                encuentros.add(encuentro);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return encuentros;
    }
}
