/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatoriosGerenciais;

import Regras.ContasReceberController;
import Regras.FormaPagamentoController;
import Regras.Formatacao;
import controler.Config;
import facade.DevolucaoFacade;
import facade.FechaCaixaFacade;
import facade.FormaPagamentoFacade;
import facade.VendaFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Wolverine
 */
public class relMovimentoFinanceiro {
    
    private List<movimentoFinanceiro> listaMovimentoFinanceiro;
    private movimentoFinanceiro movimentoFinanceiro;
    private Date dataInicial;
    private Date dataFinal;
    
    private float totalDevoucao;
    
    List<Formapagamento> listaFormaPagamento;
    List<Fechacaixa> listaFechamento;
    private Config config;

    public relMovimentoFinanceiro(Date dataInicial, Date dataFinal, Config config) {
        this.listaMovimentoFinanceiro = new  ArrayList<movimentoFinanceiro>();
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.config = config;
        iniciarCalculo();
        
    }
    
    private void iniciarCalculo(){
        FechaCaixaFacade fechaCaixaFacade = new FechaCaixaFacade();
        Long fData = dataFinal.getTime();
        Long iData = dataInicial.getTime();
        while (fData >= iData) {
            try {
                String cData = Formatacao.ConvercaoDataSql(dataInicial);
                listaFechamento = fechaCaixaFacade.pesquisarFechamento(cData, config.getEmpresa().getIdempresa());
                if (listaFechamento.size() > 0) {
                    totalDevoucao=0;
                    movimentoFinanceiro = new movimentoFinanceiro();
                    for (int i = 0; i < listaFechamento.size(); i++) {
                        movimentoFinanceiro.setData(listaFechamento.get(i).getDataFechamento());
                        gerarListaSituacaoVendas(listaFechamento.get(i));
                        listarVendaPrazo(listaFechamento.get(i));
                        gerarListaDeducoes(listaFechamento.get(i));
                        gerarListaContas(listaFechamento.get(i));
                        
                    }
                    movimentoFinanceiro.setVendaVista((movimentoFinanceiro.getVendaVista()) - (totalDevoucao));
                    movimentoFinanceiro.setTotalVendas(movimentoFinanceiro.getVendaVista() + movimentoFinanceiro.getVendaPrazo()
                    + movimentoFinanceiro.getCartaoCredito() + movimentoFinanceiro.getChequePre());
                    movimentoFinanceiro.setTotalGeral(movimentoFinanceiro.getTotalVendas() + movimentoFinanceiro.getRecebimentos());

                    listaMovimentoFinanceiro.add(movimentoFinanceiro);
                 }
            } catch (Exception ex) {
                Logger.getLogger(relMovimentoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro listar fechamentos " + ex);
            }
            
            dataInicial = Formatacao.SomarDiasData(dataInicial, 1);
            iData = dataInicial.getTime();
        }
    }
    
    private void gerarListaSituacaoVendas(Fechacaixa fechamento){
        
        FormaPagamentoFacade formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            listaFormaPagamento = formaPagamentoFacade.ListarFormaPagamento(config.getEmpresa().getIdempresa());
        } catch (SQLException ex) {
            Logger.getLogger(relMovimentoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        VendaFacade vendaFacade = new VendaFacade();
        for (int i=0;i<listaFormaPagamento.size();i++){
            float valor=0f;
            try {
                valor = vendaFacade.valorFormaPagamento(listaFormaPagamento.get(i).getIdformaPagamento(), fechamento.getIdfechaCaixa());
            } catch (SQLException ex) {
                Logger.getLogger(relMovimentoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaFormaPagamento.get(i).setValor(valor);
        }
        for(int i=0;i<listaFormaPagamento.size();i++){
            if (listaFormaPagamento.get(i).getTipoControle().equalsIgnoreCase("Venda Vista")){
                movimentoFinanceiro.setVendaVista(movimentoFinanceiro.getVendaVista() + listaFormaPagamento.get(i).getValor());
            }else if (listaFormaPagamento.get(i).getTipoControle().equalsIgnoreCase("Cheque Pre")){
                movimentoFinanceiro.setChequePre(movimentoFinanceiro.getChequePre() + listaFormaPagamento.get(i).getValor());
            } else if (listaFormaPagamento.get(i).getTipoControle().equalsIgnoreCase("Cartao Credito")){
                movimentoFinanceiro.setCartaoCredito(movimentoFinanceiro.getCartaoCredito() + listaFormaPagamento.get(i).getValor());
            }
        }
    }
    
    public void listarVendaPrazo(Fechacaixa fechaCaixa){
        List<Venda> listaVenda = null;
        double valor = 0;
        VendaFacade vendaFacade = new VendaFacade();
        try {
            listaVenda = vendaFacade.listarVendaPrazo(Formatacao.ConvercaoDataSql(fechaCaixa.getDataFechamento()), this.config.getEmpresa().getIdempresa());
        } catch (SQLException ex) {
            Logger.getLogger(relMovimentoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Venda Prazo" + ex);
        }
        if (listaVenda!=null){
            for (int i=0;i<listaVenda.size();i++){
                valor = valor + listaVenda.get(i).getValorVenda();
            }
        }
        
        
        movimentoFinanceiro.setVendaPrazo(valor);
    }
    
    public void gerarListaContas(Fechacaixa fechaCaixa){
        Float valorTotal = 0.0f;
        Float valorCreditos = 0.0f;
        Float valorCartao = 0.0f;
        FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
        listaFormaPagamento = formaPagamentoController.getFormaPagamento();
        ContasReceberController contasReceberController = new ContasReceberController();
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            if (listaFormaPagamento.get(i).getIdformaPagamento()==17){
                valorCreditos = valorCreditos + contasReceberController.valorFormaPagamento(listaFormaPagamento.get(i).getIdformaPagamento(), fechaCaixa.getIdfechaCaixa(), this.config.getEmpresa().getIdempresa());
            }else {
                valorTotal += contasReceberController.valorFormaPagamento(listaFormaPagamento.get(i).getIdformaPagamento(), fechaCaixa.getIdfechaCaixa(), this.config.getEmpresa().getIdempresa());
            }
        }
        listaFormaPagamento = formaPagamentoController.getFormaPagamentoCaratao();
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            valorCartao = valorCartao + contasReceberController.valorFormaPagamento(listaFormaPagamento.get(i).getIdformaPagamento(), fechaCaixa.getIdfechaCaixa(), this.config.getEmpresa().getIdempresa());
        }
        movimentoFinanceiro.setRecebimentos(movimentoFinanceiro.getRecebimentos() + valorTotal + valorCartao);
        movimentoFinanceiro.setCredito(movimentoFinanceiro.getCredito() + valorCreditos);
        List<Contasreceberpagamento> listaPagamento = contasReceberController.consultarContasReceberPagamento(fechaCaixa.getIdfechaCaixa());
        Double valorDesconto = 0.0;
        if (listaPagamento!=null){
            for(int i=0;i<listaPagamento.size();i++){
                valorDesconto = valorDesconto + listaPagamento.get(i).getDesconto();
            }
        }
        movimentoFinanceiro.setDesconto(movimentoFinanceiro.getDesconto() + valorDesconto);
    }
    
   
    
    
    public double gerarValorRecebimentoConta(String formaPagamento, Fechacaixa fechaCaixa){
        ContasReceberController contasReceberController = new ContasReceberController();
        double valor = 0;
        List<Contasreceberpagamento> listaContasReceberPagamento = contasReceberController.consultarContasReceberPagamento(fechaCaixa.getIdfechaCaixa());
        if (listaContasReceberPagamento!=null){
            for (int i=0;i<listaContasReceberPagamento.size();i++){
                valor = valor + gerarValorFormaRecebimento(formaPagamento, listaContasReceberPagamento.get(i).getIdcontasReceberPagamento());
            }
        }
        return valor;
    }
    
    public double gerarValorFormaRecebimento(String forma, int idContasReceberPagamento){
        ContasReceberController contasReceberController = new ContasReceberController();
        List<Contasreceberforma> listaContasReceberForma = contasReceberController.consultarFormaPagamento(idContasReceberPagamento, forma);
        double valor =0;
        if (listaContasReceberForma!=null){
            for (int i=0;i<listaContasReceberForma.size();i++){
                valor = valor + listaContasReceberForma.get(i).getValorPago();
            }
        }
        return valor;
    }
    
    public void gerarListaDeducoes(Fechacaixa fechaCaixa){
        DevolucaoFacade devolucaoFacade = new DevolucaoFacade();
        List<Devolucao> listaDevolucao = null;
        try {
            listaDevolucao = devolucaoFacade.getDevolucao(fechaCaixa);
        } catch (Exception ex) {
            Logger.getLogger(relMovimentoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        float valorDevolucao=0;
        if (listaDevolucao!=null){
            for(int i=0;i<listaDevolucao.size();i++){
                valorDevolucao = valorDevolucao + listaDevolucao.get(i).getValorDevolucao();
            }
        }
        totalDevoucao = totalDevoucao + valorDevolucao;
        
      
    }

    public List<telas.RelatoriosGerenciais.movimentoFinanceiro> getListaMovimentoFinanceiro() {
        return listaMovimentoFinanceiro;
    }
    
}
