/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.GiroProdutoDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.View.Viewconsultaprodutogrupo;
import view.ViewConsultaProdutoFornecedor;


/**
 *
 * @author wolverine
 */
public class GiroProdutoFacade {
    
    GiroProdutoDao giroProdutoDao;
     
     public void criarTabelas(String sql) throws SQLException{
         giroProdutoDao= new GiroProdutoDao();
         giroProdutoDao.criarTabelas(sql);
     }
     
     public void SalvarValores(String sql) throws SQLException{
         giroProdutoDao = new GiroProdutoDao();
         giroProdutoDao.SalvarValores(sql);
     }
     
     public List<ViewConsultaProdutoFornecedor> listarProdutofornecedor(int idFornecedor) throws SQLException{
         giroProdutoDao = new GiroProdutoDao();
         return giroProdutoDao.listarProdutofornecedor(idFornecedor);
     }
     
     public List<Viewconsultaprodutogrupo> listarProdutoGrupo(int idSubGrupo, int idEmpresa) throws SQLException{
         giroProdutoDao = new GiroProdutoDao();
         return giroProdutoDao.listarProdutoGrupo(idSubGrupo, idEmpresa);
     }
     
     public ResultSet listarGiro(String sql){
         giroProdutoDao = new GiroProdutoDao();
        try {
            return giroProdutoDao.listarGiro(sql);
        } catch (IOException ex) {
            Logger.getLogger(GiroProdutoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
