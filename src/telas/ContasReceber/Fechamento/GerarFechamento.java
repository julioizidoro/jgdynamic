/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber.Fechamento;

import Regras.ContasReceberController;
import Regras.CreditoReceberController;
import Regras.FechamentoContasReceberController;
import Regras.Formatacao;
import controler.Config;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Contasreceber;
import model.Creditosreceber;
import model.FechamentoCliente;
import model.FechamentoMes;


/**
 *
 * @author wolverine
 */
public class GerarFechamento {
    
    private FechamentoMes fechamentoMes;
    private List<FechamentoCliente> listaCliente;
    private String ano;
    private String mes;
    private String nomeUsuario;
    private Config config;

    public GerarFechamento(String ano, String mes, String nomeUsuario, Config config) {
        this.ano = ano;
        this.nomeUsuario = nomeUsuario;
        this.mes = mes;
        this.config = config;
        verificarFechamentoMes();
    }
    
    
    public void gravaFechamentoMes(){
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        fechamentoMes = new FechamentoMes();
        fechamentoMes.setDataGeracao(new Date());
        fechamentoMes.setMes(mes + "/" + ano);
        fechamentoMes.setUsuario(nomeUsuario);
        fechamentoMes.setEmpresa(config.getEmpresa().getIdempresa());
        fechamentoMes = fechamentoContasReceberController.salvarFechamentoMes(fechamentoMes);
    }
    

    public void gerarContasReceber() {
        ContasReceberController contasReceberController = new ContasReceberController();
        String data = ano + '-' + Formatacao.retornaDataFinal(Integer.parseInt(mes));
        String sql = "select c from Contasreceber c where c.contasreceberpagamento=1  and c.dataVencimento<='" + data + "' order by c.cliente, c.dataVencimento";
        List<Contasreceber> listaReceber = contasReceberController.listarContas(sql);
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        FechamentoCliente fc = null;
        if (listaReceber != null) {
            for (int i = 0; i < listaReceber.size(); i++) {
                fc = fechamentoContasReceberController.consultarFechamentoCliente(listaReceber.get(i).getCliente().getIdcliente(), this.fechamentoMes.getIdfechamentoMes());
                if (fc==null){
                    fc = new FechamentoCliente();
                    fc.setCliente(listaReceber.get(i).getCliente().getIdcliente());
                    fc.setDataVencimento(listaReceber.get(i).getDataVencimento());
                    fc.setValorConta(listaReceber.get(i).getValorConta().floatValue());
                    fc.setFechamentoMes(this.fechamentoMes.getIdfechamentoMes());
                }else {
                    fc.setValorConta(fc.getValorConta() + listaReceber.get(i).getValorConta().floatValue());
                }
                fechamentoContasReceberController.salvarFechamentoCliente(fc);
            }
        }
    }
    
    

    
    public void gerarCreditosCliente(){
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        listaCliente = fechamentoContasReceberController.ListaFechamentoCliente(fechamentoMes.getIdfechamentoMes());
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        if (listaCliente!=null){
            for(int i=0;i<listaCliente.size();i++){
                float valor =0;
                String sqlCredito = " select c from Creditosreceber c where c.contasreceberpagamento=1 and c.dataLancamento<='" + this.ano + "-" + 
                        Formatacao.retornaDataFinal(Integer.parseInt(mes)) + "' and c.cliente=" + listaCliente.get(i).getCliente();
                List<Creditosreceber> listaCredito = creditoReceberController.listarCreditos(sqlCredito);
                if (listaCredito!=null){
                    for(int c=0;c<listaCredito.size();c++){
                        valor+= listaCredito.get(c).getValorCredito();
                    }
                    listaCliente.get(i).setValorCredito(valor);
                }
            }
        }
        
    }
    
    public void calcularValoresFechamento(){
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        String dataFinal = ano + "/" +  Formatacao.retornaDataFinalBarras(Integer.parseInt(mes));
        if(listaCliente!=null){
            for(int i=0;i<listaCliente.size();i++){
                float valorPagar = listaCliente.get(i).getValorConta() - listaCliente.get(i).getValorCredito();
                listaCliente.get(i).setValorPagar(valorPagar);
                int diasAtraso = Formatacao.subtrairDatas(new Date(), listaCliente.get(i).getDataVencimento());///calcularDiasAtraso(Formatacao.ConvercaoDataSql(listaCliente.get(i).getDataVencimento()), dataFinal);
                listaCliente.get(i).setDiasAtraso(diasAtraso);
                fechamentoContasReceberController.salvarFechamentoCliente(listaCliente.get(i));
            }
        }
    }
    
    
    public void verificarFechamentoMes(){
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        FechamentoMes fm = fechamentoContasReceberController.consultaFechamentoMes(mes +"/" + ano);
        if (fm!=null){
            boolean resultado = JOptionPane.showConfirmDialog(null, "Mês já Gerardo. Regerar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
            if (resultado){
                this.fechamentoMes = fm;
                apagarFechamentoCliente();
                iniciarFechamentoCliente();
            }else {
                JOptionPane.showMessageDialog(null, "Fechamento cancelado");   
            }
        }else {
            gravaFechamentoMes();
            iniciarFechamentoCliente();
        }
    }
    
    public void apagarFechamentoCliente(){
        FechamentoContasReceberController fechamentoContasReceberController = new FechamentoContasReceberController();
        listaCliente = fechamentoContasReceberController.ListaFechamentoCliente(this.fechamentoMes.getIdfechamentoMes());
        if (listaCliente!=null){
            for (int i=0;i<listaCliente.size();i++){
                fechamentoContasReceberController.apagarFechamentoCliente(listaCliente.get(i));
            }
            listaCliente = null;
        }
    }
    
    public void iniciarFechamentoCliente(){
        gerarContasReceber();
        gerarCreditosCliente();
        calcularValoresFechamento();
        JOptionPane.showMessageDialog(null, "Fechamento Gerado com Sucesso");
    }
    
//    public int calcularDiasAtraso(String dataVencimento, String dataMes){
//        String dados = dataVencimento.substring(0,4);
//        int anoVencimento = Integer.parseInt(dados);
//        dados = dataVencimento.substring(5,7);
//        int mesVencimento = Integer.parseInt(dados);
//        dados = dataVencimento.substring(8);
//        int diaVencimento = Integer.parseInt(dados);
//        
//        dados = dataMes.substring(0,4);
//        int anoAtual = Integer.parseInt(dados);
//        dados = dataMes.substring(5,7);
//        int mesAtual = Integer.parseInt(dados);
//        dados = dataMes.substring(8);
//        int diaAtual = Integer.parseInt(dados);
//        
//        //Calcula anos em dias
//        if (anoAtual>anoVencimento){
//            anoAtual = anoAtual - anoVencimento;
//        }else {
//            anoAtual=0;
//        }
//        
//        //Calcula mes em dias
//        if (mesAtual> mesVencimento){
//            mesAtual = mesAtual - mesVencimento;
//        }else {
//            mesAtual = mesVencimento;
//            anoAtual = anoAtual -1;
//        }
//        
//        //Calcular dias
//        if (diaAtual>diaVencimento){
//            diaAtual = diaAtual - diaVencimento;
//        }else {
//            diaAtual = 30 - (diaVencimento - diaAtual);
//            mesAtual = mesAtual - 1;
//        }
//        int dias =0;
//        
//        if (anoAtual>0){
//            dias+=(anoAtual*365);
//        }
//        
//        if (mesAtual>0){
//            dias+=(mesAtual*30);
//        }
//        
//        if (diaAtual>0){
//            dias+=diaAtual;
//        }
//        return  dias;
//    }
}    
   
