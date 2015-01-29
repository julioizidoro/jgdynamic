/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton;

import controler.ConfiguracaoSistema;
import controler.Sigap;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


/**
 *
 * @author aluno
 */
public class ConexaoSingletonRemota {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager manager = null;

    public static EntityManager getConexao(){
        Sigap utilitario = new Sigap();
        ConfiguracaoSistema configura = new ConfiguracaoSistema();
        configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        Map mapa = new HashMap();
        mapa.put("hibernate.connection.url", "jdbc:mysql://" + configura.getRemotolocal()+ ":" + configura.getRemotoporta() + "/" +
                configura.getRemotoNome());
        mapa.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        mapa.put("hibernate.connection.password",configura.getRemotoSenha());
        mapa.put("hibernate.connection.username",configura.getRemotousuario());
        mapa.put("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
        mapa.put("hibernate.show_sql","true");
        mapa.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        
       
      
        try{
            if (emf!=null){
                emf.close();
            }
            emf = Persistence.createEntityManagerFactory("remoto", mapa);
            manager = emf.createEntityManager();
            return manager;
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Erro de Conexão " + e);
           return null;
        }

    }
}