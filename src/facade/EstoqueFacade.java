/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.EstoqueDao;
import java.sql.SQLException;
import java.util.List;
import model.Estoque;
import view.Viewconsultaprodutoestoque;

/**
 *
 * @author Woverine
 */
public class EstoqueFacade {

    private EstoqueDao estoqueDao;

    public Estoque salvarEstoque(Estoque estoque) throws  Exception{
        estoqueDao = new EstoqueDao();
        return estoqueDao.salvarEstoque(estoque);
    }
    
    public Estoque getEstoque(Estoque estoque) throws  Exception{
        estoqueDao = new EstoqueDao();
        return estoqueDao.getEstoque(estoque);
    }

    public Estoque getEstoque(int idEmpresa) throws Exception{
        estoqueDao = new EstoqueDao();
        return estoqueDao.getEstoque(estoqueDao.getIdEstoque(), idEmpresa);
    }
    
    public List<Estoque> listarEstoque(int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return  estoqueDao.listarEstoque(idEmpresa);
    }
    
    public Estoque getEstoqueProduto(int idProduto, int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.getEstoqueProduto(idProduto, idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEntradaProduto(int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueZero(idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueGeral(int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueGeral(idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueCodigoBarras(String codigoBarras, int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueCodigoBarras(codigoBarras, idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueReferencia(int referencia, int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueReferencia(referencia, idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueDescricao(String descricao, int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueDescricao(descricao, idEmpresa);
    }
    
    public List<Estoque> consultaEstoqueProduto(int idProduto, int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.consultaEstoqueProduto(idProduto, idEmpresa);
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueZero(int idEmpresa) throws SQLException{
        estoqueDao = new EstoqueDao();
        return estoqueDao.listarEstoqueZero(idEmpresa);
    }
}
