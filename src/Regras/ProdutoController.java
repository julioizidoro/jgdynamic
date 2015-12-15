/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ProdutoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import model.ProdutoImagem;

/**
 *
 * @author Wolverine
 */
public class ProdutoController {
    
     public List<Produto> consultarProduto(){
        ProdutoFacade produtoFacade = new ProdutoFacade();
        List<Produto> listaProduto;
        try {
            listaProduto = produtoFacade.consultarProduto();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro consultar Produto");
            listaProduto = null;
        }
        return listaProduto;
     }
     
     public List<Produto> listarReferencia(int referencia)  {
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.listarReferencia(referencia);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro consultar Produto");
            return null;
        }
     }
    
    public Produto consultarProdutoReferencia(int referencia){
        Produto produto = new Produto();
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            produto = produtoFacade.consultarProdutoReferencia(referencia);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro consultar Produto");
            produto = null;
        }
        return produto;
    }
    
    
    
    public Produto consultarProdutoFabricante(String codigoFabricante){
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            int idProduto = produtoFacade.pesquisarCodigoFabricante(codigoFabricante);
            try {
                return produtoFacade.consultarProdutoid(idProduto);
            } catch (Exception ex) {
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro Consultar Produto " + ex);
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Produto " + ex);
            return null;
        }
    }
    
    public Produto consultarProdutoid(int idProduto)  {
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.consultarProdutoid(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Produto Id" + ex);
            return null;
        }
    }
    
    public Produto salvarProduto(Produto produto){
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.salvarProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro Salvar Produto " + ex);
            return null;
        }
    }
    
    public ProdutoImagem salvarFotoProduto(ProdutoImagem produtoImagem) {
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.salvarFotoProduto(produtoImagem);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Produto " + ex);
            return null;
        }
    }
    
    public ProdutoImagem consultarProdutoFoto(int idProduto){
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.consultarProdutoFoto(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Localizar Imagem do Produto " + ex);
            return null;
        }
    }
    
    public List<Produto> consultarProdutoExportacao() {
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.consultarProdutoExportacao();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Produto Exportação " + ex);
            return null;
        }
    }
    
    
}
