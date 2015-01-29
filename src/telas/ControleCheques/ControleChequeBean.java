/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ControleCheques;

import model.Cliente;
import model.Controlecheques;

/**
 *
 * @author wolverine
 */
public class ControleChequeBean {
    
    private Controlecheques cheque;
    private Cliente cliente;
    private String marcado;

    public ControleChequeBean() {
        this.marcado = "NÃO";
    }
    
    

    public Controlecheques getCheque() {
        return cheque;
    }

    public void setCheque(Controlecheques cheque) {
        this.cheque = cheque;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMarcado() {
        return marcado;
    }

    public void setMarcado(String marcado) {
        this.marcado = marcado;
    }
    
    
    
    
}
