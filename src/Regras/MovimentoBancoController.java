/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.MovimentoBancoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Banco;
import model.Movimentobanco;

/**
 *
 * @author Wolverine
 */
public class MovimentoBancoController {
    
    MovimentoBancoFacade movimentoBancoFacade;
    
    public Movimentobanco consultarMovimentoBanco(int idMovimentoBanco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.consultarMovimentoBanco(idMovimentoBanco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro consultar movimento do banco "  + ex);
            return null;
        }
    }

    public Movimentobanco salvarBanco(Movimentobanco banco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.salvarBanco(banco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Salvar Movimento do Banco " + ex);
            return null;
        }
    }


    public List<Movimentobanco> conusltarMovimentoBanco(String descricao, Banco banco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.conusltarMovimentoBanco(descricao, banco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return null;
        }
    }

    public List<Movimentobanco> consutlarMovimentoBanco(String inicio, String fim, Banco banco)  {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.consutlarMovimentoBanco(inicio, fim, banco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return null;
        }
    }

    public List<Movimentobanco> MovimentoBanco(String inicio, String fim, int planoContas, Banco banco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.MovimentoBanco(inicio, fim, planoContas, banco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return null;
        }
        
    }

    public List<Double> calculaSaldos(String dataBanco, Banco banco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.calculaSaldos(dataBanco, banco);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return null;
        }
    }

    public Movimentobanco consultaMovimentoBanco(String sql)  {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.consultaMovimentoBanco(sql);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return null;
        }
    }

    public double getSaldoAnterior(String dataBanco, Banco banco)  {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.getSaldoAnterior(dataBanco, banco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Movimento do Banco " + ex);
            return 0.0;
        }
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal, Banco banco )  {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.calculaSaldos(dataInicio, dataFinal, banco);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Calcular Movimento do Banco " + ex);
            return null;
        }
    }
    
    public List<Movimentobanco> consultarMovimentoBancoDia(String data, int idBanco) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.consultarMovimentoBancoDia(data, idBanco);
        } catch (Exception ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Movimento Banco " + ex);
            return null;
        }
    }
    
    public float calcularValorChequesBancoDia(String sql) {
        movimentoBancoFacade = new MovimentoBancoFacade();
        try {
            return movimentoBancoFacade.calcularValorChequesBancoDia(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Calccular Valor Cheques Emitidos " + ex);
            return 0.0f;
        }
    }
}
