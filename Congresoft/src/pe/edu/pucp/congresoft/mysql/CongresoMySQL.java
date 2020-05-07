package pe.edu.pucp.congresoft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.config.DBManager;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;

public class CongresoMySQL implements CongresoDAO{

    @Override
    public int insertar(Congreso congreso) {
        int resultado = 0;
        try{
            boolean valor;
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.
                    getConnection(DBManager.url, DBManager.user, DBManager.password);
            
            String sql = "INSERT INTO CONGRESO(NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, congreso.getNombre());
            ps.setDate(2,new java.sql.Date(congreso.getFechaIni().getTime()));
            ps.setDate(3,new java.sql.Date(congreso.getFechaFin().getTime()));
            ps.setString(4, congreso.getPais());
            
            valor = congreso.getActivo();
            if(valor == true) ps.setInt(5, 1);
            else ps.setInt(5, 0);
            
            resultado = ps.executeUpdate();
            con.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Congreso> listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Congreso> congresos = new ArrayList<>();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.
                    getConnection(DBManager.url, DBManager.user, DBManager.password);
        
            String sentencia = "SELECT * FROM CONGRESO";
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sentencia);
            
            while(rs.next()){
                int valor;
                Congreso congreso = new Congreso();
                congreso.setIdCongreso(rs.getInt("ID_CONGRESO"));
                congreso.setNombre(rs.getString("NOMBRE"));
                congreso.setFechaIni(rs.getDate("FECHA_INICIO"));
                congreso.setFechaFin(rs.getDate("FECHA_FIN"));
                congreso.setPais(rs.getString("PAIS"));
                valor = rs.getInt("ACTIVO");
                if (valor == 1) congreso.setActivo(true);
                else congreso.setActivo(false);
                congresos.add(congreso);
            }
            con.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return congresos;
    }
    
    
}
