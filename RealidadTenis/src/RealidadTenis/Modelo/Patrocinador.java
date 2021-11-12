package RealidadTenis.Modelo;

import java.util.Objects;

/**
 *
 * @author Agostina
 */
public class Patrocinador {
    private int idPatrocinador;
    private String Marca;
    private String articulo;
    private boolean activo;
    
    /* CONSTRUCTORES */
    
    public Patrocinador(){}

    public Patrocinador(String Marca, boolean activo) {
        this.Marca = Marca;
        this.activo = activo;
    }

    public Patrocinador(int idPatrocinador, String Marca, String articulo, boolean activo) {
        this.idPatrocinador = idPatrocinador;
        this.Marca = Marca;
        this.articulo = articulo;
        this.activo = activo;
    }
    
    /* SETTERS */

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    public void setArticulo(String articulo){
        this.articulo = articulo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /* GETTERS */

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public String getMarca() {
        return Marca;
    }
    
    public String getArticulo(){
        return articulo;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Patrocinador{" + "idPatrocinador=" + idPatrocinador + ", Marca=" + Marca + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.Marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patrocinador other = (Patrocinador) obj;
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        return true;
    }
}
