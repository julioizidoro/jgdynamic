/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Fechacaixa;

/**
 *
 * @author Woverine
 */
public class FechaCaixaDao {

    private EntityManager manager;

    public Fechacaixa salvar(Fechacaixa fechaCaixa) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fechaCaixa = manager.merge(fechaCaixa);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return fechaCaixa;
    }

    public Fechacaixa getFechaCaixa(String caixa, String operador) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Fechacaixa fechaCaixa = new Fechacaixa();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String data = df.format(new Date());
        Query q = manager.createQuery("select f from Fechacaixa f where f.dataFechamento='" + data + "' and f.caixa='"+ caixa + "' and f.operador='" +
                operador + "' and  f.valorFechamento=0");
        if (q.getResultList().size()>0){
            fechaCaixa=  (Fechacaixa) q.getResultList().get(0);
        }
        manager.close();
        return fechaCaixa;
    }
    
    public List<Fechacaixa> pesquisarFechamento(String dataInicio, String dataFim, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Fechacaixa> listaFechaCaixa = new ArrayList<Fechacaixa>();
        Query q = manager.createQuery("select f from Fechacaixa f where f.dataFechamento>='" + dataInicio + "' and f.dataFechamento<='"+ dataFim + "' and empresa=" + idEmpresa + " order by dataFechamento");  
        if (q.getResultList().size()>0){
            listaFechaCaixa=  q.getResultList();
        }
        manager.close();
        return listaFechaCaixa;
    }
    
    public List<Fechacaixa> pesquisarFechamento(String data, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Fechacaixa> listaFechaCaixa = new ArrayList<Fechacaixa>();
        Query q = manager.createQuery("select f from Fechacaixa f where f.dataFechamento='" + data + "' and empresa=" + idEmpresa + " order by dataFechamento");  
        if (q.getResultList().size()>0){
            listaFechaCaixa=  q.getResultList();
        }
        return listaFechaCaixa;
    }
    
    public Fechacaixa consultar(Fechacaixa fechaCaixa) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fechaCaixa = manager.find(Fechacaixa.class, fechaCaixa.getIdfechaCaixa());
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return fechaCaixa;
    }

}
