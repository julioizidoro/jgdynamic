/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package table;

import beanController.NfProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author wolverine
 */
public class NotaEletronicaTableModel extends AbstractTableModel {

    private List<NfProdutos> listaProduto;
    private String[] colunas ={"Nº Item", "Código", "Descrição", "Quantidade","Unidade", "Valor Unitário", "Valor Total",
                                "% ICMS", "Valor ICMS", "Valor ST", "Valor IPI", "MVA"};

    public NotaEletronicaTableModel(List<NfProdutos> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getRowCount() {
        return this.listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaProduto.get(rowIndex).getNumeroItem();
        }else if (columnIndex==1){
            return this.listaProduto.get(rowIndex).getCodigo();
        }else if (columnIndex==2){
            return this.listaProduto.get(rowIndex).getDescricao();
        }else if (columnIndex==3){
            return this.listaProduto.get(rowIndex).getQuantidade();
        }else if (columnIndex==4){
            return this.listaProduto.get(rowIndex).getUnidade();
        }else if (columnIndex==5){
            return this.listaProduto.get(rowIndex).getValorUnitario();
        }else if (columnIndex==6){
            return this.listaProduto.get(rowIndex).getValorTotal();
        }else if (columnIndex==7){
            return this.listaProduto.get(rowIndex).getAliquotaICMS();
        }else if (columnIndex==8){
            return this.listaProduto.get(rowIndex).getValorICMS();
        }else if (columnIndex==9){
            return  this.listaProduto.get(rowIndex).getValorICMSST();
        }else if (columnIndex==10){
            return this.listaProduto.get(rowIndex).getValorIPI();
        }else return this.listaProduto.get(rowIndex).getMva();

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
             return Double.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return Double.class;
        }else if (columnIndex==6){
             return Float.class;
        }else if (columnIndex==7){
             return Float.class;
        }else if (columnIndex==8){
             return Float.class;
        }else if (columnIndex==9){
             return Float.class;
        }else if (columnIndex==10){
             return Float.class;
        } else return Float.class;
    }
}
