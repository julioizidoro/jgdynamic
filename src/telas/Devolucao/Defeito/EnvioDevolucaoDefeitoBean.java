/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Devolucao.Defeito;

import model.Fornecedor;

/**
 *
 * @author Wolverine
 */
public class EnvioDevolucaoDefeitoBean {
    
    private Fornecedor fornecedor;
    private int idProduto;
    private int referencia;
    private String descricao;
    private int idDevolucaoDefeito;
    private float valor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdDevolucaoDefeito() {
        return idDevolucaoDefeito;
    }

    public void setIdDevolucaoDefeito(int idDevolucaoDefeito) {
        this.idDevolucaoDefeito = idDevolucaoDefeito;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
}
