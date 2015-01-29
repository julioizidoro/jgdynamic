/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Entrada;

import Regras.Formatacao;
import Regras.ListaProdutoEntrada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wolverine
 */
public class EntradaProdutoTableModel extends AbstractTableModel{

    private List<ListaProdutoEntrada> listaEntrada;
    private String[] colunas ={"Código", "Descrição", "Unidade", "Quantidade", "Valor Unitário",
                                "Valor ICMS", "Valor ST", "Valor IPI", "Valor Custo", "Valor Total", "Preço"};

    public EntradaProdutoTableModel(List<ListaProdutoEntrada> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public int getRowCount() {
        return  listaEntrada.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
     if (!(this.listaEntrada.get(rowIndex).isExcluido())){
     if (columnIndex==0){
            return this.listaEntrada.get(rowIndex).getProduto().getReferencia();
        }else if (columnIndex==1){
            return this.listaEntrada.get(rowIndex).getProduto().getDescricao();
        }else if (columnIndex==2){
            return this.listaEntrada.get(rowIndex).getProduto().getUnidade();
        }else if (columnIndex==3){
            return Formatacao.foramtarQuantidade(this.listaEntrada.get(rowIndex).getEntradaproduto().getQuantidade());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorUnitario());
        }else if (columnIndex==5){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorICMS());
        }else if (columnIndex==6){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorST());
        }else if (columnIndex==7){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorIPI());
        }else if (columnIndex==8){
            return Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorCusto());
        }else if (columnIndex==9){
            return  Formatacao.foramtarFloatString(this.listaEntrada.get(rowIndex).getEntradaproduto().getValorTotal());
        }else return this.listaEntrada.get(rowIndex).getEntradaproduto().getPreco();

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
             return Double.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
        }else if (columnIndex==6){
             return String.class;
        }else if (columnIndex==7){
             return String.class;
        }else if (columnIndex==8){
             return String.class;
        }else if (columnIndex==9){
             return String.class;
        }else return String.class;

}
}
