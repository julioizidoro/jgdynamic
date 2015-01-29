/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.TransferenciaSaida;

import Regras.EmpresaController;
import Regras.ProdutoController;
import Regras.TransferenciaSaidaController;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import model.Saidatransferencia;
import model.Saidatransferenciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaProcesso {
    
    Saidatransferencia transferencia;
    Empresa empresaEmitente;
    Empresa empresaDestinatario;
    List<TransferenciaProdutoProcesso> listaProdutos;

    public TransferenciaProcesso() {
        listaProdutos = new ArrayList<TransferenciaProdutoProcesso>();
    }

    public TransferenciaProcesso(Saidatransferencia transferencia) {
        this.transferencia = transferencia;
        listaProdutos = new ArrayList<TransferenciaProdutoProcesso>();
        carregarEmpresas();
        carregarListaProdutos();
    }
    
    

    public Empresa getEmpresaDestinatario() {
        return empresaDestinatario;
    }

    public void setEmpresaDestinatario(Empresa empresaDestinatario) {
        this.empresaDestinatario = empresaDestinatario;
    }

    public Empresa getEmpresaEmitente() {
        return empresaEmitente;
    }

    public void setEmpresaEmitente(Empresa empresaEmitente) {
        this.empresaEmitente = empresaEmitente;
    }

    public List<TransferenciaProdutoProcesso> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<TransferenciaProdutoProcesso> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Saidatransferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Saidatransferencia transferencia) {
        this.transferencia = transferencia;
    }
    
    public void carregarEmpresas(){
        EmpresaController empresaController = new EmpresaController();
        empresaEmitente = empresaController.consultarEmpresa(transferencia.getEmpresaEmitente());
        empresaDestinatario = empresaController.consultarEmpresa(transferencia.getEmpresaDetinatario());
    }
    
    public void carregarListaProdutos(){
        TransferenciaSaidaController traferenciaSaidacontroller = new  TransferenciaSaidaController();
        ProdutoController produtoController = new ProdutoController();
        List<Saidatransferenciaproduto> listaTransferenciaProduto = traferenciaSaidacontroller.listaTransferenciaProduto(transferencia.getIdsaidaTransferencia());
        if (listaTransferenciaProduto!=null){
            for (int i=0;i<listaTransferenciaProduto.size();i++){
                TransferenciaProdutoProcesso transferenciaProdutoProcesso = new TransferenciaProdutoProcesso();
                transferenciaProdutoProcesso.setTransferenciaProduto(listaTransferenciaProduto.get(i));
                transferenciaProdutoProcesso.setProduto(produtoController.consultarProdutoid(listaTransferenciaProduto.get(i).getProduto()));
                listaProdutos.add(transferenciaProdutoProcesso);
            }
        }
    }
    
    
    
}
