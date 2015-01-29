/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import Regras.Formatacao;
import facade.EmpresaFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empresa;



/**
 *
 * @author Woverine
 */
public class Config {

    private String idProduto;
    private Empresa empresa;
    private String ini;
    private boolean remoto;
    private String caminhoAcbr;
    private String caminhoNFe;

    public Config() {
        this.remoto = false;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public boolean isRemoto() {
        return remoto;
    }

    public void setRemoto(boolean remoto) {
        this.remoto = remoto;
    }

   
    
    public  void carregarConfiguracao() {
        String localIni = System.getProperty("user.dir");
        localIni = Formatacao.configurarCaminhoArquivos(localIni);
        File file = new File(localIni + "/jgdynamic.properties");
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
     //       setIdProduto(props.getProperty("idProduto"));
            String id = props.getProperty("empresa");
            setIni(props.getProperty("caminhoini"));
            carregarEmpresa(Integer.parseInt(id));
            setCaminhoAcbr(props.getProperty("Acbr"));
            setCaminhoNFe(props.getProperty("nfe"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
    
    public void SalvarConfiguracao(){
        String localIni = System.getProperty("user.dir");
        localIni = Formatacao.configurarCaminhoArquivos(localIni);
        File file = new File(localIni + "\\jgdynamic.properties");
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
            props.setProperty("idProduto", idProduto);
            FileOutputStream out = new FileOutputStream(file);
            props.store(out,"");
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }

    public int gerarIdProduto(String localIni){
        carregarConfiguracao();
        return Integer.parseInt(getIdProduto());
    }

    public  void gravarIdProduto(int idProduto){
        setIdProduto(String.valueOf(idProduto));
        SalvarConfiguracao();
    }
    
    public void carregarEmpresa(int idEmpresa){
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            this.empresa = empresaFacade.buscarEmpresa(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCaminhoAcbr() {
        return caminhoAcbr;
    }

    public void setCaminhoAcbr(String caminhoAcbr) {
        this.caminhoAcbr = caminhoAcbr;
    }

    public String getCaminhoNFe() {
        return caminhoNFe;
    }

    public void setCaminhoNFe(String caminhoNFe) {
        this.caminhoNFe = caminhoNFe;
    }


}