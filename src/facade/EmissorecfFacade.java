/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EmissorecfDao;
import java.sql.SQLException;
import java.util.List;
import model.Emissorecf;

/**
 *
 * @author Julio
 */
public class EmissorecfFacade {
    
    EmissorecfDao emissorecfDao;
    
    public void salvar(Emissorecf emissorEcf) throws SQLException{
        emissorecfDao = new EmissorecfDao();
        emissorecfDao.salvar(emissorEcf);
    }
    
    public List<Emissorecf> listar(int idEmpresa) throws SQLException{
        emissorecfDao = new EmissorecfDao();
        return emissorecfDao.listar(idEmpresa);
    }
    
}
