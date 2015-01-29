/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CodigoBarrasDao;
import java.sql.SQLException;
import java.util.List;
import model.CodigoBarras;

/**
 *
 * @author wolverine
 */
public class CodigoBarrasFacade {
    
    CodigoBarrasDao codigoBarrasDao;
    
    public CodigoBarras salvar(CodigoBarras codigoBarras) throws SQLException{
        codigoBarrasDao = new CodigoBarrasDao();
        return codigoBarrasDao.salvar(codigoBarras);
    }
    
    public CodigoBarras pesquisarCodigo(String barras) throws SQLException{
        codigoBarrasDao = new CodigoBarrasDao();
        return codigoBarrasDao.pesquisarCodigo(barras);
    }
    
    public List<CodigoBarras> pesquisarProduto(int idProduto) throws SQLException{
        codigoBarrasDao = new CodigoBarrasDao();
        return codigoBarrasDao.pesquisarProduto(idProduto);
    }
    
    public void excluirCodigoBarras(CodigoBarras codigoBarras) throws SQLException{
        codigoBarrasDao = new CodigoBarrasDao();
        codigoBarrasDao.excluirCodigoBarras(codigoBarras);
    }
    
}
