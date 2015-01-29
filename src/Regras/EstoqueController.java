/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.EstoqueFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Estoque;
import view.Viewconsultaprodutoestoque;

/**
 *
 * @author Wolverine
 */
public class EstoqueController {
    
    public Estoque saidaEstoque(double quantidade, Estoque estoque, int idEmpresa){
        estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() - quantidade);
        EstoqueFacade estoqueFacade  = new EstoqueFacade();
        try {
            estoqueFacade.salvarEstoque(estoque);
            estoque = estoqueFacade.getEstoqueProduto(estoque.getProduto(), idEmpresa);
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Saída no Estoque");
        }
        return estoque;
    }
    
    public Estoque entradaEstoque(double quantidade, Estoque estoque, int idEmpresa, boolean nf, double valorCustoEntrada){
        estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() + quantidade);
        if (valorCustoEntrada>0){
            double vc = calcularValorCusto(estoque.getValorCusto(), valorCustoEntrada);
            estoque.setValorCusto(vc);
        }
        if (nf){
            if (estoque.getQuantidadeMaxima()==null){
                estoque.setQuantidadeMaxima(quantidade);
            }else {
                estoque.setQuantidadeMaxima(estoque.getQuantidadeMaxima() + quantidade);
            }
        }
        EstoqueFacade estoqueFacade  = new EstoqueFacade();
        try {
            estoqueFacade.salvarEstoque(estoque);
            estoque = estoqueFacade.getEstoqueProduto(estoque.getProduto(), idEmpresa);
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Entrada no Estoque");
        }
        return estoque;
    }
    
    
    
    public Estoque consultarEstoque(int idProduto, int idEmpresa){
        EstoqueFacade estoqueFacade  = new EstoqueFacade();
        Estoque estoque = new Estoque();
        try {
            estoque = estoqueFacade.getEstoqueProduto(idProduto, idEmpresa);
            return estoque;
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar Estoque " + ex);
            return null;
        }
    }
    
    public Map calcularTotaisEstoque(Map parameters, Empresa empresa){
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        List<Viewconsultaprodutoestoque> listaEstoque = null;
        try {
            listaEstoque  = estoqueFacade.listarEntradaProduto(empresa.getIdempresa());
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Relação Estoque" + ex);
        }
        float totalGeral =0;
        if (listaEstoque!=null){
            for (int i=0;i<listaEstoque.size();i++){
                if (listaEstoque.get(i).getQuantidadeEstoque()>0){
                    totalGeral = (float) (totalGeral + (listaEstoque.get(i).getQuantidadeEstoque() * listaEstoque.get(i).getValorCusto()));
                }
                
            }
        }
        parameters.put("numeroItens", listaEstoque.size());
        parameters.put("totalGeral", totalGeral);
        return parameters;
    }
    
    public Estoque salvarEstoque(Estoque estoque){
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.salvarEstoque(estoque);
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Estoque " + ex);
            return null;
        }
    }
    
    public List<Viewconsultaprodutoestoque> consultarEstoqueGeral(int idEmpresa){
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.listarEstoqueGeral(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Estoque Geral " + ex);
            return null;
        }
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueCodigoBarras(String codigoBarras, int idEmpresa) {
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.listarEstoqueCodigoBarras(codigoBarras, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Códgio Barras " +ex);
            return null;
        }
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueDescricao(String descricao, int idEmpresa){
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.listarEstoqueDescricao(descricao, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Produto Descrição " + ex);
            return null;
        }
    }
    
    public List<Viewconsultaprodutoestoque> listarEstoqueReferencia(int referencia,  int idEmpresa) {
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.listarEstoqueReferencia(referencia, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Produto Código " + ex);
            return null;
        }
    }
    
    public Double calcularValorCusto(Double custoEstoque, double custoEntrada){
        double valorCusto=0;
        if (custoEstoque==0){
             valorCusto = custoEntrada;
        }else {
            valorCusto = custoEntrada + custoEstoque;
            valorCusto = valorCusto / 2;
        }
        return valorCusto;
        
    }
    
    public List<Estoque> consultaEstoqueProduto(int idProduto, int idEmpresa) {
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        try {
            return estoqueFacade.consultaEstoqueProduto(idProduto, idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Estoque " + ex);
            return null;
        }
    }
}
