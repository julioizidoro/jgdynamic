/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.VinculoDao;
import java.sql.SQLException;
import java.util.List;
import model.Empresa;
import model.Fornecedor;
import model.Produto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class VinculoFacade {

    VinculoDao vinculoDao;

    public Vinculo salvaVinculo(Vinculo vinculo) throws SQLException{
       vinculoDao = new VinculoDao();
       return vinculoDao.salvaVinculo(vinculo);
   }

    public List<Vinculo> consultarVinculo(int idProduto, int idEmpresa) throws SQLException{
       vinculoDao= new VinculoDao();
       return vinculoDao.consultarVinculo(idProduto, idEmpresa);
    }
    
    public Vinculo consultarVinculo(int produto, int empresa, int fornecedor) throws SQLException{
        vinculoDao = new VinculoDao();
        return vinculoDao.consultarVinculo(produto, empresa, fornecedor);
    }
    
    public List<Vinculo> consultarVinculoFornecedorProduto(int idProduto, int idEmpresa, int idfornecedor) throws SQLException{
        vinculoDao = new VinculoDao();
        return vinculoDao.consultarVinculoFornecedorProduto(idProduto, idEmpresa, idfornecedor);
    }
    
    public List<Vinculo> consultaVinculo(int fornecedor, int empresa) throws SQLException{
        vinculoDao = new VinculoDao();
        return vinculoDao.consultaVinculo(fornecedor, empresa);
    }
    
    public List<Vinculo> consultarVinculoPedido(int idProduto, int idEmpresa, int idfornecedor) throws SQLException {
        vinculoDao = new VinculoDao();
        return vinculoDao.consultarVinculoPedido(idProduto, idEmpresa, idfornecedor);
    }
    
    public Vinculo getVinculo(int idVinculo) throws SQLException{
        vinculoDao = new VinculoDao();
        return vinculoDao.getVinculo(idVinculo);
    }
    
    public void excluirVinculo(int idVinculo) throws SQLException{
        vinculoDao = new VinculoDao();
        vinculoDao.excluirVinculo(idVinculo);
    }

}
