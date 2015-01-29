/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.CustoProdutoFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CustoProduto;

/**
 *
 * @author wolverine
 */
public class CustoProdutoController {
    
    CustoProdutoFacade custoProdutoFacade;
    
    public void salvar(CustoProduto custoProduto) {
        custoProdutoFacade = new CustoProdutoFacade();
        try {
            custoProdutoFacade.salvar(custoProduto);
        } catch (Exception ex) {
            Logger.getLogger(CustoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Custo Produto " + ex);
        }
    }
    
    public CustoProduto getCustoProduto(int idProduto, int idEmpresa) {
        custoProdutoFacade = new CustoProdutoFacade();
        try {
            return custoProdutoFacade.getCustoProduto(idProduto, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(CustoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Custo Produto " + ex);
            return null;
        }
    }
    
}
