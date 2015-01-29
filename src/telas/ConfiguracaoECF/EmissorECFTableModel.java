/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ConfiguracaoECF;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Emissorecf;

/**
 *
 * @author Julio
 */
public class EmissorECFTableModel extends AbstractTableModel {
    
    private List<Emissorecf> listaEmissorECF;
    private String[] colunas ={"Código", "Nº Série", "Modelo", "Data Redução Z"};

    public EmissorECFTableModel(List<Emissorecf> listaEmissorECF)  {
        this.listaEmissorECF = listaEmissorECF;
    }

    public int getRowCount() {
        return listaEmissorECF.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaEmissorECF.get(rowIndex).getIdEmissorECF();
        }else if (columnIndex==1){
            return listaEmissorECF.get(rowIndex).getNumeroSerie();
        }else if (columnIndex==2){
            return listaEmissorECF.get(rowIndex).getModelo();
        }else return listaEmissorECF.get(rowIndex).getDataReducaoZ();
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
         }else return Date.class;
    }
    
    
    
    
}
