/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatoriosGerenciais;

import Regras.DevolucaoController;
import Regras.Formatacao;
import facade.ViewProdutoFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Devolucao;
import view.Viewprodutoentrada;
import view.Viewprodutosaida;


/**
 *
 * @author Wolverine
 */
public class GerarRelEntradaSaida {
    
    private String dataInicial;
    private String dataFinal;
    private Double valorDevolucao;

    public GerarRelEntradaSaida(String dataInicial, String dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        exluirRelEtradaSaida();
        gerarDevolucao();
        gerarSaida();
        gerarEntrada();
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Double getValorDevolucao() {
        return valorDevolucao;
    }

    public void setValorDevolucao(Double valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }
    
    public void gerarSaida(){
        ViewProdutoFacade viewProdutoFacade = new  ViewProdutoFacade();
        try {
            List<Viewprodutosaida> listaSaida = viewProdutoFacade.listarSaidas(dataInicial, dataFinal);
            if (listaSaida!=null){
                for(int i=0;i<listaSaida.size();i++){
                    Viewprodutosaida saida = new Viewprodutosaida();
                    saida = listaSaida.get(i);
                    salvarProdutoSaida(saida);
                }
            }
    //        VendaController vendaController = new VendaController();
    //        List<Venda> listaVenda =  vendaController.listarVendaPeriodo(dataInicial, dataFinal);
    //        if (listaVenda!=null){
    //            for(int i=0;i<listaVenda.size();i++){
    //                gerarProdutoVenda(listaVenda.get(i).getIdvenda());
    //        }
    //        }
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Saídas"  +  ex);
        }
        
    }    
    
    public void gerarEntrada(){
       ViewProdutoFacade viewProdutoFacade = new  ViewProdutoFacade();
        try {
            List<Viewprodutoentrada> listaEntrada = viewProdutoFacade.listarEntradas(dataInicial, dataFinal);
            if (listaEntrada!=null){
                for(int i=0;i<listaEntrada.size();i++){
                    salvarProdutoEntrada(listaEntrada.get(i));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Entradas"  +  ex);
        }
    }
    
    
    
    public void salvarProdutoSaida(Viewprodutosaida saida){
        ViewProdutoFacade viewProdutoFacade = new ViewProdutoFacade();
        Relentradasaida produto = new Relentradasaida();
        try {
            produto = viewProdutoFacade.consultaProduto(saida.getProdutoIdproduto());
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar RelEntradasaida "  + ex);
        }
        if (produto==null){
            produto = new Relentradasaida();
            produto.setIdProduto(saida.getProdutoIdproduto());
        
            produto.setQuantidadeSaida(saida.getQuantidade());
            produto.setValorSaida(saida.getValorVenda().doubleValue());
            produto.setValorCustoSaida(saida.getValorCompra().doubleValue());
            if (produto.getValorEntrada()==null){
                produto.setValorEntrada(0.0);
            }
            if (produto.getQuantidadeEntrada()==null){
                produto.setQuantidadeEntrada(0.0);
            }
        }else {
            produto.setQuantidadeSaida(saida.getQuantidade() + produto.getQuantidadeSaida());
            produto.setValorSaida(saida.getValorVenda() + produto.getValorSaida());
            produto.setValorCustoSaida(produto.getValorCustoSaida() + saida.getValorCompra());
        }
        try {
            viewProdutoFacade.salvar(produto);
        } catch (Exception ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Produto Saida "  + ex);
        }
    }
    
    public void salvarProdutoEntrada(Viewprodutoentrada entrada){
        ViewProdutoFacade viewProdutoFacade = new ViewProdutoFacade();
        Relentradasaida produto = new Relentradasaida();
        try {
            produto = viewProdutoFacade.consultaProduto(entrada.getIdproduto());
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Erro Consultar RelEntradasaida "  + ex);
        }
        if (produto==null){
            produto = new Relentradasaida();
            produto.setIdProduto(entrada.getIdproduto());
            produto.setQuantidadeEntrada(entrada.getQuantidade());
            produto.setValorEntrada(entrada.getValorTotalCusto().doubleValue());
            if (produto.getValorCustoSaida()==null){
                produto.setValorCustoSaida(0.0);
            }
            if (produto.getQuantidadeSaida()==null){
                produto.setQuantidadeSaida(0.0);
            }
            if (produto.getValorSaida()==null){
                produto.setValorSaida(0.0);
            }
        }else {
            produto.setQuantidadeEntrada(produto.getQuantidadeEntrada() + entrada.getQuantidade());
            produto.setValorEntrada(produto.getValorEntrada() + entrada.getValorTotalCusto().doubleValue());
        }
        try {
            viewProdutoFacade.salvar(produto);
        } catch (Exception ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Produto Entrada "  + ex);
        }
    }
    
    public void exluirRelEtradaSaida(){
        List<Relentradasaida> listaRelEntradaSaida = new ArrayList<Relentradasaida>();
        ViewProdutoFacade viewProdutoFacade = new ViewProdutoFacade();
        try {
            listaRelEntradaSaida = viewProdutoFacade.listaRelEntradaSaida();
            if (listaRelEntradaSaida != null) {
                if (listaRelEntradaSaida.size() > 0) {
                    for (int i = 0; i < listaRelEntradaSaida.size(); i++) {
                        viewProdutoFacade.exluir(listaRelEntradaSaida.get(i).getIdProduto());
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void gerarDevolucao() {
        DevolucaoController devolucaoController = new DevolucaoController();
        List<Devolucao> listaDevolucao = devolucaoController.valorDevolucaoPeriodo(dataInicial, dataFinal);
        valorDevolucao = 0.0;
        if (listaDevolucao != null) {
            for (int i = 0; i < listaDevolucao.size(); i++) {
                valorDevolucao = valorDevolucao + listaDevolucao.get(i).getValorDevolucao();
            }
        }
    }
}
