/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Contasreceberforma;

/**
 *
 * @author Wolverine
 */
public class FormaPagamentoTableModel extends AbstractTableModel{
    
    List<Contasreceberforma> listaForma;
    private String[] colunas ={"Forma Pagamento", "Valor R$"};

    public FormaPagamentoTableModel(List<Contasreceberforma> listaForma) {
        this.listaForma = listaForma;
    }

    public int getRowCount() {
        return listaForma.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaForma.get(rowIndex).getFormaRecebimento();
        }else return Formatacao.foramtarDoubleString(listaForma.get(rowIndex).getValorPago());
    }
    
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
         }else return String.class;
    }
    
}
