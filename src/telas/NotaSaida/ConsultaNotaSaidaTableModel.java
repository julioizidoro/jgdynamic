/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import Regras.ClienteController;
import Regras.Formatacao;
import Regras.FornecedorController;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Fornecedor;
import model.NotaSaida;

/**
 *
 * @author wolverine
 */
public class ConsultaNotaSaidaTableModel extends AbstractTableModel{
    
    private List<NotaSaida> listaNotaSaida;
    private String[] colunas ={"Cliente", "No. NF-e", "Data Emissão", "Valor Produtos", "Valor Nota", "Situação"};

    public ConsultaNotaSaidaTableModel(List<NotaSaida> listaNotaSaida) {
        this.listaNotaSaida = listaNotaSaida;
    }

    public int getRowCount() {
        return listaNotaSaida.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            if (listaNotaSaida.get(rowIndex).getIdcliente()>0){
                return getClienteNome(listaNotaSaida.get(rowIndex).getIdcliente());
            }else return getFornecedorNome(listaNotaSaida.get(rowIndex).getIdfornecedor());
        }else if (columnIndex==1){
            return listaNotaSaida.get(rowIndex).getNumero();
        }else if (columnIndex==2){
            return listaNotaSaida.get(rowIndex).getDataEmissao();
        }else if (columnIndex==3){
            return Formatacao.foramtarFloatString(listaNotaSaida.get(rowIndex).getValorProdutos());
        }else if (columnIndex==4){
            return Formatacao.foramtarFloatString(listaNotaSaida.get(rowIndex).getValorNotaFiscal());
        }else return listaNotaSaida.get(rowIndex).getSituacao();
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
            return Integer.class;
         }else if (columnIndex==2){
             return  Date.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }
    
    
    public String getClienteNome(int idcliente){
        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.consultarClienteId(idcliente);
        if(cliente!=null){
            return cliente.getNome();
        }else {
            return "cliente não localizado";
        } 
    }
    
    public String getFornecedorNome(int idfornecedor){
        FornecedorController fornecedorController = new FornecedorController();
        Fornecedor fornecedor = fornecedorController.consultarFornecedor(idfornecedor);
        if(fornecedor!=null){
            return fornecedor.getRazaoSocial();
        }else {
            return "Fornecedor não localizado";
        } 
    }
    
    
    
}
