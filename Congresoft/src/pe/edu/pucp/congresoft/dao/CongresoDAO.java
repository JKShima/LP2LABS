package pe.edu.pucp.congresoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.congresoft.model.Congreso;

public interface CongresoDAO {
    int insertar(Congreso congreso);
    ArrayList<Congreso> listar();
}
