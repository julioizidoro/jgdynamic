/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Contasreceber;

/**
 *
 * @author Wolverine
 */
public class ConsultaContasReceberTableModel extends AbstractTableModel{
    
    private List<Contasreceber> listaContasReceber;
    private String[] colunas ={"Nº Documento", "Nome Cliente", "Nº Parcela", "Data Lançamento", "Data Vencimento", "Valor Receber"};

    public ConsultaContasReceberTableModel(List<Contasreceber> listaContasReceber) {
        this.listaContasReceber = listaContasReceber;
    }

    public int getRowCount() {
        return this.listaContasReceber.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaContasReceber.get(rowIndex).getNumeroDocumento();
        }else if (columnIndex==1){
                return listaContasReceber.get(rowIndex).getCliente().getNome();
        }else if (columnIndex==2){
            return listaContasReceber.get(rowIndex).getNumeroParcelas();
        }else if (columnIndex==3){
           return listaContasReceber.get(rowIndex).getDataLancamento();
        }else if (columnIndex==4){
            return listaContasReceber.get(rowIndex).getDataVencimento();
        }else return Formatacao.foramtarDoubleString(listaContasReceber.get(rowIndex).getValorConta());
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
             return  String.class;
         }else if (columnIndex==2){
             return Integer.class;
         }else if (columnIndex==3){
             return Date.class;
         }else if (columnIndex==4){
             return Date.class;
         }else if (columnIndex==5){
             return String.class;
         }else return String.class;
    }
    
    
}
