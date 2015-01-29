/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Codigofiscal;

/**
 *
 * @author wolverine
 */
public class CodigoFiscalDao {
    
    private EntityManager manager;  
    
    public void salvar(Codigofiscal codigoFiscal) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(codigoFiscal);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Codigofiscal> listarCodigoFiscal(String tipo) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Codigofiscal> listaCodigoFiscal = null;
        Query q = manager.createQuery("select c from Codigofiscal c where c.tipo<>'" + tipo +
                "' order by c.cfop");
        if (q.getResultList().size()>0){
            listaCodigoFiscal= q.getResultList();
        }
        manager.close();
        return listaCodigoFiscal;
    }
    
}
