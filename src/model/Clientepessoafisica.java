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
@Table(name = "clientepessoafisica")
@NamedQueries({
    @NamedQuery(name = "Clientepessoafisica.findAll", query = "SELECT c FROM Clientepessoafisica c")})
public class Clientepessoafisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclientePessoaFisica")
    private Integer idclientePessoaFisica;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "localTrabalho")
    private String localTrabalho;
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
    @Column(name = "telefoneComercial")
    private String telefoneComercial;
    @Column(name = "refNome01")
    private String refNome01;
    @Column(name = "reffone01")
    private String reffone01;
    @Column(name = "refNome02")
    private String refNome02;
    @Column(name = "refFone02")
    private String refFone02;
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Column(name = "nomeConjuge")
    private String nomeConjuge;
    @Column(name = "cpfConjuge")
    private String cpfConjuge;
    @Column(name = "nomeMae")
    private String nomeMae;
    @Column(name = "nomePai")
    private String nomePai;
    @Column(name = "foneConjuge")
    private String foneConjuge;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "cliente_idcliente")
    private int clienteIdcliente;

    public Clientepessoafisica() {
    }

    public Clientepessoafisica(Integer idclientePessoaFisica) {
        this.idclientePessoaFisica = idclientePessoaFisica;
    }

    public Clientepessoafisica(Integer idclientePessoaFisica, int clienteIdcliente) {
        this.idclientePessoaFisica = idclientePessoaFisica;
        this.clienteIdcliente = clienteIdcliente;
    }

    public Integer getIdclientePessoaFisica() {
        return idclientePessoaFisica;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setIdclientePessoaFisica(Integer idclientePessoaFisica) {
        this.idclientePessoaFisica = idclientePessoaFisica;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
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

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getRefNome01() {
        return refNome01;
    }

    public void setRefNome01(String refNome01) {
        this.refNome01 = refNome01;
    }

    public String getReffone01() {
        return reffone01;
    }

    public void setReffone01(String reffone01) {
        this.reffone01 = reffone01;
    }

    public String getRefNome02() {
        return refNome02;
    }

    public void setRefNome02(String refNome02) {
        this.refNome02 = refNome02;
    }

    public String getRefFone02() {
        return refFone02;
    }

    public void setRefFone02(String refFone02) {
        this.refFone02 = refFone02;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeConjuge() {
        return nomeConjuge;
    }

    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    public String getCpfConjuge() {
        return cpfConjuge;
    }

    public void setCpfConjuge(String cpfConjuge) {
        this.cpfConjuge = cpfConjuge;
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

    public String getFoneConjuge() {
        return foneConjuge;
    }

    public void setFoneConjuge(String foneConjuge) {
        this.foneConjuge = foneConjuge;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        hash += (idclientePessoaFisica != null ? idclientePessoaFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientepessoafisica)) {
            return false;
        }
        Clientepessoafisica other = (Clientepessoafisica) object;
        if ((this.idclientePessoaFisica == null && other.idclientePessoaFisica != null) || (this.idclientePessoaFisica != null && !this.idclientePessoaFisica.equals(other.idclientePessoaFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientepessoafisica[ idclientePessoaFisica=" + idclientePessoaFisica + " ]";
    }
    
}
