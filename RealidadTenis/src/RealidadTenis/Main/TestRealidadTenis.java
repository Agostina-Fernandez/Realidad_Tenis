package RealidadTenis.Main;

import RealidadTenis.Modelo.*;
import RealidadTenis.Control.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRealidadTenis {
    
    public static void main(String[] args) {
        
        try {
            Conexion conexion = new Conexion("jdbc:mysql://localhost/tenis", "root", "");
            
            Jugador jugador = new Jugador("adriel", "gomez", 33888429, "07/06/1989", 1.90, 92.2, "Ataque", true, true);
            
            JugadorData jugadorData = new JugadorData(conexion);
            
            jugadorData.guardarJugador(jugador);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestRealidadTenis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}