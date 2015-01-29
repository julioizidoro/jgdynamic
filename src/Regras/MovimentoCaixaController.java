/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.MovimentoCaixaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Movimentocaixa;

/**
 *
 * @author Wolverine
 */
public class MovimentoCaixaController {
    
    MovimentoCaixaFacade movimentoCaixaFacade;
    
    public Movimentocaixa consultarMovimentoCaixa(int idMovimentoCaixa)  {
       movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.consultarMovimentoCaixa(idMovimentoCaixa);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }

    public Movimentocaixa salvarCaixa(Movimentocaixa caixa)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.salvarCaixa(caixa);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Movimento de Caixa " + ex);
            return null;
        }
    }
    
    public void excluirCaixa(Movimentocaixa caixa)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            movimentoCaixaFacade.excluirCaixa(caixa);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir movimento de Caixa "  + ex);
        }
    }


    public List<Movimentocaixa> conusltarMovimentoCaixas(String descricao, String data) {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.conusltarMovimentoCaixas(descricao, data);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " +ex);
            return null;
        }
    }

    public List<Movimentocaixa> consutlarMovimentoCaixa(String data)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.consutlarMovimentoCaixa(data);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }

    public List<Movimentocaixa> MovimentoCaixa(String inicio, String fim, int planoContas)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.consultarMovimentoCaixa(inicio, fim, planoContas);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }

    public List<Double> calculaSaldos(String dataCaixa){
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.calculaSaldos(dataCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }
    
    public List<Double> calculaSaldosRelatorio(String dataInicial, String dataFinal)  {
        movimentoCaixaFacade= new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.calculaSaldosRelatorio(dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }

    public Movimentocaixa consultaMovimentoCaixa(String sql)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.consultaMovimentoCaixa(sql);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }

    public double getSaldoAnterior(String dataCaixa) {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.getSaldoAnterior(dataCaixa);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return 0;
        }
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal )  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.calculaSaldos(dataInicio, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }
    
    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim)  {
        movimentoCaixaFacade = new MovimentoCaixaFacade();
        try {
            return movimentoCaixaFacade.consultarMovimentoCaixa(inicio, fim);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Movimento de Caixa " + ex);
            return null;
        }
    }
    
}
