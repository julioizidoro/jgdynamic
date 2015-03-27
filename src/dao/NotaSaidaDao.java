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
import model.Notasaida;

/**
 *
 * @author wolverine
 */
public class NotaSaidaDao {
    
    private EntityManager manager;
    
    public List<Notasaida> consultarNotaSaida(String data) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Notasaida> listaNotaSaida = new ArrayList<Notasaida>();
        Query q = manager.createQuery("select n from Notasaida n where n.dataEmissao>='" + data + "'  order by n.dataEmissao");
        if (q.getResultList().size()>0){
            listaNotaSaida = q.getResultList();
        }
        manager.close();
        return listaNotaSaida;
    }
    
    public Notasaida salvarNotaSaida(Notasaida notaSaida) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        notaSaida = manager.merge(notaSaida);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return notaSaida;
    }
    
    public List<Notasaida> consultarNotaSaida(String dataInicial, String dataFinal) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Notasaida> listaNotaSaida = new ArrayList<Notasaida>();
        Query q = manager.createQuery("select n from Notasaida n where n.dataEmissao>='" + dataInicial + "' and n.dataEmissao<='" + dataFinal + "'  order by n.dataEmissao");
        listaNotaSaida = q.getResultList();
        manager.close();
        return listaNotaSaida;
    }
    
    public int consultarUltimaNotaEmitida() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Notasaida> listaNotasaida = new ArrayList<Notasaida>();
        Query q = manager.createNativeQuery("Select MAX(numero) as numeroNfe from notasaida");
        int i = (Integer) q.getSingleResult();
        manager.close();
        return i;
    }
    
    public List<Notasaida> filtrarNotaSaida(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        List<Notasaida> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
}
