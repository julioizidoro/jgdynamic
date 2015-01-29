/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regras;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Wolverine
 */
public class calculos {

    public static int gerarNumeroDocumentoEntrada(int idFornecedor){
        GregorianCalendar data = new GregorianCalendar();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);
        int codigo =0;
        if (idFornecedor==0){
            codigo = dia * mes + (ano);
        }else {
            codigo = dia * mes + (ano + idFornecedor);
        }
        return codigo;
    }

}
