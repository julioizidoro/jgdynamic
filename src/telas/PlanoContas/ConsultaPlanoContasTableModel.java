package telas.PlanoContas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Planoconta;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Gabi
 */
public class ConsultaPlanoContasTableModel extends AbstractTableModel{
    public List<Planoconta> listaPlanoConta;
    private String[] colunas = {"Nº Conta", "Descrição"};

    public ConsultaPlanoContasTableModel(List<Planoconta> listaPlanoConta){
        this.listaPlanoConta = listaPlanoConta;
    }

    public int getRowCount() {
        return listaPlanoConta.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Planoconta Planoconta = listaPlanoConta.get(rowIndex);
        if (columnIndex == 0) {
            return Planoconta.getNumeroConta();
        }else
            return Planoconta.getDescricao();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else{
            return String.class;
        }
    }
}
