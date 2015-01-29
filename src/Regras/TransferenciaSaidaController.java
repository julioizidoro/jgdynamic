/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.TransferenciaSaidaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Saidatransferencia;
import model.Saidatransferenciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaSaidaController {
    
    TransferenciaSaidaFacade transferenciaSaidaFacade;
    
    public Saidatransferencia salvarTransferencia(Saidatransferencia transferencia) {
        transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            return transferenciaSaidaFacade.salvarTransferencia(transferencia);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Transferencia " + ex);
            return null;
        }
    }
    
    public Saidatransferenciaproduto salvarTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) {
        transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            return transferenciaSaidaFacade.salvarTransferenciaProduto(transferenciaProduto);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar produtos Transferencia Saida " + ex);
            return null;
        }
        
    }
    
    public void excluirTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) {
        transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            transferenciaSaidaFacade.excluirTransferenciaProduto(transferenciaProduto);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir produtos Transferencia Saida " + ex);
        }
    }
    
    public void excluirTransferencia(Saidatransferencia transferencia) {
         transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            transferenciaSaidaFacade.excluirTransferencia(transferencia);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Transferencia Saida " + ex);
        }
    }
    
    public List<Saidatransferencia> listaTransferencia(String dataInicio, String dataFinal){
        transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            return transferenciaSaidaFacade.listaTransferencia(dataInicio, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Lstar Transferencia " + ex);
            return null;
        }
    }
    
    public List<Saidatransferenciaproduto> listaTransferenciaProduto(int idTransferencia) {
        transferenciaSaidaFacade = new TransferenciaSaidaFacade();
        try {
            return transferenciaSaidaFacade.listaTransferenciaProduto(idTransferencia);
        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaSaidaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Litar produtos Transferencia Saida " + ex);
            return null;
        }
    }
    
}
