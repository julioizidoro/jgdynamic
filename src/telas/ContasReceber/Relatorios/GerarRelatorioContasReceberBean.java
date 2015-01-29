/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.Relatorios;

import Regras.ContasReceberController;
import java.util.ArrayList;
import java.util.List;
import model.View.Viewrelatoriocreditotodas;
import model.View.Viewrelcontasrecebertodas;



/**
 *
 * @author Wolverine
 */
public class GerarRelatorioContasReceberBean {
    
    private List<RelContasReceberTodas> listaTodas;

    public GerarRelatorioContasReceberBean() {
        this.listaTodas = new ArrayList<RelContasReceberTodas>();
    }

    public List<RelContasReceberTodas> getListaTodas() {
        return listaTodas;
    }

    public void setListaTodas(List<RelContasReceberTodas> listaTodas) {
        this.listaTodas = listaTodas;
    }
    
    
    
    public void gerarRelatorioTodas(int idEmpresa){
        ContasReceberController contasReceberController = new ContasReceberController();
        List<Viewrelcontasrecebertodas> listaContas = contasReceberController.listarContasReceberTodas(idEmpresa);
        if (listaContas!=null){
            for(int i=0;i<listaContas.size();i++){
                RelContasReceberTodas conta = new RelContasReceberTodas();
                conta.setDataConta(listaContas.get(i).getDataLancamento());
                conta.setDiaFechamento(listaContas.get(i).getDiaPagamento());
                conta.setDiasAtraso(listaContas.get(i).getDiasAtraso());
                conta.setFormaPagamento(listaContas.get(i).getFormaPagamento());
                conta.setIdCliente(listaContas.get(i).getClienteIdcliente());
                conta.setNomeCliente(listaContas.get(i).getNome());
                conta.setTelefone01(listaContas.get(i).getFoneFixo());
                conta.setTelefone02(listaContas.get(i).getFoneCelular());
                conta.setValorConta(listaContas.get(i).getValorConta().floatValue());
                Viewrelatoriocreditotodas credito = contasReceberController.listarCreditosReceberTodas(listaContas.get(i).getClienteIdcliente());
                if (credito!=null){
                    conta.setValorCredito(credito.getValorCredito().floatValue());
                }else conta.setValorCredito(0.0f);
                conta.setValorDevido(conta.getValorConta() - conta.getValorCredito());
                listaTodas.add(conta);
            }
        }
    }
}
