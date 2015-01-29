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
import model.Saida;
import model.Venda;

/**
 *
 * @author Woverine
 */
public class VendaDao {

    private EntityManager manager;

    public void gravarVendas(Venda venda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(venda);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public void gravarSaida(Saida saida) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(saida);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }

    public int ultimaVendaGravada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idVenda) From Venda");
        int idVenda = (Integer)q.getSingleResult();
        manager.close();
        return idVenda;
    }

    public Venda getVenda(int idVenda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Venda v where v.idvenda=" + idVenda);
        Venda venda = (Venda) q.getSingleResult();
        manager.close();
        return venda;
    }
    
    public List<Venda> getVenda(String sql) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        List<Venda> lista = q.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Saida> listarSaidaVenda(int idVenda)throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select s From Saida s where s.venda=" + idVenda);
        List<Saida> listaSaida = new ArrayList<Saida>();
        listaSaida = q.getResultList();
        manager.close();
        return listaSaida;
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        String sql = "SELECT distinct sum(formavenda.valorrecebido) as valor FROM venda, formavenda " + 
                "where venda.idvenda = formavenda.venda_idvenda and venda.fechaCaixa_idFechaCaixa=" + idFechaCaixa +
                " and formavenda.formapagamento_idformapagamento=" + idFormaPagamento + " and venda.valorVenda>0";     
        Query q = manager.createNativeQuery(sql);
        Double valor;
        valor =  (Double) q.getSingleResult();
        if (valor==null){
            manager.close();
            return 0.0f;
        }else {
            manager.close();
            return valor.floatValue();
        }
        
    }
    
    public List<Venda> ListarVenda(int idFechaCaixa) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Venda v where v.fechacaixa=" + idFechaCaixa +  " and v.valorVenda>0");
        List<Venda> listavenda = new ArrayList<Venda>();
        listavenda = q.getResultList();
        manager.close();
        return listavenda;
    }
    
    public void excluirVendas(Venda venda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        venda = manager.find(Venda.class, venda.getIdvenda());
        manager.remove(venda);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Venda> listarVendaPrazo(String data, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Venda v where v.dataVenda='" + data + "' and v.CondicaoPagamento='A PRAZO' and v.valorVenda>0 and v.empresa=" + idEmpresa);
        List<Venda> listavenda = new ArrayList<Venda>();
        listavenda = q.getResultList();
        manager.close();
        return listavenda;
    }
    
    public double quantidadeVendida(int idProduto, String dataInicial, String dataFinal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        String sql = "Select distinct sum(saida.quantidade) as quantidade FROM venda join saida on venda.idvenda = saida.venda_idvenda";
        sql = sql + " where dataVenda>='" + dataInicial + "'  and dataVenda<='" + dataFinal + "' and produto_idproduto=" + idProduto +
                " and saida.valorVenda>0";
        Query q = manager.createNativeQuery(sql);
        double quantidade =0;
        if (q.getResultList().size()>0){
            if (q.getResultList().get(0)!=null){
                quantidade =(Double) q.getSingleResult();
            }
        }
        manager.getTransaction().commit(); 
        manager.close();
        return quantidade;
    }
    
    public List<Venda> listarVendaPeriodo(String dataInicial, String dataFinal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Venda v where v.dataVenda>='" + dataInicial + "' and v.dataVenda<='" + dataFinal  + 
                "' and v.valorVenda>0");
        List<Venda> listavenda = new ArrayList<Venda>();
        listavenda = q.getResultList();
        manager.close();
        return listavenda;
    }
    
    public double ValorVenda(int idProduto, String dataInicial, String dataFinal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        String sql = "Select distinct sum(saida.valorVenda) as valorVenda FROM venda join saida on venda.idvenda = saida.venda_idvenda";
        sql = sql + " where dataVenda>='" + dataInicial + "'  and dataVenda<='" + dataFinal + "' and produto_idproduto=" + idProduto + 
                " and saida.valorVenda>0";
        Query q = manager.createNativeQuery(sql);
        double valorVenda =0;
        if (q.getResultList().size()>0){
            if (q.getResultList().get(0)!=null){
                valorVenda =(Double) q.getSingleResult();
            }
        }
        manager.close();
        return valorVenda;
    }
    
        
}
