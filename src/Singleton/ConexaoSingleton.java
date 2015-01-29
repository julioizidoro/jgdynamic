/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton;

import controler.ConfiguracaoSistema;
import controler.Sigap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


/**
 *
 * @author aluno
 */
public class ConexaoSingleton {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager manager = null;

    public static EntityManager getConexao()throws SQLException{
        Sigap utilitario = new Sigap();
        ConfiguracaoSistema configura = new ConfiguracaoSistema();
        configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        Map mapa = new HashMap();
        mapa.put("hibernate.connection.url", "jdbc:mysql://" + configura.getBdlocal()+ ":" + configura.getBdporta() + "/" +
                configura.getBdNome());
        mapa.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        mapa.put("hibernate.connection.password",configura.getBdSenha());
        mapa.put("hibernate.connection.username",configura.getBdusuario());
        mapa.put("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
        mapa.put("hibernate.show_sql","true");
        mapa.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

        try{
            if(emf == null)
                emf = Persistence.createEntityManagerFactory("jGDynamicPU", mapa);
                manager = emf.createEntityManager();
                return manager; 
        }catch (Exception e){
            e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());

        }
        return null;
    }
    
    public static Connection getConexaoJDBC() {
        Sigap utilitario = new Sigap();
        ConfiguracaoSistema configura = new ConfiguracaoSistema();
        configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
        Connection connection = null;
        String url = "jdbc:mysql://" + configura.getBdlocal() + ":" + configura.getBdporta() + "/"
                + configura.getBdNome();
        String user = configura.getBdusuario();
        String pass = configura.getBdSenha();
        try {
            try {
                Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            } catch (InstantiationException ex) {
                Logger.getLogger(ConexaoSingleton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConexaoSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection(url, user, pass);

            //System.out.println("Conexao realizada com sucesig);  

        } catch (SQLException ex) {
            System.out.println("Problemas na conexao com o banco de dados." + ex);

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC-ODBC nao encontrado: " + ex);
        }
        return connection;
    }
    
    public static void fecharConexao(){
        if (manager!=null){
            manager.close();
        }
    }
}