/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.RelatoriosGerenciais;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "relentradasaida")
@NamedQueries({
    @NamedQuery(name = "Relentradasaida.findAll", query = "SELECT r FROM Relentradasaida r")})
public class Relentradasaida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeEntrada")
    private Double quantidadeEntrada;
    @Column(name = "valorEntrada")
    private Double valorEntrada;
    @Column(name = "quantidadeSaida")
    private Double quantidadeSaida;
    @Column(name = "valorSaida")
    private Double valorSaida;
    @Column(name = "valorCustoSaida")
    private Double valorCustoSaida;

    public Relentradasaida() {
    }

    public Relentradasaida(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

 
    public Double getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(Double quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public Double getValorCustoSaida() {
        return valorCustoSaida;
    }

    public void setValorCustoSaida(Double valorCustoSaida) {
        this.valorCustoSaida = valorCustoSaida;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Double getQuantidadeSaida() {
        return quantidadeSaida;
    }

    public void setQuantidadeSaida(Double quantidadeSaida) {
        this.quantidadeSaida = quantidadeSaida;
    }

    public Double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Double valorSaida) {
        this.valorSaida = valorSaida;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relentradasaida)) {
            return false;
        }
        Relentradasaida other = (Relentradasaida) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "telas.RelatoriosGerenciais.Relentradasaida[ idProduto=" + idProduto + " ]";
    }
    
}
