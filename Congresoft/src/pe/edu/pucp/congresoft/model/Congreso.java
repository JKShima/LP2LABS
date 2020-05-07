// Autor: Jose Kenshin Shimabukuro Chia
package pe.edu.pucp.congresoft.model;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Congreso {
    private int idCongreso;
    private String nombre;
    private Date fechaIni;
    private Date fechaFin;
    private String pais;
    private boolean activo;
    
    public Congreso(){

    }
    
    public Congreso(String nombre, Date fechaIni, Date fechaFin, String pais, boolean activo){
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pais = pais;
        this.activo = activo;
    }
    
    public int getIdCongreso() {
        return idCongreso;
    }

    public void setIdCongreso(int idCongreso) {
        this.idCongreso = idCongreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String mostrarDatos(){
        return idCongreso + " - " + nombre + " - " + fechaIni + " - " + fechaFin + " - " + pais;
    }
}
