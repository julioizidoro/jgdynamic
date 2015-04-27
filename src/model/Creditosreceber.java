/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "creditosreceber")
public class Creditosreceber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcreditosReceber")
    private Integer idcreditosReceber;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCredito")
    private Double valorCredito;
    @Column(name = "utilizado")
    private String utilizado;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "contasreceberpagamento_idcontasReceberPagamento")
    private int contasreceberpagamento;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "cliente_idCliente")
    private int cliente;
    @Column(name = "numerofatura")
    private String numerofatura;

    public Creditosreceber() {
    }

    public Creditosreceber(Integer idcreditosReceber) {
        this.idcreditosReceber = idcreditosReceber;
    }

    public Integer getIdcreditosReceber() {
        return idcreditosReceber;
    }

    public void setIdcreditosReceber(Integer idcreditosReceber) {
        this.idcreditosReceber = idcreditosReceber;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public String getNumerofatura() {
        return numerofatura;
    }

    public void setNumerofatura(String numerofatura) {
        this.numerofatura = numerofatura;
    }

   

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(String utilizado) {
        this.utilizado = utilizado;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContasreceberpagamento() {
        return contasreceberpagamento;
    }

    public void setContasreceberpagamento(int contasreceberpagamento) {
        this.contasreceberpagamento = contasreceberpagamento;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcreditosReceber != null ? idcreditosReceber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditosreceber)) {
            return false;
        }
        Creditosreceber other = (Creditosreceber) object;
        if ((this.idcreditosReceber == null && other.idcreditosReceber != null) || (this.idcreditosReceber != null && !this.idcreditosReceber.equals(other.idcreditosReceber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Creditosreceber[ idcreditosReceber=" + idcreditosReceber + " ]";
    }
    
}
