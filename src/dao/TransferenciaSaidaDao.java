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
import model.Saidatransferencia;
import model.Saidatransferenciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaSaidaDao {
    
    private EntityManager manager;
    
    public Saidatransferencia salvarTransferencia(Saidatransferencia transferencia) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferencia = manager.merge(transferencia);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return transferencia;
    }
    
    public Saidatransferenciaproduto salvarTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferenciaProduto = manager.merge(transferenciaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return transferenciaProduto;
    }
    
    public void excluirTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferenciaProduto = manager.find(Saidatransferenciaproduto.class, transferenciaProduto.getIdsaidaTransferenciaProduto());
        //fechando uma transação
        manager.remove(transferenciaProduto);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluirTransferencia(Saidatransferencia transferencia) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferencia = manager.find(Saidatransferencia.class, transferencia);
        manager.remove(transferencia);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Saidatransferencia> listaTransferencia(String dataInicio, String dataFinal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Saidatransferencia> listaTransferencia = new ArrayList<Saidatransferencia>();
        Query q = manager.createQuery("select t from Saidatransferencia t where t.dataTransferencia>='" + dataInicio + 
                "' and  t.dataTransferencia<='" + dataFinal + "' order by t.dataTransferencia");
        if (q.getResultList().size()>0){
            listaTransferencia = q.getResultList();
        }
        manager.close();
        return listaTransferencia;
    }
    
    public List<Saidatransferenciaproduto> listaTransferenciaProduto(int idTransferencia) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Saidatransferenciaproduto> listaTransferenciaProduto = new ArrayList<Saidatransferenciaproduto>();
        Query q = manager.createQuery("select t from Saidatransferenciaproduto t where t.saidaTransferencia="  + idTransferencia);
        if (q.getResultList().size()>0){
            listaTransferenciaProduto = q.getResultList();
        }
        manager.close();
        return listaTransferenciaProduto;
    }
    
}
