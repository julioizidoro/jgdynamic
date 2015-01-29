/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ControleCheques;

import Regras.ClienteController;
import Regras.Formatacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author wolverine
 */
public class ControleChequesTableModel extends AbstractTableModel {
    
    private List<ControleChequeBean> listaCheques;
    private String[] colunas ={"CPF/CNPJ", "Nome do Cliente" , "No. Cheque", "Data Emissão", "Valor Cheque", "Data Compensação", "Marcado"};

    public ControleChequesTableModel(List<ControleChequeBean> listaCheques) {
        this.listaCheques = listaCheques;
    }

    public int getRowCount() {
        return this.listaCheques.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
                return listaCheques.get(rowIndex).getCliente().getDocFederal();
        }else if (columnIndex==1){
           return listaCheques.get(rowIndex).getCliente().getNome();
        }else if (columnIndex==2){
            return listaCheques.get(rowIndex).getCheque().getNumeroCheque();
        }if (columnIndex==3){
            return Formatacao.ConvercaoDataPadrao(listaCheques.get(rowIndex).getCheque().getDataEmissao());
        }else if (columnIndex==4){
            return Formatacao.foramtarDoubleString(listaCheques.get(rowIndex).getCheque().getValorCheque());
        }else if (columnIndex==5) {
            return Formatacao.ConvercaoDataPadrao(listaCheques.get(rowIndex).getCheque().getDataCompensacao());
        }else return listaCheques.get(rowIndex).getMarcado();
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
             return String.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
         }else return String.class;
    }
    
    public Cliente consultarCliente(int idCliente){
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();
        cliente = clienteController.consultarClienteId(idCliente);
        if (cliente!=null){
            return cliente;
        }else {
            return null;
        }
    }
    
    
    
    
}
