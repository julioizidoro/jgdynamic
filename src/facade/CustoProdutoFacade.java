/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CustoProdutoDao;
import java.sql.SQLException;
import model.CustoProduto;

/**
 *
 * @author wolverine
 */
public class CustoProdutoFacade {
    
    CustoProdutoDao custoProdutoDao;
    
    public void salvar(CustoProduto custoProduto) throws  Exception{
        custoProdutoDao = new CustoProdutoDao();
        custoProdutoDao.salvar(custoProduto);
    }
    
    public CustoProduto getCustoProduto(int idProduto, int idEmpresa) throws SQLException{
        custoProdutoDao = new CustoProdutoDao();
        return custoProdutoDao.getCustoProduto(idProduto, idEmpresa);
    }
    
}
