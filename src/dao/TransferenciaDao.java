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
import model.Tranfereciaproduto;
import model.Transferencia;


/**
 *
 * @author Wolverine
 */
public class TransferenciaDao {
    
    private EntityManager manager;
    
    public Transferencia salvarTransferencia(Transferencia transferencia) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferencia = manager.merge(transferencia);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return transferencia;
    }
    
    public Tranfereciaproduto salvarTransferenciaProduto(Tranfereciaproduto transferenciaProduto) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferenciaProduto = manager.merge(transferenciaProduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return transferenciaProduto;
    }
    
    public void excluirTransferenciaProduto(Tranfereciaproduto transferenciaProduto) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferenciaProduto = manager.find(Tranfereciaproduto.class, transferenciaProduto.getIdtranfereciaProduto());
        //fechando uma transação
        manager.remove(transferenciaProduto);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void excluirTransferencia(Transferencia transferencia) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        transferencia = manager.find(Transferencia.class, transferencia);
        manager.remove(transferencia);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Transferencia> listaTransferencia(String dataInicio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Transferencia> listaTransferencia = new ArrayList<Transferencia>();
        Query q = manager.createQuery("select t from Transferencia t where t.dataEntrada>='" + dataInicio + "'  order by t.dataEntrada");
        if (q.getResultList().size()>0){
            listaTransferencia = q.getResultList();
        }
        manager.close();
        return listaTransferencia;
    }
    
    public List<Tranfereciaproduto> listaTransferenciaProduto(int idTransferencia) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Tranfereciaproduto> listaTransferenciaProduto = new ArrayList<Tranfereciaproduto>();
        Query q = manager.createQuery("select t from Tranfereciaproduto t where t.transferencia='" + idTransferencia + "'  order by t.idtranfereciaProduto");
        if (q.getResultList().size()>0){
            listaTransferenciaProduto = q.getResultList();
        }
        manager.close();
        return listaTransferenciaProduto;
    }
}
