/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;


import facade.ContasReceberFacade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import model.View.Viewrelatoriocreditotodas;
import model.View.Viewrelcontasrecebertodas;

/**
 *
 * @author Wolverine
 */
public class ContasReceberController {
    
    ContasReceberFacade contasReceberFacade;
    
     // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceber(contasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Contas a Receber " + ex);
            return null;
        }
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirContasReceber(contasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Excluir Contas a Receber " + ex);
        }
    }
    
    public List<Contasreceber> listarContas(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarContas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Contas Receber " + ex);
            return null;
        }
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarFatura(faturaReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Fatura " + ex);
            return null;
        }
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirFatura(faturaReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Excluir Fatura " + ex);
        }
    }
    
       
    public List<Faturasreceber> listarFaturas(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarFaturas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Fatura " + ex);
            return null;
        }
    }
    
    
    // operacoes Parcela Fatura
    
    
    
    public Contasreceberprodutos consultarContasReceberProduto(int idContasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarContasReceberProduto(idContasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Produtos Contas a Receber " + ex);
            return null;
        }
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarContasReceberPagamento(idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro Consultar Pagamento Contas a Receber " + ex);
            return null;
        }
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarFormaPagamento(idContasReceberPagamento, forma);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consulta Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public List<Contasreceberpagamento> listarPagamento(String dataInicial, String dataFinal) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarPagamento(dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consulta Pagamento " + ex);
            return null;
        }
    }
    
    public List<Contasreceberforma> listarFormaPagamento(int idPagamento) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarFormaPagamento(idPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consulta Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public List<Contasreceber> listarFaturaReceberParcelas(int idFatura) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarFaturaReceberParcelas(idFatura);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Lsitar Parcelas da Fatura " + ex);
            return null;
        }
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa, int idEmpresa) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.valorFormaPagamento(idFormaPagamento, idFechaCaixa, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Contas Recebre Forma Pagamento " +ex);
            return 0.0f;
        }
    }
    
    public float calcularValorParcelaFaturaBancoDia(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.calcularValorParcelaFaturaBancoDia(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Calcular Valor Parcelas a Receber " + ex);
            return 0.0f;
        }
    }
    
    public ResultSet listarContasReceberFormaPagamento(String data, int idEmpresa) throws SQLException{
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarContasReceberFormaPagamento(data, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Contas Receber Forma de Pagamento "  + ex);
            return null;
        }
    }
    
    public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listaContasReceberProdutos(idContasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Contas Receber Produtos " + ex);
            return null;
        }
    }
    
    public void excluirContasReceberProduto(Contasreceberprodutos produto) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirContasReceberProduto(produto);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Contas Receber Produto " + ex);
        }
    }
    
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceberProduto(contasReceberProduto);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Contas Receber Produto " + ex);
            return null;
        }
    }
    
    public Contasreceberprodutos consultarContasReceberProdutoVenda(int idVenda) {
       contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarContasReceberProdutoVenda(idVenda);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Contas Receber Produto " + ex);
            return null;
        }
    }
    
    public Contasreceberpagamento consultarContaReceberPagamento(int idCotnasReceberPagamento) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarContaReceberPagamento(idCotnasReceberPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Contas Receber Pagamento " + ex);
            return null;
        }
    }
    
    public List<Viewrelcontasrecebertodas> listarContasReceberTodas(int idEmpresa) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarContasReceberTodas(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Contas Receber Todas " + ex);
            return null;
        }
    }
    
    public Viewrelatoriocreditotodas listarCreditosReceberTodas(int idCliente){
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarCreditosReceberTodas(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Creditos a Receber Todas " + ex);
            return null;
        }
    }
    
}
