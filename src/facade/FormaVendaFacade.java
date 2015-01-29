/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FormaVendaDao;
import java.sql.SQLException;
import java.util.List;
import model.Formavenda;
import model.Saida;

/**
 *
 * @author Wolverine
 */
public class FormaVendaFacade {
    
    private FormaVendaDao formaVendaDao;

    public void gravarFormaVenda(Formavenda formaVenda) throws Exception{
        formaVendaDao = new FormaVendaDao();
        formaVendaDao.gravarFormaVenda(formaVenda);
    }
    
    public void excluirFormaVenda(Formavenda formaVenda) throws SQLException{
        formaVendaDao = new  FormaVendaDao();
        formaVendaDao.excluirFormaVenda(formaVenda);
    }
    
    public void excluirSaida(Saida saida) throws SQLException{
        formaVendaDao = new FormaVendaDao();
        formaVendaDao.excluirSaida(saida);
    }
    
    public List<Formavenda> consultarFormaVenda(int idVenda) throws SQLException{
        formaVendaDao= new FormaVendaDao();
        return formaVendaDao.consultarFormaVenda(idVenda);
    }

}
