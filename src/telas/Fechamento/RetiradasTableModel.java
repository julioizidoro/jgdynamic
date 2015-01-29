/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Fechamento;

import Regras.Formatacao;
import Regras.PlanoContaController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Planoconta;
import model.Retirada;

/**
 *
 * @author Wolverine
 */
public class RetiradasTableModel extends AbstractTableModel{
    
    public List<Retirada> listaRetirada;
    private String[] colunas = {"Valor Dinheiro", "Valor Cheque", "Valor Cheque Pré", "Total", "Conta", "Histórico"};

    public RetiradasTableModel(List<Retirada> listaRetirada) {
        this.listaRetirada = listaRetirada;
    }
    
    public int getRowCount() {
        return this.listaRetirada.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return Formatacao.foramtarFloatString(listaRetirada.get(rowIndex).getValorDinheiro());
        }else if (columnIndex==1){
            return Formatacao.foramtarFloatString(listaRetirada.get(rowIndex).getValorCheque());
        }else if (columnIndex==2){
            return Formatacao.foramtarFloatString(listaRetirada.get(rowIndex).getValorChequePre());
        }else if (columnIndex==3){
            return Formatacao.foramtarDoubleString(somarLinhaRetirada(rowIndex));
        }else if (columnIndex==4){
            return localizarPlanoConta(listaRetirada.get(rowIndex).getPlanoconta()).getNumeroConta();
        }else return listaRetirada.get(rowIndex).getHistorico();
    }
    
    public double somarListaRetirada(){
        double total = 0;
        for (int i=0;i<listaRetirada.size();i++){
            total = total + listaRetirada.get(i).getValorCheque() + listaRetirada.get(i).getValorChequePre() +
                    listaRetirada.get(i).getValorDinheiro();
        }
        return total;
    }
    
    public double somarLinhaRetirada(int linha){
        double valor = listaRetirada.get(linha).getValorCheque() + listaRetirada.get(linha).getValorChequePre()+
                listaRetirada.get(linha).getValorDinheiro();
        return valor;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
         }else if (columnIndex==1){
             return String.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }
    
    
    public Planoconta localizarPlanoConta(int idPlanoConta){
        PlanoContaController planoContaController = new PlanoContaController();
        return planoContaController.consultarPlanoconta(idPlanoConta);
    }
}
