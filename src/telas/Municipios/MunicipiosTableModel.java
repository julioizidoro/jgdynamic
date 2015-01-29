/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Municipios;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Municipios;

/**
 *
 * @author wolverine
 */
public class MunicipiosTableModel extends AbstractTableModel {
    
    private List<Municipios> listaMunicipios;
    private String[] colunas ={"Estado", "Municipio", "Código"};

    public MunicipiosTableModel(List<Municipios> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public int getRowCount() {
        return listaMunicipios.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaMunicipios.get(rowIndex).getEstado();
        }else if (columnIndex==1){
            return listaMunicipios.get(rowIndex).getNomeMunicipio();
        }else return listaMunicipios.get(rowIndex).getCodigo();
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
        }else return String.class;
    }
    
}
