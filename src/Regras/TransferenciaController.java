/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;


import facade.TransferenciaFacade;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Tranfereciaproduto;
import model.Transferencia;

/**
 *
 * @author Wolverine
 */
public class TransferenciaController {
    
    public Transferencia salvarTransferencia(Transferencia transferencia){
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            return transferenciaFacade.salvarTransferencia(transferencia);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro salvar Transferencia " + ex);
            return null;
        }
    }
    
    public Tranfereciaproduto salvarTransferenciaProduto(Tranfereciaproduto transferenciaProduto){
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            return transferenciaFacade.salvarTransferenciaProduto(transferenciaProduto);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro salvar Produto na Transferencia " + ex);
            return null;
        }
    }
    
    public void excluirTransferencia(Transferencia transferencia){
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            transferenciaFacade.excluirTransferencia(transferencia);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro excluir Transferencia " + ex);
        }
    }
    
    public void excluirTransferenciaProduto(Tranfereciaproduto transferenciaProduto){
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            transferenciaFacade.excluirTransferenciaProduto(transferenciaProduto);
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro excluir Produto na Transferencia " + ex);
        }
    }
    
    public List<Transferencia> listarTransferencia(){
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            try {
                Date data = Formatacao.ConvercaoStringData("01/09/2014");
                return transferenciaFacade.listaTransferencia(Formatacao.ConvercaoDataSql(data));
                //return transferenciaFacade.listaTransferencia(Formatacao.SubtarirDatas(new Date(), 90, "yyyy-MM-dd"));
            } catch (Exception ex) {
                Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " Erro Listar Transferencia " + ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Listar Transferencia " + ex);
        }
        return null;
    }
    
    public List<Tranfereciaproduto> listaTransferenciaProduto(int idTransferencia) {
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade();
        try {
            return transferenciaFacade.listaTransferenciaProduto(idTransferencia);
        } catch (SQLException ex) {
            Logger.getLogger(TransferenciaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar produtos Transferncia " + ex);
            return null;
        }
    }
    
}
