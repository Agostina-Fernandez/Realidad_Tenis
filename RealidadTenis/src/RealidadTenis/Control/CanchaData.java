package RealidadTenis.Control;

import RealidadTenis.Modelo.*;
import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agostina
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
            prepStat.setInt(3, cancha.getAncho());
            prepStat.setInt(4, cancha.getLargo());
            prepStat.setString(5, cancha.getCategoria());
            prepStat.setInt(6, cancha.getCapacidad());
            prepStat.setInt(7, cancha.getNumeroCancha());
            prepStat.setBoolean(8, cancha.isEnUso());
            
            prepStat.executeUpdate();
            ResultSet resultSet = prepStat.getGeneratedKeys(); //recupero el Id
            
            if (resultSet.next()){
                cancha.setIdCancha(resultSet.getInt("id_cancha"));
            }
            
            prepStat.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
    }
}
