/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton;

import Regras.ParametroLocalController;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.ParametrosLocal;


/**
 *
 * @author aluno
 */
public class ConexaoSingletonParametros {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager manager = null;

    public static EntityManager getConexao(int idEmpresa) throws SQLException {
        try {
            ParametroLocalController parametroLocalController = new ParametroLocalController();
            ParametrosLocal parametrolocal = parametroLocalController.localizarEmpresa(idEmpresa);
            Map mapa = new HashMap();
            mapa.put("hibernate.connection.url", parametrolocal.getBanco());
            mapa.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            mapa.put("hibernate.connection.password", parametrolocal.getSenha());
            mapa.put("hibernate.connection.username", parametrolocal.getUsuario());
            mapa.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            mapa.put("hibernate.show_sql", "true");
            mapa.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            emf = Persistence.createEntityManagerFactory("parametrosPU", mapa);
            manager = emf.createEntityManager();
            return manager;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());

        }
        return null;
    }
}
