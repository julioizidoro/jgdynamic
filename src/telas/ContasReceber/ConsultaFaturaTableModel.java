/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasReceber;

import Regras.ClienteController;
import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Faturasreceber;

/**
 *
 * @author Wolverine
 */
public class ConsultaFaturaTableModel extends AbstractTableModel{
    
    private List<Faturasreceber> listaFatura;
    private String[] colunas ={"Nº Fatura", "Nome Cliente", "Data Lançamento", "Data Vencimento", "Nº Parcelas", "Valor Fatura"};

    public ConsultaFaturaTableModel(List<Faturasreceber> listaFatura) {
        this.listaFatura = listaFatura;
    }

    public int getRowCount() {
        return this.listaFatura.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaFatura.get(rowIndex).getNumeroFatura();
        }else if (columnIndex==1){
                return getNomeCliente(listaFatura.get(rowIndex).getCliente());
        }else if (columnIndex==2){
           return listaFatura.get(rowIndex).getDataLancamento();
        }else if (columnIndex==3){
            return listaFatura.get(rowIndex).getDataVencimento();
        }else  if (columnIndex==4){
            return listaFatura.get(rowIndex).getNumeroParcelas();
        } else return Formatacao.foramtarDoubleString(listaFatura.get(rowIndex).getValorFatura());
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
             return Date.class;
         }else if (columnIndex==3){
             return Date.class;
         }else if (columnIndex==4){
             return Integer.class;
         }else return String.class;
    }
    
    public String getNomeCliente(int idCliente){
        ClienteController clienteController = new ClienteController();
        Cliente clinete = clienteController.consultarClienteId(idCliente);
        if (clinete!=null){
            return clinete.getNome();
        }else return " ";
    }
}
