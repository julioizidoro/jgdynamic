/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.ForPedidoDao;
import java.sql.SQLException;
import java.util.List;
import model.Forpedido;
import model.Forpedproduto;
import model.Forproduto;

/**
 *
 * @author Wolverine
 */
public class ForPedidoFacade {

    private ForPedidoDao forPedidoDao;

    public Forpedido consultarForPedido(int idForPedido, int idEmpresa) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForPedido(idForPedido, idEmpresa);
    }
    
   

    public List<Forpedido> consultarForPedido(String sql) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForPedido(sql);
    }
    
    public Forpedido salvarForPedido(Forpedido forPedido) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.salvarForPedido(forPedido);
    }

    public void salvarForPedProduto(Forpedproduto forPedProduto) throws SQLException{
       forPedidoDao = new ForPedidoDao();
       forPedidoDao.salvarForPedProduto(forPedProduto);
    }

    public void excluirForPedProduto(Forpedproduto forPedProduto) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        forPedidoDao.excluirForPedProduto(forPedProduto);
    }
    
    public int getIdPedido() throws Exception {
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.getIdPedido();
    }
    
    public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForPedidoProduto(forPedido);
    }
    
    public void excluirForPedido(Forpedido forPedido) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        forPedidoDao.excluirForPedido(forPedido);
    }
    
    public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido, int tipo) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForPedidoProduto(forPedido, tipo);
    }
    
    public List<Forpedido> consultarForPedidoUltimo(int idFornecedor, int idEmpresa) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForPedidoUltimo(idFornecedor, idEmpresa);
    }
    
    public void salvarForProduto(Forproduto forProduto) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        forPedidoDao.salvarForProduto(forProduto);
    }
    
    public List<Forproduto> consultarForProduto() throws SQLException{
        forPedidoDao = new ForPedidoDao();
        return forPedidoDao.consultarForProduto();
    }
    
    public void excluirForProduto(int idForProduto) throws SQLException{
        forPedidoDao = new ForPedidoDao();
        forPedidoDao.excluirForProduto(idForProduto);
    }

}
