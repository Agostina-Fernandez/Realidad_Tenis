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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
        String comandoSql = "INSERT INTO encuentro (id_encuentro, id_torneo, id_jugador1, "
                + "id_jugador2, id_cancha, fecha, estado, "
                + "activo) VALUES (?,?,?,?,?,?,?,?)";
        
        PreparedStatement prepStat;
        System.out.println("guardar alumno: " + encuentro);
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setInt(1, encuentro.getIdEncuentro());
            prepStat.setInt(2, encuentro.getTorneo().getIdTorneo());
            prepStat.setInt(3, encuentro.getJugador1().getIdJugador());
            prepStat.setInt(4, encuentro.getJugador2().getIdJugador());
            prepStat.setInt(5, encuentro.getCancha().getIdCancha());
            prepStat.setDate(6, Date.valueOf(encuentro.getFecha()));
            prepStat.setString(7, encuentro.getEstado());
            prepStat.setBoolean(8, encuentro.isActivo());
            System.out.println("prepstat: " + prepStat);
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys();
            
            if (resultSet.next()){
                encuentro.setIdEncuentro(resultSet.getInt("id_encuentro"));
            }
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar encuentro" + ex);
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
            System.out.println("Error al desactivar");
        }
    }
    
    public void actualizarDatosEncuentro(Encuentro encuentro) {
        String comandoSql = "UPDATE encuentro " +
                "SET id_torneo=?, id_jugador1=?, id_jugador2=?, "
                + "id_cancha=?, fecha=?, estado=?, "
                + "activo=? WHERE id_encuentro=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, encuentro.getTorneo().getIdTorneo());
            prepStat.setInt(2, encuentro.getJugador1().getIdJugador());
            prepStat.setInt(3, encuentro.getJugador2().getIdJugador());
            prepStat.setInt(4, encuentro.getCancha().getIdCancha());
            prepStat.setDate(5, Date.valueOf(encuentro.getFecha()));
            prepStat.setString(6, encuentro.getEstado());
            prepStat.setBoolean(7, encuentro.isActivo());
            
            prepStat.setInt(8, encuentro.getIdEncuentro());
            
            System.out.println("prep: " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar datos de encuentro");
        }
    }
    
    public Encuentro buscarEncuentro(int id){
        String comandoSql = "SELECT * FROM encuentro WHERE id_encuentro=?";
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            TorneoData torneoData = new TorneoData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
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
                encuentro.setFecha(resultSet.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                encuentro.setHora(resultSet.getTime("hora").toLocalTime());
                encuentro.setEstado(resultSet.getString("estado"));
                encuentro.setActivo(resultSet.getBoolean("activo"));
                encuentro.setResultadoJ1(resultSet.getInt("resultado_j1"));
                encuentro.setResultadoJ2(resultSet.getInt("resultado_j2"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar");
        }
        
        return encuentro;
    }
    
    public List<Encuentro> obtenerEncuentros(){
        String comandoSql = "SELECT * FROM encuentro";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            Torneo torneo;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            TorneoData torneoData = new TorneoData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            
            while(resultSet.next()){
                encuentro = new Encuentro();
                
                jugador1 = jugadorData.buscarJugador(resultSet.getInt("id_jugador1"));
                jugador2 = jugadorData.buscarJugador(resultSet.getInt("id_jugador2"));
                ganador = jugadorData.buscarJugador(resultSet.getInt("id_ganador"));
                cancha = canchaData.buscarCancha(resultSet.getInt("id_cancha"));
                torneo = torneoData.buscarTorneo(resultSet.getInt("id_torneo"));
                
                encuentro.setIdEncuentro(resultSet.getInt("id_encuentro"));
                encuentro.setTorneo(torneo);
                encuentro.setJugador1(jugador1);
                encuentro.setJugador2(jugador2);
                encuentro.setGanador(ganador);
                encuentro.setCancha(cancha);
                encuentro.setFecha(resultSet.getDate("fecha").toLocalDate());
                encuentro.setEstado(resultSet.getString("estado"));
                encuentro.setActivo(resultSet.getBoolean("activo"));
                encuentro.setResultadoJ1(resultSet.getInt("resultado_j1"));
                encuentro.setResultadoJ2(resultSet.getInt("resultado_j2"));
                
                encuentros.add(encuentro);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar encuentros");
        }
        
        return encuentros;
    }
    
    public List<Encuentro> obtenerEncuentrosActivos(){
        String comandoSql = "SELECT * FROM encuentro WHERE activo=true";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
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
                encuentro.setFecha(resultSet.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
    
    public List<Encuentro> obtenerEncuentrosInactivos(){
        String comandoSql = "SELECT * FROM encuentro WHERE activo=false";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
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
                encuentro.setFecha(resultSet.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
    
    public void borrarEncuentro(int id){
        String comandoSql = "DELETE * FROM encuentro WHERE id_encuentro=?";
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Encuentro");
        }
    }
    
    public List<Encuentro> obtenerEncuentrosActivosJugador(Jugador jugador){
        String comandoSql = "SELECT * FROM encuentro WHERE activo=true AND (id_jugador1=? OR id_jugador2=?)";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            prepStat.setInt(1, jugador.getIdJugador());
            prepStat.setInt(2, jugador.getIdJugador());
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
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
                encuentro.setFecha(resultSet.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
    
    public List<Encuentro> obtenerEncuentrosJugador(Jugador jugador){
        String comandoSql = "SELECT * FROM encuentro WHERE id_jugador1=? OR id_jugador2=?";
        List<Encuentro> encuentros = new ArrayList<>();
        Encuentro encuentro = null;
        
        try {
            Jugador jugador1;
            Jugador jugador2;
            Jugador ganador;
            Cancha cancha;
            JugadorData jugadorData = new JugadorData(con);
            CanchaData canchaData = new CanchaData(con);
            
            
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            prepStat.setInt(1, jugador.getIdJugador());
            prepStat.setInt(2, jugador.getIdJugador());
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
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
                encuentro.setFecha(resultSet.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
