/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regras;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Woverine
 */
public class ConverterData {
    
    private static DateFormat df;

    public static Date retornatDatayyyyMMdd() throws ParseException{
        df = new SimpleDateFormat("yyyy/MM/dd");
        String sData = df.format(new Date());
        Date data = df.parse(sData);
        return data;
    }

}
