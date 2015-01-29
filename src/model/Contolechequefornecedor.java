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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "contolechequefornecedor")
public class Contolechequefornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontoleChequeFornecedor")
    private Integer idcontoleChequeFornecedor;
    @Column(name = "dataFornecedor")
    @Temporal(TemporalType.DATE)
    private Date dataFornecedor;
    @Column(name = "fornecedor_idfornecedor")
    private int fornecedor;
    @Column(name = "controleCheques_idcontroleCheques")
    private int controlecheques;

    public Contolechequefornecedor() {
    }

    public Contolechequefornecedor(Integer idcontoleChequeFornecedor) {
        this.idcontoleChequeFornecedor = idcontoleChequeFornecedor;
    }

    public Integer getIdcontoleChequeFornecedor() {
        return idcontoleChequeFornecedor;
    }

    public void setIdcontoleChequeFornecedor(Integer idcontoleChequeFornecedor) {
        this.idcontoleChequeFornecedor = idcontoleChequeFornecedor;
    }

    public Date getDataFornecedor() {
        return dataFornecedor;
    }

    public void setDataFornecedor(Date dataFornecedor) {
        this.dataFornecedor = dataFornecedor;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getControlecheques() {
        return controlecheques;
    }

    public void setControlecheques(int controlecheques) {
        this.controlecheques = controlecheques;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontoleChequeFornecedor != null ? idcontoleChequeFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contolechequefornecedor)) {
            return false;
        }
        Contolechequefornecedor other = (Contolechequefornecedor) object;
        if ((this.idcontoleChequeFornecedor == null && other.idcontoleChequeFornecedor != null) || (this.idcontoleChequeFornecedor != null && !this.idcontoleChequeFornecedor.equals(other.idcontoleChequeFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contolechequefornecedor[ idcontoleChequeFornecedor=" + idcontoleChequeFornecedor + " ]";
    }
    
}
