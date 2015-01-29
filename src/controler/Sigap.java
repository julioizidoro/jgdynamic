/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import Regras.Formatacao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Acer
 */
public class Sigap {
    int dias;
    private String emailSenha;
    private String emailUsuario;

    public int getDias() {
        return dias;
    }


    public List<String> agendamentoAutomatico(Date inicio, Date fim, boolean seg, boolean ter,
            boolean qua, boolean qui, boolean sex, boolean sab){
        List<String> datas = new ArrayList<String>();
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();//Instancia um Calendario
        cal.setTime(inicio);//Seta da data de inicio no calendario
        int diasemana = 0;// inicia a variavel dia da semana
        while (inicio.before(fim)){//compara se a data de inicio e anterior o data final
            diasemana=cal.get(cal.DAY_OF_WEEK);//pega o dia da semana da data de do calendario
            if ((diasemana==2) && (seg)){
                dias++;
                datas.add(df.format(inicio));
            }else if ((diasemana==3) && (ter)){
                dias++;
                datas.add(df.format(inicio));
            }else if ((diasemana==4) && (qua)){
                dias++;
                datas.add(df.format(inicio));
            }else if ((diasemana==5) && (qui)){
                dias++;
                datas.add(df.format(inicio));
            }else if ((diasemana==6) && (sex)){
                dias++;
                datas.add(df.format(inicio));
            }else if ((diasemana==7) && (sab)){
                dias++;
                datas.add(df.format(inicio));
            }
            cal.add(Calendar.DAY_OF_WEEK, 1);//adiciona mais um dia na data do calendario
            inicio = cal.getTime();//pega a data do calendario
        }
       return datas;
    }

        public boolean validaCPF(String s_aux) {
        String ncpf = "";
        for (int i=0;i<s_aux.length();i++){
           if ((s_aux.charAt(i)!='.') && (s_aux.charAt(i)!='-')){
                ncpf+=s_aux.charAt(i);
           }
        }
        s_aux=ncpf;

//------- Rotina para CPF
        if (s_aux.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
//--------- Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + (11 - n_Count) * digitoCPF;
//--------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }
            
//--------- Primeiro resto da divisão por 11.
            resto = (d1 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
//--------- Segundo resto da divisão por 11.
            resto = (d2 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
//--------- Digito verificador do CPF que está sendo validado.
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
//--------- Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
//--------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        } //-------- Rotina para CNPJ
        else if (s_aux.length() == 14) {
            int soma = 0;
            int aux=0;
            int dig=0;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();
//--------- Primeira parte
            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i]) - 4 * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4]) - 4 * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
//--------- Segunda parte
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i]) - 4 * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5]) - 4 * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }


  public boolean ValidaCNPJ( String str_cnpj ){
     String ncpf = "";
        for (int i=0;i<str_cnpj.length();i++){//for para retirar tudo que nao for numero
           if ((str_cnpj.charAt(i)!='.') && (str_cnpj.charAt(i)!='-') && (str_cnpj.charAt(i)!='/')){
                ncpf+=str_cnpj.charAt(i);
           }
        }
        str_cnpj=ncpf;

      int soma = 0, aux, dig;
      String cnpj_calc = str_cnpj.substring(0,12);//Pego CNPJ sem os Dogitos

      if ( str_cnpj.length() != 14 )
        return false;

      char[] chr_cnpj = str_cnpj.toCharArray();//Transforma a String para Array de char

      /* Primeira parte */
      for( int i = 0; i < 4; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (6 - (i + 1)) ;
      for( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
          soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);

      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      /* Segunda parte */
      soma = 0;
      for ( int i = 0; i < 5; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (7 - (i + 1)) ;
      for ( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
          soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);
      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      return str_cnpj.equals(cnpj_calc);
   }

  //Transforma uma data do tipo Date em String no formato (aaaa/mm/dd)
  public static String ConvercaoData(Date data){
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      String dataFormatada = df.format(data);
      return dataFormatada;
  }

  public static String ConvercaoDataSql(Date data){
      DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      String dataFormatada = df.format(data);
      return dataFormatada;
  }
  
  public static Date ConvercaoStringData(String data){
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      Date dataFormatada = null;
        try {
            dataFormatada = df.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Sigap.class.getName()).log(Level.SEVERE, null, ex);
        }
      return dataFormatada;
  }

  public static String SomarDatas(Date data, int dias, String formato) throws ParseException{
       SimpleDateFormat sd = new SimpleDateFormat(formato);
       Calendar c = new GregorianCalendar();
       c.add(Calendar.DAY_OF_MONTH, dias);
       return sd.format(c.getTime());
  }

  //Transforma um Double em formato moneterio
  public static String ConvercaoMonetaria(Double valor){
        NumberFormat format = new DecimalFormat("0.00");
        format.setMinimumFractionDigits(2);
        String valorFormatado = format.format(valor);
        return valorFormatado;
    }

     public static Float ConvercaoMonetariaFloat(String valor){
        String cValor = "";
        for (int i=0;i<valor.length();i++){
            if (valor.charAt(i)==','){
                cValor = cValor + ".";
            }else {
                cValor = cValor + valor.charAt(i);
            }
        }
        float novoValor = Float.parseFloat(cValor);
        return novoValor;
    }

    public static Double ConvercaoMonetariaDouble(String valor){
        String cValor = "";
        for (int i=0;i<valor.length();i++){
            if (valor.charAt(i)==','){
                cValor = cValor + ".";
            }else {
                cValor = cValor + valor.charAt(i);
            }
        }
        double novoValor = Double.parseDouble(cValor);
        return novoValor;
    }

    public static String ConvercaoMonetaria(Float valor){

         NumberFormat format = new DecimalFormat("0.00");
        format.setMinimumFractionDigits(2);
        String valorFormatado = format.format(valor);
        return valorFormatado;
//        NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale("pt","BR"));
//        format.setMinimumFractionDigits(2);
//        String valorFormatado = format.format(valor);
//        return valorFormatado;
    }
  //Retorna uma String com a data do dia no formato (aaaa/mm/dd)
  public String getDataDoDia() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String data = df.format(new Date (System.currentTimeMillis()));
        return data;
    }
//Retorna uma String com a data do dia no formato (dd/mm/aaaa)
  public String gatDataDoDiaComum() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = df.format(new Date (System.currentTimeMillis()));
        return dataFormatada;
    }
//Captura uma String em formato de data e transforma num tipo Date
  public Date getConverteDatas(String data) throws Exception {

        if (data == null || data.equals("")) {
            return null;
        }
        Date date = new Date();
        try {
            DateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
            date = formater.parse(data);
        } catch (Exception ex) {
            throw new Exception("Problemas na conversão de Data", ex);
        }
        return date;
    }


  public boolean validarEmail(String email){
        if (email.length() > 0) {
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    return true;
                }
            }
        }else return true;
        return false;
    }


  public void serelizarConfiguracao(Object objeto){
      String localIni = System.getProperty("user.dir");
      File arquivoObj = new File(localIni + "/jgdynamic.ini");
      FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(arquivoObj);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(objeto);
            if(fileOut!=null){
                fileOut.close();
            }
            if(objectOut!=null){
                objectOut.close();
            }
	} catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Arquivo nao encontrado");
	}catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro de escrita.");
	}
  }


  public Object deserializarConfiguracao(){
        String localIni = System.getProperty("user.dir");
        localIni = localIni + "/jgdynamic.ini";
        File arquivoIn = new File(localIni);
	FileInputStream arquivoInput;
         Object objeto = null;
	ObjectInputStream objectInput;
	try {
            arquivoInput = new FileInputStream(arquivoIn);
            objectInput = new ObjectInputStream(arquivoInput);
            objeto =  objectInput.readObject();
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
	}catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro de IO");
	}catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Classe nao encontrada");
	}

      return objeto;
  }

  
  
    public boolean validaHora(String hora) {
        String horas;
        String minutos;
        int conta_horas = 0;
        int conta_minutos = 0;
        horas = hora.substring(0, 2);
        minutos = hora.substring(3, 5);
        conta_horas = Integer.parseInt(horas);
        conta_minutos = Integer.parseInt(minutos);
        if (conta_horas > 24) {
            return false;
        }
        if (conta_minutos > 59) {
            return false;
        }
        return true;
    }

    public int converteHora(String hora){
        String horaInicial = hora;
        String horaI = (horaInicial.substring(0, 2));
        String minI = (horaInicial.substring(3,5));
        String horaTotal = horaI.concat(minI);
        int horaInicio = Integer.parseInt(horaTotal);
        return horaInicio;
    }

    public static String decinalValorMonetario(String texto){
        String novoTexto ="";
        for (int i=0;i<texto.length();i++){
            if (texto.charAt(i)=='.'){
                novoTexto = novoTexto + ",";
            }else {
                novoTexto = novoTexto + texto.charAt(i);
            }
        }
        return novoTexto;

    }
}


 


