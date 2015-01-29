/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewrelcontasrecebertodas")
public class Viewrelcontasrecebertodas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_idcliente")
    @Id
    private int clienteIdcliente;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 13)
    @Column(name = "foneFixo")
    private String foneFixo;
    @Size(max = 13)
    @Column(name = "foneCelular")
    private String foneCelular;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Size(max = 50)
    @Column(name = "formaPagamento")
    private String formaPagamento;
    @Column(name = "diaPagamento")
    private Integer diaPagamento;
    @Column(name = "diasAtraso")
    private Integer diasAtraso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_idempresa")
    private int empresaIdempresa;

    public Viewrelcontasrecebertodas() {
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(Integer diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public int getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(int empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }
    
}
