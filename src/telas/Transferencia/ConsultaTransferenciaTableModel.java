/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Transferencia;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;







/**
 *
 * @author wolverine
 */
public class ConsultaTransferenciaTableModel extends AbstractTableModel {

    private List<ConsultaTransferencia> listaTransferencia;
    private String[] colunas ={"Nº", "Data Registro", "Valor R$"};

    public ConsultaTransferenciaTableModel(List<ConsultaTransferencia> listaTransferencias) {
        this.listaTransferencia = listaTransferencias;
    }

    public int getRowCount() {
        return listaTransferencia.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaTransferencia.get(rowIndex).getTransferencia().getIdtransferencia();
        }else if (columnIndex==1){
            return this.listaTransferencia.get(rowIndex).getTransferencia().getDataEntrada();
        }else return Formatacao.foramtarFloatString(this.listaTransferencia.get(rowIndex).getTransferencia().getValorTotal());
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Integer.class;
         }else if (columnIndex==1){
             return  Date.class;
         }else return String.class;
    }

}
