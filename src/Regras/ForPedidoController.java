/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ForPedidoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Forpedido;
import model.Forpedproduto;
import model.Forproduto;

/**
 *
 * @author Wolverine
 */
public class ForPedidoController {
    
    public Forpedido consultarForPedido(int idForPedido, int idEmpresa) {
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            return forPedidoFacade.consultarForPedido(idForPedido, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, " Erro consultar pedido "  + ex);
            return null;
        }
    }

    public List<Forpedido> consultarForPedido()  {
        return null;
    }
    
    public void salvarForPedido(Forpedido forPedido)  {
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            forPedidoFacade.salvarForPedido(forPedido);
         
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Pedido do fornecedor " + ex);
        }
     
    }

    public void salvarForPedProduto(Forpedproduto forPedProduto) {
     
    }

    public void excluirForPedProduto(Forpedproduto forPedProduto) {
        ForPedidoFacade  forPedidoFacade = new ForPedidoFacade();
        try {
            forPedidoFacade.excluirForPedProduto(forPedProduto);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Produto do Pedido");
        }
     
    }
    
    public int getIdPedido() {
        return 0;
    }
    
    public List<Forpedproduto> consultarForPedidoProduto(Forpedido forPedido) {
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            return forPedidoFacade.consultarForPedidoProduto(forPedido);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Lista de Produto Pedido "  + ex);
            return null;
        }
    }
    
    public void excluirForPedido(Forpedido forPedido) {
     
    }
    
    public List<Forpedido> consultarForPedidoUltimo(int idFornecedor, int idEmpresa) {
        ForPedidoFacade forPedidoFacade = new ForPedidoFacade();
        try {
            return forPedidoFacade.consultarForPedidoUltimo(idFornecedor, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ForPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consular Pedido "  + ex);
            return null;
        }           
    }
    
    public void salvarForProduto(Forproduto forProduto){
     
    }
    
    public List<Forproduto> consultarForProduto() {
      return null;
    }
    
    public void excluirForProduto(int idForProduto) {
     
    }
    
}
