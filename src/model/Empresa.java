/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Column(name = "idparametros")
    private Integer idparametros;
    @Column(name = "importacao")
    private Integer importacao;
    @Column(name = "numeroNFe")
    private Integer numeroNFe;
    @Column(name = "serieNFe")
    private Integer serieNFe;
    @Size(max = 100)
    @Column(name = "logocaminho")
    private String logocaminho;
    @Size(max = 6)
    @Column(name = "timeZona")
    private String timeZona;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempresa")
    private Integer idempresa;
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
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
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "uf")
    private String uf;
    @Column(name = "foneComercial")
    private String foneComercial;
    @Column(name = "foneFax")
    private String foneFax;
    @Column(name = "emailnfe")
    private String emailnfe;
    @Column(name = "emailcompras")
    private String emailcompras;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Column(name = "cnae")
    private String cnae;
    @Column(name = "crt")
    private String crt;
    @Column(name = "municipios_idmunicipios")
    private int municipios;
    
    
    public Empresa() {
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }


    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }


    public String getCnae() {
        return cnae;
    }


    

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }

    public int getMunicipios() {
        return municipios;
    }

    public void setMunicipios(int municipios) {
        this.municipios = municipios;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public String getFoneFax() {
        return foneFax;
    }

    public void setFoneFax(String foneFax) {
        this.foneFax = foneFax;
    }

    public String getEmailnfe() {
        return emailnfe;
    }

    public void setEmailnfe(String emailnfe) {
        this.emailnfe = emailnfe;
    }

    public String getEmailcompras() {
        return emailcompras;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setEmailcompras(String emailcompras) {
        this.emailcompras = emailcompras;
    }




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdempresa() + " - " + getRazaoSocial();
    }

    public Integer getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public Integer getImportacao() {
        return importacao;
    }

    public void setImportacao(Integer importacao) {
        this.importacao = importacao;
    }

    public Integer getNumeroNFe() {
        return numeroNFe;
    }

    public void setNumeroNFe(Integer numeroNFe) {
        this.numeroNFe = numeroNFe;
    }

    public Integer getSerieNFe() {
        return serieNFe;
    }

    public void setSerieNFe(Integer serieNFe) {
        this.serieNFe = serieNFe;
    }

    public String getLogocaminho() {
        return logocaminho;
    }

    public void setLogocaminho(String logocaminho) {
        this.logocaminho = logocaminho;
    }

    public String getTimeZona() {
        return timeZona;
    }

    public void setTimeZona(String timeZona) {
        this.timeZona = timeZona;
    }
}
