/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton;

import controler.Sigap;
import java.sql.SQLException;
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
public class ConexaoSingletonParametros {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager manager = null;

    public static EntityManager getConexao()throws SQLException{
        Sigap utilitario = new Sigap();
        //ConfiguracaoSistema configura = new ConfiguracaoSistema();
        //configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        Map mapa = new HashMap();
        mapa.put("hibernate.connection.url", "jdbc:mysql://" +  "200.175.61.147" + ":" + "8082" + "/" +
                "parametros");
        mapa.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        mapa.put("hibernate.connection.password","jfhmaster123");
        mapa.put("hibernate.connection.username", "root");
        mapa.put("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
        mapa.put("hibernate.show_sql","true");
        mapa.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

        try{
            if(emf == null)
                emf = Persistence.createEntityManagerFactory("parametrosPU", mapa);
                manager = emf.createEntityManager();
                return manager;
        }catch (Exception e){
            e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());

        }
        return null;
    }
}