/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class ConfiguracaoSistema implements Serializable{

    //Atributos acesso banco de dados
    private String bdSenha;
    private String bdusuario;
    private String bdlocal;
    private String bdporta;
    private String bdNome;

    //Atributos Configuracao de Email

    private String emailOrigem;
    private String emailSmtp;
    private String emailSenha;
    
    private String remotoSenha;
    private String remotousuario;
    private String remotolocal;
    private String remotoporta;
    private String remotoNome;
    
    
    
    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }

    
    public String getBdSenha() {
        return bdSenha;
    }

    public void setBdSenha(String bdSenha) {
        this.bdSenha = bdSenha;
    }

    public String getBdlocal() {
        return bdlocal;
    }

    public void setBdlocal(String bdlocal) {
        this.bdlocal = bdlocal;
    }

    public String getBdporta() {
        return bdporta;
    }

    public void setBdporta(String bdporta) {
        this.bdporta = bdporta;
    }

    public String getBdusuario() {
        return bdusuario;
    }

    public void setBdusuario(String bdusuario) {
        this.bdusuario = bdusuario;
    }

    public String getEmailOrigem() {
        return emailOrigem;
    }

    public void setEmailOrigem(String emailOrigem) {
        this.emailOrigem = emailOrigem;
    }

    public String getEmailSenha() {
        return emailSenha;
    }

    public void setEmailSenha(String emailSenha) {
        this.emailSenha = emailSenha;
    }

    public String getEmailSmtp() {
        return emailSmtp;
    }

    public void setEmailSmtp(String emailSmtp) {
        this.emailSmtp = emailSmtp;
    }

    public String getRemotoNome() {
        return remotoNome;
    }

    public void setRemotoNome(String remotoNome) {
        this.remotoNome = remotoNome;
    }

    public String getRemotoSenha() {
        return remotoSenha;
    }

    public void setRemotoSenha(String remotoSenha) {
        this.remotoSenha = remotoSenha;
    }

    public String getRemotolocal() {
        return remotolocal;
    }

    public void setRemotolocal(String remotolocal) {
        this.remotolocal = remotolocal;
    }

    public String getRemotoporta() {
        return remotoporta;
    }

    public void setRemotoporta(String remotoporta) {
        this.remotoporta = remotoporta;
    }

    public String getRemotousuario() {
        return remotousuario;
    }

    public void setRemotousuario(String remotousuario) {
        this.remotousuario = remotousuario;
    }
    
    
    
    

    

}

    