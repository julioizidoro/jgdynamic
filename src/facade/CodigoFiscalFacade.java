/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CodigoFiscalDao;
import java.util.List;
import model.Codigofiscal;


/**
 *
 * @author wolverine
 */
public class CodigoFiscalFacade {
    
    CodigoFiscalDao codigoFiscalDao;
    
    public void salvar(Codigofiscal codigoFiscal) throws  Exception{
        codigoFiscalDao = new CodigoFiscalDao();
        codigoFiscalDao.salvar(codigoFiscal);
    }
    
    public List<Codigofiscal> listarCodigoFiscal(String tipo) throws Exception{
        codigoFiscalDao = new CodigoFiscalDao();
        return codigoFiscalDao.listarCodigoFiscal(tipo);
    }
    
}
