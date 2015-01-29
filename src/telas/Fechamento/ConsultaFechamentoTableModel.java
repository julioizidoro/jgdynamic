/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Fechamento;


import Regras.Formatacao;
import Regras.UsuariosController;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.swing.table.AbstractTableModel;
import model.Fechacaixa;
import model.Usuarios;

/**
 *
 * @author Wolverine
 */
public class ConsultaFechamentoTableModel extends AbstractTableModel {

    private List<Fechacaixa> listaFechaCaixa;
    private String[] colunas = {"Nº Fechamento", "Data", "Hora Abertura", "Valor Troco", "Hora Fechamento" , "Nº Caixa", "Operador", "Situação"};

    public ConsultaFechamentoTableModel(List<Fechacaixa> listaFechaCaixa) {
        this.listaFechaCaixa = listaFechaCaixa;
    }
    
    public int getRowCount() {
        return listaFechaCaixa.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return this.listaFechaCaixa.get(rowIndex).getIdfechaCaixa();
        }else if (columnIndex==1){
            return this.listaFechaCaixa.get(rowIndex).getDataFechamento();
        }else if (columnIndex==2){
            return this.listaFechaCaixa.get(rowIndex).getHora();
        }else if (columnIndex==3){
            return Formatacao.foramtarFloatString(this.listaFechaCaixa.get(rowIndex).getValorAbertura());
        }else if (columnIndex==4){
            return this.listaFechaCaixa.get(rowIndex).getHoraFechamento();
        }else if (columnIndex==5){
            return this.listaFechaCaixa.get(rowIndex).getCaixa();
        }else if (columnIndex==6){
            return pesquisarOperador(listaFechaCaixa.get(rowIndex).getUsuarios());
        }else return  listaFechaCaixa.get(rowIndex).getSituacao();
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
             return  Date.class;
         }else if (columnIndex==2){
             return Timer.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return Timer.class;
         }else if (columnIndex==5){
             return String.class;
         }else if (columnIndex==6){
             return String.class;
         }else return String.class;
    }
    
    public String pesquisarOperador(int idOperador){
        UsuariosController usuariosController = new UsuariosController();
        Usuarios usuarios = new Usuarios();
        usuarios= usuariosController.consultarUsuario(idOperador);
        if (usuarios!=null){
            return usuarios.getNome();
        }
        return  " ";
    }

    
}
