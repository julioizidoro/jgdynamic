/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Julio
 */
@Entity
@Table(name = "contasreceber")
public class Contasreceber implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceber")
    private Integer idcontasReceber;
    @Size(max = 20)
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "numeroParcelas")
    private Integer numeroParcelas;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "dataRecebimento")
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Size(max = 20)
    @Column(name = "numeroFaturaGerada")
    private String numeroFaturaGerada;
    @Size(max = 3)
    @Column(name = "pagamento")
    private String pagamento;
    @Column(name = "bancoPagamento")
    private int bancoPagamento;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 7)
    @Column(name = "mes")
    private String mes;
    @Column(name = "numeroFatura")
    private Integer numeroFatura;
    @JoinColumn(name = "vendedor_idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedor;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "contasReceberPagamento_idcontasReceberPagamento", referencedColumnName = "idcontasReceberPagamento")
    @ManyToOne(optional = false)
    private Contasreceberpagamento contasreceberpagamento;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contasreceber")
    private List<Contasreceberprodutos> contasreceberprodutosList;
    
    

    public Contasreceber() {
    }

    public Contasreceber(Integer idcontasReceber) {
        this.idcontasReceber = idcontasReceber;
    }

    public Integer getIdcontasReceber() {
        return idcontasReceber;
    }

    public void setIdcontasReceber(Integer idcontasReceber) {
        this.idcontasReceber = idcontasReceber;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public int getBancoPagamento() {
        return bancoPagamento;
    }

    public void setBancoPagamento(int bancoPagamento) {
        this.bancoPagamento = bancoPagamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public String getNumeroFaturaGerada() {
        return numeroFaturaGerada;
    }

    public void setNumeroFaturaGerada(String numeroFaturaGerada) {
        this.numeroFaturaGerada = numeroFaturaGerada;
    }

    public String getMes() {
        return mes;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(Integer numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contasreceberpagamento getContasreceberpagamento() {
        return contasreceberpagamento;
    }

    public void setContasreceberpagamento(Contasreceberpagamento contasreceberpagamento) {
        this.contasreceberpagamento = contasreceberpagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Contasreceberprodutos> getContasreceberprodutosList() {
        return contasreceberprodutosList;
    }

    public void setContasreceberprodutosList(List<Contasreceberprodutos> contasreceberprodutosList) {
        this.contasreceberprodutosList = contasreceberprodutosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasReceber != null ? idcontasReceber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceber)) {
            return false;
        }
        Contasreceber other = (Contasreceber) object;
        if ((this.idcontasReceber == null && other.idcontasReceber != null) || (this.idcontasReceber != null && !this.idcontasReceber.equals(other.idcontasReceber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceber[ idcontasReceber=" + idcontasReceber + " ]";
    }
    
}
