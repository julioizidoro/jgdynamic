/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.ForPedido;

import Regras.FornecedorController;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;
import model.Forpedido;

/**
 *
 * @author Wolverine
 */
public class PedidoListaTableModel extends AbstractTableModel{

    private List<Forpedido> listaForPedido;
    private String[] colunas ={"Nº Pedido", "Fornecedor", "Data Emissão", "Data Entrada", "Cod. Pagto"};

    public PedidoListaTableModel(List<Forpedido> listaForPedido) {
        this.listaForPedido = listaForPedido;
    }

    
    
    public int getRowCount() {
        return this.listaForPedido.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaForPedido.get(rowIndex).getIdForPedido();
        }else if (columnIndex==1){
            return localizarFornecedor(this.listaForPedido.get(rowIndex).getFornecedor()).getRazaoSocial();
        }else if (columnIndex==2){
            return this.listaForPedido.get(rowIndex).getDataEmissao();
        }else if (columnIndex==3){
            return this.listaForPedido.get(rowIndex).getDataEntrega();
        }else return this.listaForPedido.get(rowIndex).getCondicaoPagamento();
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
             return Date.class;
         }else if (columnIndex==3){
             return Date.class;
         }else return String.class;
    }
    
    public Fornecedor localizarFornecedor(int idFornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.consultarFornecedor(idFornecedor);
    }

}
