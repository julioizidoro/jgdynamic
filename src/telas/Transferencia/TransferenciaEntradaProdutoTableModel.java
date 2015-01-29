/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Transferencia;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class TransferenciaEntradaProdutoTableModel extends AbstractTableModel{

    private List<consultaTransferenciaProduto> listaTransferenciaEstoqueProduto;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário",
                                "Valor Total"};

    public TransferenciaEntradaProdutoTableModel(List<consultaTransferenciaProduto> listaTransferenciaEstoqueProduto) {
        this.listaTransferenciaEstoqueProduto = listaTransferenciaEstoqueProduto;
    }

    

    public int getRowCount() {
        return  listaTransferenciaEstoqueProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
     double valorTotal=0;
     if (!(this.listaTransferenciaEstoqueProduto.get(rowIndex).isExcluir())){
     if (columnIndex==0){
            return this.listaTransferenciaEstoqueProduto.get(rowIndex).getProduto().getReferencia();
        }else if (columnIndex==1){
            return this.listaTransferenciaEstoqueProduto.get(rowIndex).getProduto().getDescricao();
        }else if (columnIndex==2){
            return this.listaTransferenciaEstoqueProduto.get(rowIndex).getProduto().getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(this.listaTransferenciaEstoqueProduto.get(rowIndex).getTransTrasferenciaproduto().getQuantidade());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(this.listaTransferenciaEstoqueProduto.get(rowIndex).getTransTrasferenciaproduto().getValorUnitario());
        }else {
            valorTotal = this.listaTransferenciaEstoqueProduto.get(rowIndex).getTransTrasferenciaproduto().getValorTotal();
            return Formatacao.foramtarDoubleString(valorTotal);
        }
    }
     return null;
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
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
}
}