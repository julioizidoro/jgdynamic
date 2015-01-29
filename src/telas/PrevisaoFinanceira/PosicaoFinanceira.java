/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.PrevisaoFinanceira;

import java.util.Date;

/**
 *
 * @author wolverine
 */
public class PosicaoFinanceira {
    
    private Date data;
    private float contasPagar;
    private float CaixaCartao;
    private float caixaMoviemnto;
    private float caixaContasReceber;
    private float bbCartao;
    private float bbMoviemnto;
    private float bbContasReceber;
    private float chequePre;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public float getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(float contasPagar) {
        this.contasPagar = contasPagar;
    }

    public float getCaixaCartao() {
        return CaixaCartao;
    }

    public void setCaixaCartao(float CaixaCartao) {
        this.CaixaCartao = CaixaCartao;
    }

    public float getCaixaMoviemnto() {
        return caixaMoviemnto;
    }

    public void setCaixaMoviemnto(float caixaMoviemnto) {
        this.caixaMoviemnto = caixaMoviemnto;
    }

    public float getCaixaContasReceber() {
        return caixaContasReceber;
    }

    public void setCaixaContasReceber(float caixaContasReceber) {
        this.caixaContasReceber = caixaContasReceber;
    }

    public float getBbCartao() {
        return bbCartao;
    }

    public void setBbCartao(float bbCartao) {
        this.bbCartao = bbCartao;
    }

    public float getBbMoviemnto() {
        return bbMoviemnto;
    }

    public void setBbMoviemnto(float bbMoviemnto) {
        this.bbMoviemnto = bbMoviemnto;
    }

    public float getBbContasReceber() {
        return bbContasReceber;
    }

    public void setBbContasReceber(float bbContasReceber) {
        this.bbContasReceber = bbContasReceber;
    }

    public float getChequePre() {
        return chequePre;
    }

    public void setChequePre(float chequePre) {
        this.chequePre = chequePre;
    }
    
    

}
