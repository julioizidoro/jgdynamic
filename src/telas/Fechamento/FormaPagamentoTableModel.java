/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Fechamento;

import Regras.FormaPagamentoController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formapagamento;
import model.Formavenda;

/**
 *
 * @author Woverine
 */
public class FormaPagamentoTableModel extends AbstractTableModel{

public List<Formavenda> listaFormaVenda;
    private String[] colunas = {"Código", "Descrição", "Valor R$"};


    public FormaPagamentoTableModel(List<Formavenda> listaFormaVenda) {
        this.listaFormaVenda = listaFormaVenda;
    }

    public int getRowCount() {
        return listaFormaVenda.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Formapagamento forma = localizarFormaPagamento(listaFormaVenda.get(rowIndex).getFormapagamento());
        if (columnIndex == 0) {
            return forma.getIdformaPagamento();
        } else if (columnIndex == 1) {
            return forma.getDescricao();
        } else {
            return listaFormaVenda.get(rowIndex).getValorRecebido();
        }
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
             return String.class;
         }else {
             return Float.class;
         }
    }
    
    public Formapagamento localizarFormaPagamento(int idFormaPagamento){
        FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
        return formaPagamentoController.getFormaPagamento(idFormaPagamento);
    }

}

