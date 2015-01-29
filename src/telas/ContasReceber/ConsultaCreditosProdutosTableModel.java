/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ConsultaCreditosProdutosTableModel extends AbstractTableModel{
    
    private List<CreditosProdutosBean> listaProdutos;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário", "Valor Total"};

    public ConsultaCreditosProdutosTableModel(List<CreditosProdutosBean> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public int getRowCount() {
        return this.listaProdutos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return this.listaProdutos.get(rowIndex).getProduto().getReferencia();
        } else if (columnIndex == 1) {
            return listaProdutos.get(rowIndex).getProduto().getDescricao();
        } else if (columnIndex == 2) {
            return listaProdutos.get(rowIndex).getProduto().getUnidade();
        } else if (columnIndex == 3) {
            return Formatacao.foramtarQuantidade(listaProdutos.get(rowIndex).getCreditoProdutos().getQuantidade());
        } else if (columnIndex == 4) {
            return Formatacao.foramtarQuantidade(listaProdutos.get(rowIndex).getCreditoProdutos().getValorUnitario());
        } else {
            return Formatacao.foramtarQuantidade(listaProdutos.get(rowIndex).getCreditoProdutos().getQuantidade()
                    * listaProdutos.get(rowIndex).getCreditoProdutos().getValorUnitario());
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
