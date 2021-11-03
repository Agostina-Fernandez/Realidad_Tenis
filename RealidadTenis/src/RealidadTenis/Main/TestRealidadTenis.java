
package RealidadTenis.Modelo;


public class TestRealidadTenis {

    public static void main(String[] args) {
        
        try {
            Conexion conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
            
            CanchaData CanchaDat = new CanchaData(conexion);
            /*
            Cancha cancha = new Cancha("San Luis", "General Paz 602", 15, 28, "Basquet", 12, 1, false);
            CanchaData.guardarCancha(cancha);
            
            
            */
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}