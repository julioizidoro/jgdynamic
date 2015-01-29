/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TerminalVendasDao;
import java.sql.SQLException;
import java.util.List;
import model.Terminalcliente;
import model.Terminalproduto;

/**
 *
 * @author Wolverine
 */
public class TerminalVendasFacade {
    
      TerminalVendasDao terminalVendasDao;

    public void salvarCliente(Terminalcliente terminal) throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        terminalVendasDao.salvarCliente(terminal);
    }

    public void salvarProduto(Terminalproduto produto) throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        terminalVendasDao.salvarProduto(produto);
    }

    public List<Terminalcliente> consultaTerminalCliente() throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        return terminalVendasDao.consultaTerminalCliente();
    }

    public List<Terminalproduto> consultaTerminalProduto(Terminalcliente terminalCliente) throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        return  terminalVendasDao.consultaTerminalProduto(terminalCliente);
    }

    public void excluirTerminalCliente(Terminalcliente terminalCliente) throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        terminalVendasDao.excluirTerminalCliente(terminalCliente);
    }

    public void excluirTerminalProduto(Terminalproduto terminalProduto) throws SQLException{
        terminalVendasDao = new TerminalVendasDao();
        terminalVendasDao.excluirTerminalProduto(terminalProduto);
    }
    
    public int ultimoTerminalClienteGravada() throws Exception {
       terminalVendasDao = new TerminalVendasDao();
       return terminalVendasDao.ultimoTerminalClienteGravada();
    }
    
    public Terminalcliente getTerminalCliente(int id) throws Exception{
         terminalVendasDao = new TerminalVendasDao();
         return terminalVendasDao.getTerminalCliente(id);
    }
    
}
