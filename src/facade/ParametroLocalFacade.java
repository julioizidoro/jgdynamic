/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ParametroLocalDao;
import java.sql.SQLException;
import model.ParametrosLocal;
import modeloParametros.Parametros;

/**
 *
 * @author Wolverine
 */
public class ParametroLocalFacade {
    
    ParametroLocalDao parametrosDao;
    
     public void salvar(ParametrosLocal parametros) throws Exception {
         parametrosDao = new ParametroLocalDao();
         parametrosDao.salvar(parametros);
    }
    
    public ParametrosLocal localizarParametro(int idParametro) throws Exception{
        parametrosDao = new ParametroLocalDao();
        return parametrosDao.localizarParametro(idParametro);
    }
    
    public ParametrosLocal localizarEmpresa(int idEmpresa) throws SQLException{
        parametrosDao = new ParametroLocalDao();
        return parametrosDao.localizarEmpresa(idEmpresa);
    }
    
}
