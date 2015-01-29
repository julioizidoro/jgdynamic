/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewprodutoentrada")
public class Viewprodutoentrada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorTotalCusto")
    private Float valorTotalCusto;
    @Basic(optional = false)
    @Column(name = "idproduto")
    private int idproduto;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    @Column(name = "dataEntrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Basic(optional = false)
    @Column(name = "idEntradaProduto")
    @Id
    private int idEntradaProduto;

    public Viewprodutoentrada() {
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorTotalCusto() {
        return valorTotalCusto;
    }

    public void setValorTotalCusto(Float valorTotalCusto) {
        this.valorTotalCusto = valorTotalCusto;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getIdEntradaProduto() {
        return idEntradaProduto;
    }

    public void setIdEntradaProduto(int idEntradaProduto) {
        this.idEntradaProduto = idEntradaProduto;
    }
    
}
