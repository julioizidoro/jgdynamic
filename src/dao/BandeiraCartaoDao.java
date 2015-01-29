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
import model.BandeirasCartao;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoDao {
    
    private EntityManager manager;
    
    public BandeirasCartao salvar(BandeirasCartao bandeirasCartao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        bandeirasCartao = manager.merge(bandeirasCartao);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return bandeirasCartao;
    }
    
    public List<BandeirasCartao> listar() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<BandeirasCartao> listaBandeira = new ArrayList<BandeirasCartao>();
        Query q = manager.createQuery("select b from BandeirasCartao b order by b.nome");
        if (q.getResultList().size()>0){
            listaBandeira= q.getResultList();
        }
        manager.close();
        return listaBandeira;
    }
    
    public BandeirasCartao pesquisarid(int idBandeira) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select b from BandeirasCartao b where b.idbandeirasCartao=" + idBandeira);
        BandeirasCartao bandeira = null;
        if (q.getResultList().size()>0){
            bandeira =  (BandeirasCartao) q.getResultList().get(0);
        }
        manager.close();
        return bandeira;
    }
            
    
}
