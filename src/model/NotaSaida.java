/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "notaSaida")
public class NotaSaida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotaSaida")
    private Integer idnotaSaida;
    @Column(name = "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "serie")
    private Integer serie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorProdutos")
    private Float valorProdutos;
    @Column(name = "valorNotaFiscal")
    private Float valorNotaFiscal;
    @Lob
    @Column(name = "xml")
    private byte[] xml;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "usuarios_idusuarios")
    private int usuario;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "idcliente")
    private int idcliente;
    @Column(name = "idfornecedor")
    private int idfornecedor;
    @Column(name = "nomeArquivoXML")
    private String nomeArquivoXML;
    @Column(name = "chaveAutorizacao")
    private String cahveAutorizacao;
    @Column(name = "tipo")
    private String tipo;
    
    

    public NotaSaida() {
    }

    public NotaSaida(Integer idnotaSaida) {
        this.idnotaSaida = idnotaSaida;
    }

    public Integer getIdnotaSaida() {
        return idnotaSaida;
    }

    public String getCahveAutorizacao() {
        return cahveAutorizacao;
    }

    public void setCahveAutorizacao(String cahveAutorizacao) {
        this.cahveAutorizacao = cahveAutorizacao;
    }

    public void setIdnotaSaida(Integer idnotaSaida) {
        this.idnotaSaida = idnotaSaida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Float getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Float valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Float getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(Float valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    public byte[] getXml() {
        return xml;
    }

    public String getNomeArquivoXML() {
        return nomeArquivoXML;
    }

    public void setNomeArquivoXML(String nomeArquivoXML) {
        this.nomeArquivoXML = nomeArquivoXML;
    }

    public void setXml(byte[] xml) {
        this.xml = xml;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotaSaida != null ? idnotaSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaSaida)) {
            return false;
        }
        NotaSaida other = (NotaSaida) object;
        if ((this.idnotaSaida == null && other.idnotaSaida != null) || (this.idnotaSaida != null && !this.idnotaSaida.equals(other.idnotaSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NotaSaida[ idnotaSaida=" + idnotaSaida + " ]";
    }
    
}
