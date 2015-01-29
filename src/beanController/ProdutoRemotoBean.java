/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanController;

import Regras.EstoqueController;
import Regras.ProdutoController;
import Singleton.ConexaoSingletonRemota;
import controler.Config;
import facadeRemoto.ProdutoRemotoFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.Estoque;
import model.Produto;
import telas.Produtos.FrmCadastrarProduto;

/**
 *
 * @author wolverine
 */
public class ProdutoRemotoBean {
    
    private Config config;

    public ProdutoRemotoBean(Config config) {
        this.config = config;
    }
    
        public void IniciarExportacaoProduto() {
        if (verificarConexao()) {
            ProdutoController produtoController = new ProdutoController();
            List<Produto> listaExportacao = produtoController.consultarProdutoExportacao();
            if (listaExportacao != null) {
                for (int i = 0; i < listaExportacao.size(); i++) {
                    Produto produto = listaExportacao.get(i);
                    produto.setIdProduto(null);
                    if (ExportarProduto(produto)) {
                        atualziarProduto(produto);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro de Comunicação");
        }
    }
    
    public void atualziarProduto(Produto produto){
        ProdutoController produtoController = new ProdutoController();
        produto = produtoController.consultarProdutoid(produto.getIdProduto());
        if (produto!=null){
                produto.setSincronizado(1);
                produtoController.salvarProduto(produto);
        }
    }
    
    
    public boolean ExportarProduto(Produto produto){
        ProdutoRemotoFacade produtoRemotoFacade = new ProdutoRemotoFacade();
        try {
            produto.setSincronizado(3);
            produtoRemotoFacade.salvarProduto(produto);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public void ImportarProduto() {
        if (verificarConexao()) {
            ProdutoRemotoFacade produtoRemotoFacade = new ProdutoRemotoFacade();
            List<Produto> listaImportacao = null;
            try {
                listaImportacao = produtoRemotoFacade.listarProdutoImportacao();
            } catch (Exception ex) {
                Logger.getLogger(ProdutoRemotoBean.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro Listar produto para Impostação " + ex);
            }
            if (listaImportacao.size() > 0) {
                for (int i = 0; i < listaImportacao.size(); i++) {
                    salvarProdutoImportacao(listaImportacao.get(i));
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro de Comunicação");
        }
    }
    
    public void salvarProdutoImportacao(Produto produto){
        Produto novoProduto = produto;
        novoProduto.setIdProduto(null);
        ProdutoController produtoController = new ProdutoController();
        novoProduto.setSincronizado(1);
        novoProduto = produtoController.salvarProduto(novoProduto);
        salvarEstoque(novoProduto);
        ProdutoRemotoFacade produtoRemotoFacade = new ProdutoRemotoFacade();
        Produto cadProduto = new Produto();
        try {
            cadProduto = produtoRemotoFacade.consultarProdutoReferencia(produto.getReferencia());
        } catch (Exception ex) {
            Logger.getLogger(ProdutoRemotoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadProduto.setSincronizado(1);
        try {
            produtoRemotoFacade.salvarProduto(cadProduto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoRemotoBean.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Prduto " + ex);
        }
        
    }
    
    public void salvarEstoque(Produto produto){
        Estoque estoque = new Estoque();
        EstoqueController estoqueController = new EstoqueController();
        estoque.setEmpresa(config.getEmpresa().getIdempresa());
        estoque.setPedido(0);
        estoque.setPercentualVendas(0.0);
        estoque.setQuantidadeEstoque(0.0);
        estoque.setProduto(produto.getIdProduto());
        estoque.setQuantidadeMaxima(0.0);
        estoque.setQuantidadeMinima(0.0);
        estoque.setValorCusto(0.0);
        estoque.setValorVenda(0.0f);
        estoque.setValorCompra(0.0);
        estoque.setValorDesconto(0.0f);
        estoqueController.salvarEstoque(estoque);
    }
    
    public boolean verificarConexao() {
        boolean teste = false;
        try {
            EntityManager manager = ConexaoSingletonRemota.getConexao();
            if (manager!=null){
                teste = true;
                return true;
            }else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoRemotoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   
}
