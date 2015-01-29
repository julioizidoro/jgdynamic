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
@Table(name = "clientepessoajuridica")
@NamedQueries({
    @NamedQuery(name = "Clientepessoajuridica.findAll", query = "SELECT c FROM Clientepessoajuridica c")})
public class Clientepessoajuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclientePessoaJuridica")
    private Integer idclientePessoaJuridica;
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
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "dataFundacao")
    @Temporal(TemporalType.DATE)
    private Date dataFundacao;
    @Column(name = "nomeContato")
    private String nomeContato;
    @Column(name = "telefoneContato")
    private String telefoneContato;
    @Column(name = "socioResponsavel")
    private Integer socioResponsavel;
    @Column(name = "telefoneSocio")
    private String telefoneSocio;
    @Column(name = "emailSocio")
    private String emailSocio;
    @Column(name = "nomeMae")
    private String nomeMae;
    @Column(name = "nomePai")
    private String nomePai;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clientepessoajuridica() {
    }

    public Clientepessoajuridica(Integer idclientePessoaJuridica) {
        this.idclientePessoaJuridica = idclientePessoaJuridica;
    }

    public Clientepessoajuridica(Integer idclientePessoaJuridica, int clienteIdcliente) {
        this.idclientePessoaJuridica = idclientePessoaJuridica;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclientePessoaJuridica() {
        return idclientePessoaJuridica;
    }

    public void setIdclientePessoaJuridica(Integer idclientePessoaJuridica) {
        this.idclientePessoaJuridica = idclientePessoaJuridica;
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public Integer getSocioResponsavel() {
        return socioResponsavel;
    }

    public void setSocioResponsavel(Integer socioResponsavel) {
        this.socioResponsavel = socioResponsavel;
    }

    public String getTelefoneSocio() {
        return telefoneSocio;
    }

    public void setTelefoneSocio(String telefoneSocio) {
        this.telefoneSocio = telefoneSocio;
    }

    public String getEmailSocio() {
        return emailSocio;
    }

    public void setEmailSocio(String emailSocio) {
        this.emailSocio = emailSocio;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
        hash += (idclientePessoaJuridica != null ? idclientePessoaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientepessoajuridica)) {
            return false;
        }
        Clientepessoajuridica other = (Clientepessoajuridica) object;
        if ((this.idclientePessoaJuridica == null && other.idclientePessoaJuridica != null) || (this.idclientePessoaJuridica != null && !this.idclientePessoaJuridica.equals(other.idclientePessoaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientepessoajuridica[ idclientePessoaJuridica=" + idclientePessoaJuridica + " ]";
    }
    
}
