/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.RetiradaDao;
import java.sql.SQLException;
import java.util.List;
import model.Fechacaixa;
import model.Retirada;

/**
 *
 * @author Wolverine
 */
public class RetiradaFacade {
    
    RetiradaDao retiradaDao;
    
    public void salvar(Retirada retirada) throws Exception{
        retiradaDao = new RetiradaDao();
        retiradaDao.salvar(retirada);
    }
    
    public void excluir(Retirada retirada) throws Exception{
        retiradaDao = new RetiradaDao();
        retiradaDao.excluir(retirada);
    }
    
    public List<Retirada> listarRetiradas(Fechacaixa fechaCaixa) throws SQLException{
        retiradaDao = new RetiradaDao();
        return retiradaDao.listarRetiradas(fechaCaixa);
    }
    
    
}
