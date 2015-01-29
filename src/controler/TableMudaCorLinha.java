/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Empresa;

/**
 *
 * @author Wolverine
 */
public class TableMudaCorLinha extends DefaultTableCellRenderer {
    
    private int empresaCorrente;
    private List<Empresa> listaEmpresa = new ArrayList<Empresa>();

    public TableMudaCorLinha(List<Empresa> listaEmpresa, int empresaCorrente) {
        this.listaEmpresa = listaEmpresa;
        this.empresaCorrente= empresaCorrente;
    }
    
    @Override  
    public Component getTableCellRendererComponent(  
        JTable table,  
        Object value,  
        boolean isSelected,  
        boolean hasFocus,  
        int row,  
        int column)  
    {  
        Component result = super.getTableCellRendererComponent(  
            table,  
            value,  
            isSelected,  
            hasFocus,  
            row,  
            column  
        ); 
        int idEmpresa = listaEmpresa.get(row).getIdempresa();
         String valorFormatado;
        if(empresaCorrente==idEmpresa) {  
            result.setFont(new Font("arial", Font.BOLD, 12));  
            result.setForeground(Color.white);  
            result.setBackground(Color.blue);  
            if (value instanceof Double){
                Double valor = (Double) value;
                NumberFormat format = NumberFormat.getCurrencyInstance();
                format.setMinimumFractionDigits(2);
                valorFormatado = format.format(valor);
                
            }else {
                valorFormatado = value.toString();
            }
        }else {  
            result.setFont(new Font("arial", Font.PLAIN, 12));  
            result.setForeground(Color.gray);  
            result.setBackground(Color.black); 
            if (value instanceof Double){
                Double valor = (Double) value;
                NumberFormat format = NumberFormat.getCurrencyInstance();
                format.setMinimumFractionDigits(2);
                valorFormatado = format.format(valor);
                
            }else {
                valorFormatado = value.toString();
            }
        }  
        return result;  
    }  
    
}


                    
