/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloParametros;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "parametros")
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")})
public class Parametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparametros")
    private Integer idparametros;
    @Column(name = "codigoProduto")
    private Integer codigoProduto;
    @Column(name = "codigoFornecedor")
    private Integer codigoFornecedor;
    @Column(name = "codigoArtesanato")
    private Integer codigoArtesanato;
   
    public Parametros() {
    }

    public Parametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public Integer getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

   

    public Integer getCodigoArtesanato() {
        return codigoArtesanato;
    }

    public void setCodigoArtesanato(Integer codigoArtesanato) {
        this.codigoArtesanato = codigoArtesanato;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametros != null ? idparametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.idparametros == null && other.idparametros != null) || (this.idparametros != null && !this.idparametros.equals(other.idparametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloParametros.Parametros[ idparametros=" + idparametros + " ]";
    }
    
}
