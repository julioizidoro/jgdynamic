/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Regras.Formatacao;
import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Devolucao;
import model.Devolucaodefeito;
import model.Devolucaoproduto;
import model.Enviodevolucaodefeito;
import model.Enviodevolucaodefeitoproduto;
import model.Fechacaixa;
import view.Viewdevolucaodefeitoenviadas;

import view.Viewdevolucaodefeitoproduto;
import view.Viewrelatoriodevolucao;

/**
 *
 * @author Woverine
 */
public class DevolucaoDao {

    private EntityManager manager;

    public void gravarDevolucao(Devolucao devolucao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(devolucao);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void gravarDevolucaoProduto(Devolucaoproduto devolucaoproduto) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(devolucaoproduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public int ultimaDevolucaoGravada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idDevolucao) From Devolucao");
        int idDevolucao = (Integer)q.getSingleResult();
        manager.close();
        return idDevolucao;
    }

    public Devolucao getDevolucao(int idDevolucao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select d FROM Devolucao d where d.iddevolucao=" + idDevolucao);
        Devolucao devoluvao = (Devolucao) q.getSingleResult();
        manager.close();
        return devoluvao;
    }
    
    public List<Devolucao> getDevolucao(Fechacaixa fechaCaixa, String condicao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        String data = Formatacao.ConvercaoDataSql(new Date());
        Query q = manager.createQuery("Select d FROM Devolucao d where d.fechacaixa=" + fechaCaixa.getIdfechaCaixa() + "  and condicaoDevolucao='"+
                condicao + "'");
        List<Devolucao> listaDevoluvao =  q.getResultList();
        manager.close();
        return listaDevoluvao;
    }
    
    public List<Viewrelatoriodevolucao> relatorioDevolucao(String dataInicial, String dataFinal, int idProduto, String condicao) throws SQLException{
        String sql = "Select r from Viewrelatoriodevolucao r where r.dataDevolucao>='" + dataInicial +
                "' and r.dataDevolucao<='" + dataFinal + "' ";
        if (idProduto>0){
            sql = sql + " and r.produto=" + idProduto;
        }else if (!condicao.equalsIgnoreCase("")){
            sql = sql + " and r.condicaoDevolucao='" + condicao + "'";
        }
        sql = sql + " order by r.descricao";
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        List<Viewrelatoriodevolucao> listaDevoluvao =  q.getResultList();
        manager.close();
        return listaDevoluvao;
    }
    
    public List<Devolucao> valorDevolucaoPeriodo(String dataInicial, String dataFinal) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select d FROM Devolucao d where d.dataDevolucao>='" + dataInicial + 
                "' and d.dataDevolucao<='" + dataFinal + "'");
        List<Devolucao> listaDevoluvao =  q.getResultList();
        manager.close();
        return listaDevoluvao;
    }
    
    public List<Viewdevolucaodefeitoproduto> listarDevolucaoDefeitoProduto(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        List<Viewdevolucaodefeitoproduto> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Viewdevolucaodefeitoenviadas> listarDevolucaoDefeitoEnviadas() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select d from Viewdevolucaodefeitoenviadas d order by d.data");
        List<Viewdevolucaodefeitoenviadas> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public Enviodevolucaodefeito salvarEnvioDevolucao(Enviodevolucaodefeito enviodevolucaodefeito) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        enviodevolucaodefeito = manager.merge(enviodevolucaodefeito);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return enviodevolucaodefeito;
    }
    
    public void salvarDevolucaoDefetio(int idDevolucaoDefeito, int idEnvio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Devolucaodefeito devolucaodefeito= manager.find(Devolucaodefeito.class, idDevolucaoDefeito);
        if (devolucaodefeito!=null){
            devolucaodefeito.setNumeroEnvio(idEnvio);
            devolucaodefeito.setDataEnvio(new Date());
            devolucaodefeito.setDevolucaoEnviada("Sim");
            manager.merge(devolucaodefeito);
        }
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public void salvarDevolucaoDefeitoProduto(Enviodevolucaodefeitoproduto enviodevolucaodefeitoproduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(enviodevolucaodefeitoproduto);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Enviodevolucaodefeito> listarEnvioDevolucaoDefeito(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select e FROM Enviodevolucaodefeito e where e.empresa=" + idEmpresa +
                " and e.recebida='Não' order by e.data");
        List<Enviodevolucaodefeito> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public Enviodevolucaodefeito consultarEnvioDevolucaoDefeito(int idEnvio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Enviodevolucaodefeito envioDevolucao = manager.find(Enviodevolucaodefeito.class, idEnvio);
        manager.close();
        if (envioDevolucao!=null){
            return envioDevolucao;
        }
        //fechando uma transação
        return null;
    }
    
}
