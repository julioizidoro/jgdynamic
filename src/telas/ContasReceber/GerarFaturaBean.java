/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.ClienteController;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Clientefechamento;
import model.Contasreceber;
import model.Faturasreceber;


/**
 *
 * @author Wolverine
 */
public class GerarFaturaBean {
    
    Cliente cliente;
    Clientefechamento clienteFechamento;
    List<Contasreceber> listaContas;
    
    Faturasreceber fatura;

    public GerarFaturaBean(Cliente cliente, List<Contasreceber> listaContas) {
        if (cliente!=null){
            setListaContas(listaContas);
            setCliente(cliente);
            ClienteController clienteController = new ClienteController();
            setClienteFechamento(clienteController.consultarClienteFechamento(getCliente().getIdcliente()));
            listaContas = new ArrayList<Contasreceber>();
            fatura = new Faturasreceber();
        }
    }

    
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clientefechamento getClienteFechamento() {
        return clienteFechamento;
    }

    public void setClienteFechamento(Clientefechamento clienteFechamento) {
        this.clienteFechamento = clienteFechamento;
    }

    public Faturasreceber getFatura() {
        return fatura;
    }

    public void setFatura(Faturasreceber fatura) {
        this.fatura = fatura;
    }

    public List<Contasreceber> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Contasreceber> listaContas) {
        this.listaContas = listaContas;
    }

}
