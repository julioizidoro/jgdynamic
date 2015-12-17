/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Encerramento;

import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Inventario;
import view.Viewconsultaprodutoestoque;



/**
 *
 * @author wolverine
 */
public class ConsultaProdutoInventarioTableModel extends AbstractTableModel {

    private List<Inventario> listaProduto;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Qtd Estoque", "Valor Total"};

    public ConsultaProdutoInventarioTableModel(List<Inventario> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getRowCount() {
        return listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return listaProduto.get(rowIndex).getProduto().getReferencia();
        } else if (columnIndex == 1) {
            return listaProduto.get(rowIndex).getProduto().getDescricao();
        } else if (columnIndex == 2) {
            return listaProduto.get(rowIndex).getProduto().getUnidade();
        } else if (columnIndex == 3) {
            return Formatacao.foramtarQuantidade(listaProduto.get(rowIndex).getQuantidadeestoque());
        } else {
            return Formatacao.foramtarFloatString(listaProduto.get(rowIndex).getValortotal());
        }
    }

    public String calcularTotal(Viewconsultaprodutoestoque produto){
        if (produto.getValorCusto()>0){
            float total = (float) (produto.getQuantidadeEstoque() * produto.getValorCusto());
            return Formatacao.foramtarFloatString(total);
        }else{
            return "0,00";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
        } else if (columnIndex==1){
            return String.class;
         }else if (columnIndex==2){
             return  String.class;
         }else if (columnIndex==3){
             return String.class;
         }else return String.class;
    }

}
