/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.FormaPagamentoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Formapagamento;

/**
 *
 * @author Wolverine
 */
public class FormaPagamentoController {
    
    FormaPagamentoFacade formaPagamentoFacade;
    
    public List<Formapagamento> listarFormaPagamento(int idEmpresa) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.ListarFormaPagamento(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public Formapagamento getFormaPagamento(int idFormaPagamento) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamento(idFormaPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Forma de Pagamento " + ex);
            return null;
        }
    }
    
     public List<Formapagamento> getFormaPagamentoBandeiraCartao(int idBandeiraCartao) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamentoBandeiraCartao(idBandeiraCartao);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma Pagamento Bandeira Cartão "+ ex);
            return null;
        }
    }
    
    public Formapagamento salvarFormapagamento(Formapagamento formaPagamento)  {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.salvar(formaPagamento);
        } catch (Exception ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Forma Pagamento " + ex);
            return null;
        }
    }
    
    public List<Formapagamento> listarFormaPagamentoValor() {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.listarFormaPagamentoValor();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Eror Listar Forma Pagamento Valor " + ex);
            return null;
        }
    }
    
    public void excluir(Formapagamento formaPagamento) {
        FormaPagamentoFacade formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            formaPagamentoFacade.excluir(formaPagamento);
        } catch (Exception ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Forma Pagamento " + ex);
        }
    }
    
    public List<Formapagamento> getFormaPagamento() {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamento();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public List<Formapagamento> getFormaPagamentoCaratao() {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamentoCartao();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma de Pagamento Cartão " + ex);
            return null;
        }
    }
    
}
