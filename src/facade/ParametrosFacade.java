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
    
     public void salvar(Parametros parametros) throws Exception {
         parametrosDao = new ParametrosDao();
         parametrosDao.salvar(parametros);
    }
    
    public Parametros localizar(int idParametro) throws Exception{
        parametrosDao = new ParametrosDao();
        return parametrosDao.localizar(idParametro);
    }
    
}
