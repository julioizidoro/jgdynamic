/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.VinculoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Fornecedor;
import model.Produto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class VinculoController {
    
    public Vinculo consultarVinculo(int produto, int empresa, int fornecedor){
        Vinculo vinculo = new Vinculo();
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            vinculo = vinculoFacade.consultarVinculo(produto, empresa, fornecedor);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Vinculo");
            vinculo = null;
        }
        return vinculo;
    }
    
    public Vinculo salvarVinculo(Vinculo vinculo){
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            return vinculoFacade.salvaVinculo(vinculo);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Vinculo");
            return null;
        }
    }
    
    public List<Vinculo> consultaVinculo(int fornecedor, int empresa){
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            return vinculoFacade.consultaVinculo(fornecedor, empresa);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vinculos" + ex);
            return null;
        }
    }
    
    public List<Vinculo> consultarVinculo(int idProduto, int idEmpresa) {
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            return vinculoFacade.consultarVinculo(idProduto, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vinculo " + ex);
            return null;
        }
    }
    public List<Vinculo> consultarVinculoPedido(int idProduto, int idEmpresa, int idfornecedor) {
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            return vinculoFacade.consultarVinculoPedido(idProduto, idEmpresa, idfornecedor);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vinculo para Pedido " + ex);
            return null;
        }
    }
    
    public Vinculo getVinculo(int idVinculo){
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            return vinculoFacade.getVinculo(idVinculo);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Vinculo " + ex);
            return null;
        }
    }
    
    public void excluirVinculo(int idVinculo){
        VinculoFacade vinculoFacade = new VinculoFacade();
        try {
            vinculoFacade.excluirVinculo(idVinculo);
        } catch (SQLException ex) {
            Logger.getLogger(VinculoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Vinculo " + ex);
        }
    }
    
    
}
