/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import model.Aliquota;
import model.Entradaproduto;
import model.Estoque;
import model.Produto;
import model.Vinculo;

/**
 *
 * @author Wolverine
 */
public class ListaProdutoEntrada {
    
    Entradaproduto entradaproduto;
    Produto produto;
    Estoque estoque;
    Vinculo vinculo;
    boolean excluido;
    Float valorVenda;
    Aliquota aliquota;
    boolean estoqueAdicionado;
    

    public ListaProdutoEntrada() {
        this.entradaproduto = new Entradaproduto();
        this.produto = new Produto();
        this.vinculo = new Vinculo();
        this.excluido = false;
        this.aliquota = new Aliquota();
        this.estoqueAdicionado = false;
    
    }


    public Entradaproduto getEntradaproduto() {
        return entradaproduto;
    }

    public Aliquota getAliquota() {
        return aliquota;
    }

    public void setAliquota(Aliquota aliquota) {
        this.aliquota = aliquota;
    }

    public void setEntradaproduto(Entradaproduto entradaproduto) {
        this.entradaproduto = entradaproduto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public boolean isEstoqueAdicionado() {
        return estoqueAdicionado;
    }

    public void setEstoqueAdicionado(boolean estoqueAdicionado) {
        this.estoqueAdicionado = estoqueAdicionado;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
    
}
