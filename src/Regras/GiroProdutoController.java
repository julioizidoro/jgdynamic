/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.GiroProdutoFacade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ViewConsultaProdutoFornecedor;


/**
 *
 * @author wolverine
 */
public class GiroProdutoController {
    
    GiroProdutoFacade giroProdutoFacade;
   
    
  
     public void criarTabelas(String sql) {
         giroProdutoFacade = new GiroProdutoFacade();
        try {
            giroProdutoFacade.criarTabelas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GiroProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void SalvarValores(String sql) {
         giroProdutoFacade = new GiroProdutoFacade();
        try {
            giroProdutoFacade.SalvarValores(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GiroProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public List<ViewConsultaProdutoFornecedor> listarProdutofornecedor(int idFornecedor) {
         giroProdutoFacade = new GiroProdutoFacade();
        try {
            return giroProdutoFacade.listarProdutofornecedor(idFornecedor);
        } catch (SQLException ex) {
            Logger.getLogger(GiroProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
     
     public ResultSet listarGiro(String sql){
         giroProdutoFacade = new GiroProdutoFacade();
         return giroProdutoFacade.listarGiro(sql);
     }
}
