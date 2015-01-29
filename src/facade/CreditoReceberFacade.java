/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CreditoReceberDao;
import java.sql.SQLException;
import java.util.List;
import model.Creditoreceberprodutos;
import model.Creditosreceber;

/**
 *
 * @author Wolverine
 */
public class CreditoReceberFacade {
    
    CreditoReceberDao creditoReceberDao;
    
    public Creditosreceber salvar(Creditosreceber creditoReceber) throws SQLException{
        creditoReceberDao = new CreditoReceberDao();
        return creditoReceberDao.salvar(creditoReceber);
    }
    
    public List<Creditosreceber> listarCreditos(String sql) throws SQLException{
        creditoReceberDao = new CreditoReceberDao();
        return creditoReceberDao.listarCreditos(sql);
    }
    
    public List<Creditoreceberprodutos> listaCreditoProdutos(int idCredito) throws SQLException{
        creditoReceberDao = new CreditoReceberDao();
        return creditoReceberDao.listaCreditoProdutos(idCredito);
    }
    
}
