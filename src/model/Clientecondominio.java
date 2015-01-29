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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "clientecondominio")
@NamedQueries({
    @NamedQuery(name = "Clientecondominio.findAll", query = "SELECT c FROM Clientecondominio c")})
public class Clientecondominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteCondominio")
    private Integer idclienteCondominio;
    @Column(name = "tipoLogradouro")
    private String tipoLogradouro;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "dataPosse")
    @Temporal(TemporalType.DATE)
    private Date dataPosse;
    @Column(name = "dataFimMandato")
    @Temporal(TemporalType.DATE)
    private Date dataFimMandato;
    @Column(name = "nomeContato")
    private String nomeContato;
    @Column(name = "foneContato")
    private String foneContato;
    @Column(name = "dataAberturaConta")
    @Temporal(TemporalType.DATE)
    private Date dataAberturaConta;
    @Column(name = "nomeSindico")
    private String nomeSindico;
    @Column(name = "cpfSindico")
    private String cpfSindico;
    @Column(name = "foneSindico")
    private String foneSindico;
    @Column(name = "emailSindico")
    private String emailSindico;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clientecondominio() {
    }

    public Clientecondominio(Integer idclienteCondominio) {
        this.idclienteCondominio = idclienteCondominio;
    }

    public Clientecondominio(Integer idclienteCondominio, int clienteIdcliente) {
        this.idclienteCondominio = idclienteCondominio;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclienteCondominio() {
        return idclienteCondominio;
    }

    public void setIdclienteCondominio(Integer idclienteCondominio) {
        this.idclienteCondominio = idclienteCondominio;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDataPosse() {
        return dataPosse;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }

    public Date getDataFimMandato() {
        return dataFimMandato;
    }

    public void setDataFimMandato(Date dataFimMandato) {
        this.dataFimMandato = dataFimMandato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public Date getDataAberturaConta() {
        return dataAberturaConta;
    }

    public void setDataAberturaConta(Date dataAberturaConta) {
        this.dataAberturaConta = dataAberturaConta;
    }

    public String getNomeSindico() {
        return nomeSindico;
    }

    public void setNomeSindico(String nomeSindico) {
        this.nomeSindico = nomeSindico;
    }

    public String getCpfSindico() {
        return cpfSindico;
    }

    public void setCpfSindico(String cpfSindico) {
        this.cpfSindico = cpfSindico;
    }

    public String getFoneSindico() {
        return foneSindico;
    }

    public void setFoneSindico(String foneSindico) {
        this.foneSindico = foneSindico;
    }

    public String getEmailSindico() {
        return emailSindico;
    }

    public void setEmailSindico(String emailSindico) {
        this.emailSindico = emailSindico;
    }

    public int getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(int clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteCondominio != null ? idclienteCondominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientecondominio)) {
            return false;
        }
        Clientecondominio other = (Clientecondominio) object;
        if ((this.idclienteCondominio == null && other.idclienteCondominio != null) || (this.idclienteCondominio != null && !this.idclienteCondominio.equals(other.idclienteCondominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientecondominio[ idclienteCondominio=" + idclienteCondominio + " ]";
    }
    
}
