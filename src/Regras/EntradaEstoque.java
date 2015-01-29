/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Docentrada;
import model.Fornecedor;
import model.Nfentrada;

/**
 *
 * @author Wolverine
 */
public class EntradaEstoque {
    
    Docentrada docEntrada;
    Nfentrada NotaFiscal;
    Fornecedor fornecedor;
    List<ListaProdutoEntrada> listaProdutos;
    private double valorProdutos;
    private double valorEncargos;
    private double valorTotal;

    public EntradaEstoque() {
        this.docEntrada = new Docentrada();
        this.NotaFiscal = new Nfentrada();
        this.fornecedor = new Fornecedor();
        this.listaProdutos = new ArrayList<ListaProdutoEntrada>();
        this.valorProdutos = 0.0;
        this.valorEncargos = 0.0;
        this.valorTotal = 0.0;
    }
    
    

    public Nfentrada getNotaFiscal() {
        return NotaFiscal;
    }

    public void setNotaFiscal(Nfentrada NotaFiscal) {
        this.NotaFiscal = NotaFiscal;
    }

    public Docentrada getDocEntrada() {
        return docEntrada;
    }

    public void setDocEntrada(Docentrada docEntrada) {
        this.docEntrada = docEntrada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ListaProdutoEntrada> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ListaProdutoEntrada> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double getValorEncargos() {
        return valorEncargos;
    }

    public void setValorEncargos(double valorEncargos) {
        this.valorEncargos = valorEncargos;
    }

    public double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void calcularTotais(){
        valorEncargos = 0;
        valorProdutos = 0;
        valorTotal = 0;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (!(listaProdutos.get(i).isExcluido())) {
                valorProdutos = valorProdutos + listaProdutos.get(i).getEntradaproduto().getValorTotal();
                valorEncargos =  valorEncargos + (listaProdutos.get(i).getEntradaproduto().getValorTotalCusto() - listaProdutos.get(i).getEntradaproduto().getValorTotal());
                valorTotal = valorEncargos + valorProdutos;
            }
        }
    }


    
    
}
