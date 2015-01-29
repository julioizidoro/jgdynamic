/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "viewdevolucaodefeitoenviadas")
public class Viewdevolucaodefeitoenviadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "idfornecedor")
    private int idfornecedor;
    @Column(name = "idenvioDevolucaoDefeito")
    @Id
    private int idenvioDevolucaoDefeito;

    public Viewdevolucaodefeitoenviadas() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

   

    public int getIdenvioDevolucaoDefeito() {
        return idenvioDevolucaoDefeito;
    }

    public void setIdenvioDevolucaoDefeito(int idenvioDevolucaoDefeito) {
        this.idenvioDevolucaoDefeito = idenvioDevolucaoDefeito;
    }

   
    
}
