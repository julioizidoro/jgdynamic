/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "notasaida")
public class Notasaida implements Serializable {
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
    @Column(name = "despesasacessorias")
    private Float despesasacessorias;
    @Lob
    @Column(name = "xml")
    private byte[] xml;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "nomeArquivoXML")
    private String nomeArquivoXML;
    @Column(name = "chaveAutorizacao")
    private String chaveAutorizacao;
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "idfornecedor")
    private Integer idfornecedor;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "ie")
    private String ie;
    @Column(name = "contribuinteicms")
    private Integer contribuinteicms;
    @Column(name = "fonefixo")
    private String fonefixo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;
    @Column(name = "logradouro")
    private String logradouro;
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
    @Column(name = "codigocidade")
    private String codigocidade;
    @Column(name = "condicaopagamento")
    private String condicaopagamento;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "usuarios_idusuarios")
    private int usuarios;
    @Column(name = "motivocancelamento")
    private String motivocancelamento;
    @Lob
    @Column(name = "xmlcancelada")
    private byte[] xmlcancelada;
    @Column(name = "nomearquivocancelada")
    private String nomearquivocancelada;
    @Column(name = "datacorrecao")
    private String datacorrecao;
    @Column(name = "protocolo")
    private String protocolo;
    @Column(name = "evento")
    private String evento;

    public Notasaida() {
    }

    public Notasaida(Integer idnotaSaida) {
        this.idnotaSaida = idnotaSaida;
    }

    public Integer getIdnotaSaida() {
        return idnotaSaida;
    }

    public void setIdnotaSaida(Integer idnotaSaida) {
        this.idnotaSaida = idnotaSaida;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public String getNomearquivocancelada() {
        return nomearquivocancelada;
    }

    public void setNomearquivocancelada(String nomearquivocancelada) {
        this.nomearquivocancelada = nomearquivocancelada;
    }

   
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getEmpresa() {
        return empresa;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public Float getDespesasacessorias() {
        return despesasacessorias;
    }

    public void setDespesasacessorias(Float despesasacessorias) {
        this.despesasacessorias = despesasacessorias;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getNumero() {
        return numero;
    }

    public byte[] getXmlcancelada() {
        return xmlcancelada;
    }

    public void setXmlcancelada(byte[] xmlcancelada) {
        this.xmlcancelada = xmlcancelada;
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

    public void setXml(byte[] xml) {
        this.xml = xml;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNomeArquivoXML() {
        return nomeArquivoXML;
    }

    public void setNomeArquivoXML(String nomeArquivoXML) {
        this.nomeArquivoXML = nomeArquivoXML;
    }

    public String getChaveAutorizacao() {
        return chaveAutorizacao;
    }

    public void setChaveAutorizacao(String chaveAutorizacao) {
        this.chaveAutorizacao = chaveAutorizacao;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public Integer getContribuinteicms() {
        return contribuinteicms;
    }

    public void setContribuinteicms(Integer contribuinteicms) {
        this.contribuinteicms = contribuinteicms;
    }

    public String getFonefixo() {
        return fonefixo;
    }

    public void setFonefixo(String fonefixo) {
        this.fonefixo = fonefixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getCodigocidade() {
        return codigocidade;
    }

    public void setCodigocidade(String codigocidade) {
        this.codigocidade = codigocidade;
    }

    public String getCondicaopagamento() {
        return condicaopagamento;
    }

    public void setCondicaopagamento(String condicaopagamento) {
        this.condicaopagamento = condicaopagamento;
    }

    public String getDatacorrecao() {
        return datacorrecao;
    }

    public void setDatacorrecao(String datacorrecao) {
        this.datacorrecao = datacorrecao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
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
        if (!(object instanceof Notasaida)) {
            return false;
        }
        Notasaida other = (Notasaida) object;
        if ((this.idnotaSaida == null && other.idnotaSaida != null) || (this.idnotaSaida != null && !this.idnotaSaida.equals(other.idnotaSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Notasaida[ idnotaSaida=" + idnotaSaida + " ]";
    }
    
}
