/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.ClienteController;
import Regras.VendedorController;
import model.Cliente;
import model.Creditosreceber;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class CreditoBean {
    
    private Creditosreceber  credito;
    private String nomeCliente;
    private String nomeVendedor;
    private String marcado;
    private String utilizado;
    

    public CreditoBean(Creditosreceber credito) {
        this.credito = credito;
        localizarCliente();
        localizarVendedor();
        setMarcado("NAO");
        if (credito.getContasreceberpagamento()==1){
            setUtilizado("NAO");
        }else {
            setUtilizado("SIM");
        }
    }

    public Creditosreceber getCredito() {
        return credito;
    }

    public void setCredito(Creditosreceber credito) {
        this.credito = credito;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getMarcado() {
        return marcado;
    }

    public void setMarcado(String marcado) {
        this.marcado = marcado;
    }

    public String getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(String utilizado) {
        this.utilizado = utilizado;
    }


    
    
    public void localizarCliente(){
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();
        cliente = clienteController.consultarClienteId(credito.getCliente());
        if (cliente!=null){
            setNomeCliente(cliente.getNome());
        }
    }
    
    public void localizarVendedor(){
        VendedorController vendedorController = new VendedorController();
        Vendedor vendedor = new Vendedor();
        vendedor = vendedorController.consultarVendedorId(credito.getVendedor());
        if (vendedor !=null){
            setNomeVendedor(vendedor.getNome());
        }
    }
    
    
    
}
