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
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoDao {
    
    private EntityManager manager;
    
    public List<Parcelacartao> consultarParcelaCartao(String data, int idBanco) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Parcelacartao> listaParcelaCartao = new ArrayList<Parcelacartao>();
        Query q = manager.createQuery("select p from Parcelacartao p where p.dataRecebimento='" + data + "'  and p.banco=" 
                + idBanco);
        if (q.getResultList().size()>0){
            listaParcelaCartao =   q.getResultList();
        }
        manager.close();
        return listaParcelaCartao;
    }
    
    public float calcularValorCArtaoBancoDia(String sql) throws SQLException{
        Double valor = 0.0;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery(sql);
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.close();
        return valor.floatValue();
    }
    
}
