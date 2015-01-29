/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import controler.ConfiguracaoSistema;
import controler.Sigap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wolverine
 */
public class DadosConexao {

    private static Map mapa;

    public static Map getDadosConexao() throws Exception {
        if (mapa == null) {
            Sigap utilitario = new Sigap();
            ConfiguracaoSistema configura = new ConfiguracaoSistema();
            configura = (ConfiguracaoSistema) utilitario.deserializarConfiguracao();
            mapa = new HashMap();
            mapa.put("hibernate.connection.url", "jdbc:mysql://" + configura.getBdlocal() + ":" + configura.getBdporta() + "/"
                    + configura.getBdNome());
            mapa.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            mapa.put("hibernate.connection.password", configura.getBdSenha());
            mapa.put("hibernate.connection.username", configura.getBdusuario());
            mapa.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            mapa.put("hibernate.show_sql", "true");
            mapa.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        }
        return mapa;
    }
}
