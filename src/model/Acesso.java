/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "acesso")
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
    @Column(name = "contasPagar")
    private Integer contasPagar;
    @Column(name = "cpAdicionar")
    private Integer cpAdicionar;
    @Column(name = "cpEditar")
    private Integer cpEditar;
    @Column(name = "cpExcluir")
    private Integer cpExcluir;
    @Column(name = "cpPagar")
    private Integer cpPagar;
    @Column(name = "cliente")
    private Integer cliente;
    @Column(name = "clienteAdicionar")
    private Integer clienteAdicionar;
    @Column(name = "clienteEditar")
    private Integer clienteEditar;
    @Column(name = "clienteExcluir")
    private Integer clienteExcluir;
    @Column(name = "clienteAutoriza")
    private Integer clienteAutoriza;
    @Column(name = "clienteDocumentos")
    private Integer clienteDocumentos;
    @Column(name = "clienteEntrega")
    private Integer clienteEntrega;
    @Column(name = "clienteAutorizadoAdicionar")
    private Integer clienteAutorizadoAdicionar;
    @Column(name = "clienteAutorizadoExcluir")
    private Integer clienteAutorizadoExcluir;
    @Column(name = "clienteEntregaAdicionar")
    private Integer clienteEntregaAdicionar;
    @Column(name = "clienteEntregaExcluir")
    private Integer clienteEntregaExcluir;
    @Column(name = "clienteHistorico")
    private Integer clienteHistorico;
    @Column(name = "clienteHistoricoAdicionar")
    private Integer clienteHistoricoAdicionar;
    @Column(name = "clienteHistoricoExcluir")
    private Integer clienteHistoricoExcluir;
     @Column(name = "contasReceber")
    private Integer contasReceber;
      @Column(name = "crAdicionar")
    private Integer crAdicionar;
    @Column(name = "crEditar")
    private Integer crEditar;
    @Column(name = "crRecebimentos")
    private Integer crRecebimentos;
    @Column(name = "crFatura")
    private Integer crFatura;
    @Column(name = "crGerarFatura")
    private Integer crGerarFatura;
    @Column(name = "crExcluirFatura")
    private Integer crExcluirFatura;
    @Column(name = "crImprimirFatura")
    private Integer crImprimirFatura;
    @Column(name = "vCartao")
    private Integer vCartao;
    @Column(name = "vValores")
    private Integer vValores;
    @Column(name = "vOperacao")
    private Integer vOperacao;
    @Column(name = "crExcluirConta")
    private Integer crExcluirConta;
    @Column(name = "liberarCliente")
    private Integer liberarCliente;
    
    
    @Column(name = "usuario_idusuario")
    private int usuarios;

    public Acesso() {
    }

    public Acesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getIdacesso() {
        return idacesso;
    }

    public void setIdacesso(Integer idacesso) {
        this.idacesso = idacesso;
    }

    public Integer getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(Integer contasPagar) {
        this.contasPagar = contasPagar;
    }

    public Integer getCpAdicionar() {
        return cpAdicionar;
    }

    public Integer getCrRecebimentos() {
        return crRecebimentos;
    }

    public Integer getLiberarCliente() {
        return liberarCliente;
    }

    public void setLiberarCliente(Integer liberarCliente) {
        this.liberarCliente = liberarCliente;
    }

    public void setCrRecebimentos(Integer crRecebimentos) {
        this.crRecebimentos = crRecebimentos;
    }

    public Integer getvCartao() {
        return vCartao;
    }

    public void setvCartao(Integer vCartao) {
        this.vCartao = vCartao;
    }

    public Integer getvValores() {
        return vValores;
    }

    public void setvValores(Integer vValores) {
        this.vValores = vValores;
    }

    public Integer getvOperacao() {
        return vOperacao;
    }

    public void setvOperacao(Integer vOperacao) {
        this.vOperacao = vOperacao;
    }

    public void setCpAdicionar(Integer cpAdicionar) {
        this.cpAdicionar = cpAdicionar;
    }

    public Integer getContasReceber() {
        return contasReceber;
    }

    public void setContasReceber(Integer contasReceber) {
        this.contasReceber = contasReceber;
    }

    public Integer getCrAdicionar() {
        return crAdicionar;
    }

    public void setCrAdicionar(Integer crAdicionar) {
        this.crAdicionar = crAdicionar;
    }

    public Integer getCrEditar() {
        return crEditar;
    }

    public void setCrEditar(Integer crEditar) {
        this.crEditar = crEditar;
    }

    public Integer getCpEditar() {
        return cpEditar;
    }

    public void setCpEditar(Integer cpEditar) {
        this.cpEditar = cpEditar;
    }

    public Integer getCrExcluirFatura() {
        return crExcluirFatura;
    }

    public void setCrExcluirFatura(Integer crExcluirFatura) {
        this.crExcluirFatura = crExcluirFatura;
    }

    public Integer getCrFatura() {
        return crFatura;
    }

    public void setCrFatura(Integer crFatura) {
        this.crFatura = crFatura;
    }

    public Integer getCrGerarFatura() {
        return crGerarFatura;
    }

    public void setCrGerarFatura(Integer crGerarFatura) {
        this.crGerarFatura = crGerarFatura;
    }

    public Integer getCrImprimirFatura() {
        return crImprimirFatura;
    }

    public void setCrImprimirFatura(Integer crImprimirFatura) {
        this.crImprimirFatura = crImprimirFatura;
    }

    public Integer getCpExcluir() {
        return cpExcluir;
    }

    public void setCpExcluir(Integer cpExcluir) {
        this.cpExcluir = cpExcluir;
    }

    public Integer getCpPagar() {
        return cpPagar;
    }

    public void setCpPagar(Integer cpPagar) {
        this.cpPagar = cpPagar;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getClienteAdicionar() {
        return clienteAdicionar;
    }

    public void setClienteAdicionar(Integer clienteAdicionar) {
        this.clienteAdicionar = clienteAdicionar;
    }

    public Integer getClienteEditar() {
        return clienteEditar;
    }

    public void setClienteEditar(Integer clienteEditar) {
        this.clienteEditar = clienteEditar;
    }

    public Integer getClienteExcluir() {
        return clienteExcluir;
    }

    public void setClienteExcluir(Integer clienteExcluir) {
        this.clienteExcluir = clienteExcluir;
    }

    public Integer getClienteAutoriza() {
        return clienteAutoriza;
    }

    public void setClienteAutoriza(Integer clienteAutoriza) {
        this.clienteAutoriza = clienteAutoriza;
    }

    public Integer getClienteDocumentos() {
        return clienteDocumentos;
    }

    public void setClienteDocumentos(Integer clienteDocumentos) {
        this.clienteDocumentos = clienteDocumentos;
    }

    public Integer getClienteEntrega() {
        return clienteEntrega;
    }

    public void setClienteEntrega(Integer clienteEntrega) {
        this.clienteEntrega = clienteEntrega;
    }

    public Integer getClienteAutorizadoAdicionar() {
        return clienteAutorizadoAdicionar;
    }

    public void setClienteAutorizadoAdicionar(Integer clienteAutorizadoAdicionar) {
        this.clienteAutorizadoAdicionar = clienteAutorizadoAdicionar;
    }

    public Integer getClienteAutorizadoExcluir() {
        return clienteAutorizadoExcluir;
    }

    public void setClienteAutorizadoExcluir(Integer clienteAutorizadoExcluir) {
        this.clienteAutorizadoExcluir = clienteAutorizadoExcluir;
    }

    public Integer getClienteEntregaAdicionar() {
        return clienteEntregaAdicionar;
    }

    public void setClienteEntregaAdicionar(Integer clienteEntregaAdicionar) {
        this.clienteEntregaAdicionar = clienteEntregaAdicionar;
    }

    public Integer getClienteEntregaExcluir() {
        return clienteEntregaExcluir;
    }

    public void setClienteEntregaExcluir(Integer clienteEntregaExcluir) {
        this.clienteEntregaExcluir = clienteEntregaExcluir;
    }

    public Integer getClienteHistorico() {
        return clienteHistorico;
    }

    public void setClienteHistorico(Integer clienteHistorico) {
        this.clienteHistorico = clienteHistorico;
    }

    public Integer getClienteHistoricoAdicionar() {
        return clienteHistoricoAdicionar;
    }

    public void setClienteHistoricoAdicionar(Integer clienteHistoricoAdicionar) {
        this.clienteHistoricoAdicionar = clienteHistoricoAdicionar;
    }

    public Integer getClienteHistoricoExcluir() {
        return clienteHistoricoExcluir;
    }

    public void setClienteHistoricoExcluir(Integer clienteHistoricoExcluir) {
        this.clienteHistoricoExcluir = clienteHistoricoExcluir;
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getCrExcluirConta() {
        return crExcluirConta;
    }

    public void setCrExcluirConta(Integer crExcluirConta) {
        this.crExcluirConta = crExcluirConta;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacesso != null ? idacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.idacesso == null && other.idacesso != null) || (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acesso[ idacesso=" + idacesso + " ]";
    }
    
}
