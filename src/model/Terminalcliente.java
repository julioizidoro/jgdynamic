/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "terminalcliente")
public class Terminalcliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idterminalCliente")
    private Integer idterminalCliente;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percDesconto")
    private Float percDesconto;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "acrescimo")
    private Float acrescimo;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "formapagamento_idformaPagamento")
    private int formapagamento;
    @Column(name = "empresa_idempresa")
    private int empresa;
    
    public Terminalcliente() {
    }

    public Terminalcliente(Integer idterminalCliente) {
        this.idterminalCliente = idterminalCliente;
    }

    public Integer getIdterminalCliente() {
        return idterminalCliente;
    }

    public void setIdterminalCliente(Integer idterminalCliente) {
        this.idterminalCliente = idterminalCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(Float percDesconto) {
        this.percDesconto = percDesconto;
    }

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idterminalCliente != null ? idterminalCliente.hashCode() : 0);
        return hash;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(int formapagamento) {
        this.formapagamento = formapagamento;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminalcliente)) {
            return false;
        }
        Terminalcliente other = (Terminalcliente) object;
        if ((this.idterminalCliente == null && other.idterminalCliente != null) || (this.idterminalCliente != null && !this.idterminalCliente.equals(other.idterminalCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Terminalcliente[ idterminalCliente=" + idterminalCliente + " ]";
    }
    
}
