/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package table;

import Regras.FornecedorController;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;
import model.Forpedido;



/**
 *
 * @author wolverine
 */
public class ConsultaForPedidoTableModel extends AbstractTableModel {

    private List<Forpedido> listaForPedido;
    private String[] colunas ={"Nº Pedido", "Fornecedor", "Data Emissão", "Data Entrega", "Condição Pagto"};

    public ConsultaForPedidoTableModel(List<Forpedido> listaEntrada) {
        this.listaForPedido = listaEntrada;
    }

    public int getRowCount() {
        return listaForPedido.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaForPedido.get(rowIndex).getIdForPedido();
        }else if (columnIndex==1){
                return localizarFornecedor(listaForPedido.get(rowIndex).getFornecedor()).getRazaoSocial();
        }else if (columnIndex==2){
            return listaForPedido.get(rowIndex).getDataEmissao();
        }else if (columnIndex==3){
            return listaForPedido.get(rowIndex).getDataEntrega();
        }else return listaForPedido.get(rowIndex).getCondicaoPagamento();
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
