/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ParametrosDao;
import modeloParametros.Parametros;

/**
 *
 * @author Wolverine
 */
public class ParametrosFacade {
    
    ParametrosDao parametrosDao;
    
     public void salvar(Parametros parametros, int idEmpresa) throws Exception {
         parametrosDao = new ParametrosDao();
         parametrosDao.salvar(parametros,idEmpresa);
    }
    
    public Parametros localizar(int idEpmresa) throws Exception{
        parametrosDao = new ParametrosDao();
        return parametrosDao.localizar(idEpmresa);
    }
    
}
