package RealidadTenis.Control;

import RealidadTenis.Modelo.*;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *playstation 
 * @author Agostinanintendo and Mauri
 */
public class CanchaData {
    private Connection conexion;

    public CanchaData(Conexion con) {
        try {
            this.conexion = con.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error de conexión");
        }
    }
    
    public void guardarCancha(Cancha cancha){
        String comandoSql = "INSERT INTO cancha (ciudad, direccion, ancho, largo, categoria, capacidad, numero_cancha, enUso) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        PreparedStatement prepStat;
        try {
            prepStat = conexion.prepareStatement(comandoSql, Statement.RETURN_GENERATED_KEYS);
            
            prepStat.setString(1, cancha.getCiudad());
            prepStat.setString(2, cancha.getDireccion());
            prepStat.setFloat(3, cancha.getAncho());
            prepStat.setFloat(4, cancha.getLargo());
            prepStat.setString(5, cancha.getCategoria());
            prepStat.setInt(6, cancha.getCapacidad());
            prepStat.setInt(7, cancha.getNumeroCancha());
            prepStat.setBoolean(8, cancha.isEnUso());
            
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys(); //recupero el Id
            
            /*if (resultSet.next()){
                cancha.setIdCancha(resultSet.getInt("id_cancha"));
            }*/
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar cancha");
        }
    }
    public void canchaEnUso(int id){
        String comandoSql = "UPDATE cancha enUso=? WHERE id_cancha=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, true);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar cancha");
        }
    }
    
    public void canchaLibre(int id){
        String comandoSql = "UPDATE cancha enUso=? WHERE id_cancha=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setBoolean(1, false);
            
            prepStat.setInt(2, id);
            
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar cancha");
        }
    }
    
    public void actualizarCancha(Cancha cancha) {
        
        String comandoSql = "UPDATE cancha " +
                "SET ciudad=?,direccion=?,ancho=?,largo=?, categoria=?, capacidad=?, numero_cancha=?, enUso=? WHERE id_cancha=?";
        PreparedStatement prepStat;
        
        try {
            prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setString(1, cancha.getCiudad());
            prepStat.setString(2, cancha.getDireccion());
            prepStat.setFloat(3, cancha.getAncho());
            prepStat.setFloat(4, cancha.getLargo());
            prepStat.setString(5, cancha.getCategoria());
            prepStat.setInt(6, cancha.getCapacidad());
            prepStat.setInt(7, cancha.getNumeroCancha());
            prepStat.setBoolean(8, cancha.isEnUso());
            
            System.out.println("prep act cancha: " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar cancha");
        }
    }
    
    public Cancha buscarCancha(int id){
        String comandoSql = "SELECT * FROM cancha WHERE id_cancha=?";
        Cancha cancha = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            ResultSet resultSet = prepStat.executeQuery();
            
            if (resultSet.next()){
                cancha = new Cancha();
                
                cancha.setIdCancha(resultSet.getInt("id_cancha"));
                cancha.setCiudad(resultSet.getString("ciudad"));
                cancha.setDireccion(resultSet.getString("direccion"));
                cancha.setAncho(resultSet.getInt("ancho"));
                cancha.setLargo(resultSet.getInt("largo"));
                cancha.setCategoria(resultSet.getString("categoria"));
                cancha.setCapacidad(resultSet.getInt("capacidad"));
                cancha.setNumeroCancha(resultSet.getInt("numero_cancha"));
                cancha.setEnUso(resultSet.getBoolean("enUso"));
                
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar cancha");
        }
        
        return cancha;
    }
    
    public List<Cancha> obtenerJugadores(){
        String comandoSql = "SELECT * FROM cancha";
        List<Cancha> canchas = new ArrayList<>();
        Cancha cancha = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                
                cancha = new Cancha();
                
                cancha.setIdCancha(resultSet.getInt("id_cancha"));
                cancha.setCiudad(resultSet.getString("ciudad"));
                cancha.setDireccion(resultSet.getString("direccion"));
                cancha.setAncho(resultSet.getInt("ancho"));
                cancha.setLargo(resultSet.getInt("largo"));
                cancha.setCategoria(resultSet.getString("categoria"));
                cancha.setCapacidad(resultSet.getInt("capacidad"));
                cancha.setNumeroCancha(resultSet.getInt("numero_cancha"));
                cancha.setEnUso(resultSet.getBoolean("enUso"));
                                
                canchas.add(cancha);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar canchas");
        }
        
        return canchas;
    }
    
    public List<Cancha> obtenerCanchasEnUso(){
        String comandoSql = "SELECT * FROM cancha WHERE enUso=true";
        List<Cancha> canchas = new ArrayList<>();
        Cancha cancha = null;
        
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            ResultSet resultSet = prepStat.executeQuery();
            
            while (resultSet.next()){
                
                cancha = new Cancha();
                
                cancha.setIdCancha(resultSet.getInt("id_cancha"));
                cancha.setCiudad(resultSet.getString("ciudad"));
                cancha.setDireccion(resultSet.getString("direccion"));
                cancha.setAncho(resultSet.getInt("ancho"));
                cancha.setLargo(resultSet.getInt("largo"));
                cancha.setCategoria(resultSet.getString("categoria"));
                cancha.setCapacidad(resultSet.getInt("capacidad"));
                cancha.setNumeroCancha(resultSet.getInt("numero_cancha"));
                cancha.setEnUso(resultSet.getBoolean("enUso"));
                                
                canchas.add(cancha);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar canchas en uso");
        }
        
        return canchas;
    }
    
    public void borrarCancha(int id){
        String comandoSql = "DELETE FROM cancha WHERE id_cancha=?";
        try {
            PreparedStatement prepStat = conexion.prepareStatement(comandoSql);
            
            prepStat.setInt(1, id);
            System.out.println("prep para borrar jugador " + prepStat);
            prepStat.executeUpdate();
            
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar cancha");
        }
    }
}
