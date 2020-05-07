package pe.edu.pucp.congresoft.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;
import pe.edu.pucp.congresoft.mysql.CongresoMySQL;

public class Principal {
    public static void main(String[] args) throws ParseException{
        int i;
        ArrayList<Congreso> congresos = new ArrayList<>();
        
        CongresoDAO daoCongreso = new CongresoMySQL();
//        congresos = daoCongreso.listar();
//        for(Congreso c : congresos){
//            System.out.println(c.mostrarDatos());
//        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Congreso congreso = new Congreso("INTERACT 2021", sdf.parse("01-01-2021"), sdf.parse("05-01-2021"), "BOLIVIA", true);
        
        CongresoDAO daoCongreso2 = new CongresoMySQL();
        i = daoCongreso2.insertar(congreso);
        if (i == 1)
            System.out.println("Se ha registrado de manera exitosa");
        
        congresos = daoCongreso.listar();
        for(Congreso c : congresos){
            System.out.println(c.mostrarDatos());
        }
    }
}
