/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.TransferenciaSaida;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;







/**
 *
 * @author wolverine
 */
public class ConsultaTransferenciaSaidaTableModel extends AbstractTableModel {

    private List<TransferenciaProcesso> listaTransferencia;
    private String[] colunas ={"Empresa Detinatario", "Nº", "Data Registro", "Valor R$"};

    public ConsultaTransferenciaSaidaTableModel(List<TransferenciaProcesso> listaTransferencias) {
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
            return listaTransferencia.get(rowIndex).getEmpresaDestinatario().getRazaoSocial();
        }else if (columnIndex==1){
            return this.listaTransferencia.get(rowIndex).getTransferencia().getIdsaidaTransferencia();
        }else if (columnIndex==2){
            return listaTransferencia.get(rowIndex).getTransferencia().getDataTransferencia();
        }else return Formatacao.foramtarDoubleString(this.listaTransferencia.get(rowIndex).getTransferencia().getValorTotal());
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
             return  Integer.class;
         } else if (columnIndex==2){
             return Date.class;
         }else return String.class;
    }

}
