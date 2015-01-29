/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.NotaSaida;

/**
 *
 * @author wolverine
 */
public class NotaSaidaDao {
    
    private EntityManager manager;
    
    public List<NotaSaida> consultarNotaSaida(String data) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<NotaSaida> listaNotaSaida = new ArrayList<NotaSaida>();
        Query q = manager.createQuery("select n from NotaSaida n where n.dataEmissao>='" + data + "'  order by n.dataEmissao");
        if (q.getResultList().size()>0){
            listaNotaSaida = q.getResultList();
        }
        manager.close();
        return listaNotaSaida;
    }
    
    public NotaSaida salvarNotaSaida(NotaSaida notaSaida) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        notaSaida = manager.merge(notaSaida);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return notaSaida;
    }
    
    public List<NotaSaida> consultarNotaSaida(String dataInicial, String dataFinal) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<NotaSaida> listaNotaSaida = new ArrayList<NotaSaida>();
        Query q = manager.createQuery("select n from NotaSaida n where n.dataEmissao>='" + dataInicial + "' and n.dataEmissao<='" + dataFinal + "'  order by n.dataEmissao");
        listaNotaSaida = q.getResultList();
        manager.close();
        return listaNotaSaida;
    }
    
    public int consultarUltimaNotaEmitida() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<NotaSaida> listaNotaSaida = new ArrayList<NotaSaida>();
        Query q = manager.createNativeQuery("Select MAX(numero) as numeroNfe from notaSaida");
        int i = (Integer) q.getSingleResult();
        manager.close();
        return i;
    }
    
    public List<NotaSaida> filtrarNotaSaida(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        List<NotaSaida> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
}
