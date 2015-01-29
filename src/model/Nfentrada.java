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
 * @author Wolverine
 */
@Entity
@Table(name = "nfentrada")
public class Nfentrada implements Serializable {
    @Column(name =     "dataEmissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name =     "dataSaida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNfEntrada")
    private Integer idNfEntrada;
    @Column(name = "numero")
    private String numero;
    @Column(name = "especie")
    private String especie;
    @Column(name = "serie")
    private String serie;
    @Column(name = "subSerie")
    private String subSerie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorProdutos")
    private Float valorProdutos;
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Column(name = "docentrada_idDocEntrada")
    private int docentrada;
    @Lob
    @Column(name = "arquivonfe")
    private byte[] arquivonfe;


    public Nfentrada() {
    }

    public Nfentrada(Integer idNfEntrada) {
        this.idNfEntrada = idNfEntrada;
    }

    public Integer getIdNfEntrada() {
        return idNfEntrada;
    }

    public void setIdNfEntrada(Integer idNfEntrada) {
        this.idNfEntrada = idNfEntrada;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public byte[] getArquivonfe() {
        return arquivonfe;
    }

    public void setArquivonfe(byte[] arquivonfe) {
        this.arquivonfe = arquivonfe;
    }

    public String getSubSerie() {
        return subSerie;
    }

    public void setSubSerie(String subSerie) {
        this.subSerie = subSerie;
    }

    public Float getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Float valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNfEntrada != null ? idNfEntrada.hashCode() : 0);
        return hash;
    }

    public int getDocentrada() {
        return docentrada;
    }

    public void setDocentrada(int docentrada) {
        this.docentrada = docentrada;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfentrada)) {
            return false;
        }
        Nfentrada other = (Nfentrada) object;
        if ((this.idNfEntrada == null && other.idNfEntrada != null) || (this.idNfEntrada != null && !this.idNfEntrada.equals(other.idNfEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nfentrada[ idNfEntrada=" + idNfEntrada + " ]";
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
}
