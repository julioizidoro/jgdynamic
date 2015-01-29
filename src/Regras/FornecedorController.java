/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.FornecedorFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Fornecedor;

/**
 *
 * @author Wolverine
 */
public class FornecedorController {
    
    public List<Fornecedor> consultarFornecedor() throws SQLException{
        return null;
    }

    public Fornecedor consultarFornecedor(int idFornecedor){
        FornecedorFacade forneceodrFacade = new FornecedorFacade();
        try {
            return forneceodrFacade.consultarFornecedor(idFornecedor);
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Fornecedor " + ex);
            return null;
        }
    }

    
    
    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) throws SQLException{
         return null;
    }

    public Fornecedor consultarCNPJ(String cnpj){
        return null;
        
    }

    public Fornecedor salvarFronecedor(Fornecedor fornecedor) {
        FornecedorFacade fornecedorFacade = new FornecedorFacade();
        try {
            return fornecedorFacade.salvarFronecedor(fornecedor);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Fornecedor " + ex);
            return null;
        }
    }

    public void excluir(Fornecedor fornecedor) throws Exception{
         
    }

    public int getIdFornecedor() throws Exception {
        return 0;
    }
    
}
