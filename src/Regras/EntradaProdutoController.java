/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import dao.EntradaDao;
import facade.EntradaFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Docentrada;
import model.Entradaproduto;
import model.Nfentrada;
import model.View.Viewentradaproduto;

/**
 *
 * @author Wolverine
 */
public class EntradaProdutoController {
    
    
    //Operacoes DocEntrada
    public Docentrada salvarDocEntrada(Docentrada docEntrada){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.salvarEntradaDoc(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Documento de Entrada");
            return null;
        }
    }
    
    public void exluirDocEntrada(Docentrada docEntrada){
       EntradaFacade entradaFacade = new EntradaFacade();
        try {
            entradaFacade.excluirDocEntrada(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Documento de Entrada");
        } 
    }
    
    public Docentrada consultarDocEntrada(){
        Docentrada docEntrada = new Docentrada();
        EntradaFacade entradaFacade = new EntradaFacade();
        int idDocEntrada=0;
        try {
            idDocEntrada = entradaFacade.getIdEntrada();
        } catch (Exception ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar id Ultima Entrada");
        }
        try {
            docEntrada = entradaFacade.consultarEntrada(idDocEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro oa Consultar Ultima Entrada");
        }
        return docEntrada;
    }
    
    public Docentrada consultarDocEntrada(Docentrada docEntrada){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            docEntrada = entradaFacade.consultarEntrada(docEntrada.getIdDocEntrada());
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Docomento de Entrada");
        }
        return docEntrada;
    }
    
 
    
    public List<Docentrada> listarDocEntrada(int idEmpresa){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            try {
                return entradaFacade.pesquisarEntradaPeriodo(Formatacao.SomarDatas(new Date(), -30, "yyyy/MM/dd"), Formatacao.ConvercaoDataSql(new Date()), idEmpresa);
            } catch (Exception ex) {
                Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " Erro Listar Entrada");
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Listar Entradas");
            return null;
        }
    }
    
    public List<Docentrada> pesquisarEntradaPeriodo(String dataInicio, String dataFim, int idEmpresa) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return  entradaFacade.pesquisarEntradaPeriodo(dataInicio, dataFim, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Entradas " + ex);
            return null;
        }
    }
    
    public List<Docentrada> pesquisarEntradaPeriodoFornecedor(String dataInicio, String dataFim, int idFornecedor, int idEmpresa) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return  entradaFacade.pesquisarEntradaPeriodoFornecedor(dataInicio, dataFim, idFornecedor, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Entradas " + ex);
            return null;
        }
    }
    
    public List<Entradaproduto> listarEntradaProduto(Docentrada docEntrada) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.listarEntradaProduto(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Entrada Produto " + ex);
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //operacoes EntradaProduto
    
    public void excluirProdutoEntrada(Entradaproduto entradaProduto){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            entradaFacade.excluirEntradaProduto(entradaProduto);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir Entrada Produto");
        }
    }
    
    public void excluirProdutoEntrada(int idProdutoEntrada){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            entradaFacade.excluirEntradaProduto(idProdutoEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir Entrada Produto");
        }
    }
    
    public void salvarProdutoEntrada(Entradaproduto entradaProduto){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            entradaFacade.salvarEntradaProduto(entradaProduto);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Entrada Produto");
        }
    }
    
    public List<Entradaproduto> listarProdutoEntrada(Docentrada docEntrada){
        EntradaFacade entradaFacade = new EntradaFacade();
        List<Entradaproduto> listaEntradaProduto = new ArrayList<Entradaproduto>();
        try {
            listaEntradaProduto = entradaFacade.listarEntradaProduto(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar Lista de Produto Entrada");
        }
        return listaEntradaProduto;
    }
    
    
    
    //Operacoes com EntradaNF
    
    public void excluirEntradaNF(Nfentrada notaFiscal) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            entradaFacade.excluirNotaEntrada(notaFiscal);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro excluir Nota Fiscal de Entrada");
        }
    }

    public Nfentrada salvarEntradaNF(Nfentrada  notaFiscal){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.salvarEntradaNF(notaFiscal);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Salvar Nota Fiscal de Entrada");
            return null;
        }

    }
    
    public Nfentrada consultarNotaFiscalEntrada(int idDocEntrada) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.consultarNotaFiscalEntrada(idDocEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Nota Fiscal Entrada " + ex);
            return null;
        }
    }
    
    public List<Viewentradaproduto> viewListarEntradaProduto(Docentrada docEntrada) {
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.viewListarEntradaProduto(docEntrada);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Entrada Produto " + ex);
            return null;
        }
    }
    
    public Entradaproduto getEntradaProduto(int idEntradaProduto){
        EntradaFacade entradaFacade = new EntradaFacade();
        try {
            return entradaFacade.getEntradaProduto(idEntradaProduto);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Entrada Produto " + ex);
            return null;
        }
    }

}
