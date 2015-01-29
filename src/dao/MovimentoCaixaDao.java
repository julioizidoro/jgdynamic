/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Singleton.ConexaoSingleton;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Movimentocaixa;


/**
 *
 * @author Wolverine
 */
public class MovimentoCaixaDao {
    
    private EntityManager manager;

    public Movimentocaixa consultarMovimentoCaixa(int idMovimentoCaixa) throws Exception {
        Query query = manager.createQuery("Select c From Caixa c where idMovimentocaixa=" + idMovimentoCaixa);
        Movimentocaixa movimentocaixa = (Movimentocaixa) query.getSingleResult();
        manager.close();
        return movimentocaixa;
    }

    public Movimentocaixa salvarCaixa(Movimentocaixa caixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            manager.getTransaction().begin();
            caixa = manager.merge(caixa);
            manager.getTransaction().commit(); 
            manager.close();
            return caixa;
          }catch(Exception ex){
              if (manager.getTransaction().isActive()){
                  manager.getTransaction().rollback();
              }
              throw new Exception("Erro ao Salvar no Banco de Dados", ex);
          }
    }
    
    public void excluirCaixa(Movimentocaixa caixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            manager.getTransaction().begin();
            caixa = manager.find(Movimentocaixa.class, caixa.getIdmovimentoCaixa());
            manager.remove(caixa);
            manager.getTransaction().commit(); 
            manager.close();
          }catch(Exception ex){
              if (manager.getTransaction().isActive()){
                  manager.getTransaction().rollback();
              }
              throw new Exception("Erro ao excluir no Banco de Dados", ex);
          }
    }


    public List<Movimentocaixa> conusltarMovimentoCaixas(String descricao, String data) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            Query q = manager.createQuery("SELECT c FROM Movimentocaixa c WHERE c.descricao Like '%" + descricao + "%' and "
                    + " c.dataMovimento='" + data + "'  order by c.descricao");
            List<Movimentocaixa> lista = q.getResultList();
            manager.close();
            return lista;
        }catch(Exception ex){
            throw new Exception("Erro de consulta", ex);
        }


    }

    public List<Movimentocaixa> consultarMovimentoCaixa(String data) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select c  From Movimentocaixa c where  c.dataMovimento='"  + data + "'  order by c.idmovimentoCaixa");
                //manager.createQuery("Select c from Movimentocaixa c where (c.data>='" + inicio +
             //   "')  and (c.data<='" + fim + "') order by c.data" );
        List<Movimentocaixa> listaCaixa = new ArrayList<Movimentocaixa>();
        listaCaixa = query.getResultList();
        manager.close();
        return listaCaixa;
    }

    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim, int planoContas) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select c From Movimentocaixa c Where (c.data>='" + inicio
                + "')  and (c.data<='" + fim + "')  and (c.conta=" + planoContas + ")  order by c.data");

        List<Movimentocaixa> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select c From Movimentocaixa c Where (c.data>='" + inicio
                + "')  and (c.data<='" + fim + "')  order by c.data");
        List<Movimentocaixa> lista = query.getResultList();
        manager.close();
        return lista;
    }

    public List<Double> calculaSaldos(String dataCaixa) throws SQLException {
        Double valor;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(dataMovimento='" + dataCaixa + "')");
        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(dataMovimento='" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(dataMovimento<'" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(dataMovimento<'" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);
        manager.close();
        return saldo;
    }
    
    
    public List<Double> calculaSaldosRelatorio(String dataInicial, String dataFinal) throws SQLException {
        Double valor;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(dataMovimento>='" + dataInicial + "') and (dataMovimento<='" + dataFinal + "')");
        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(dataMovimento>='" + dataInicial + "') and (dataMovimento<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(dataMovimento<'" + dataInicial + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(dataMovimento<'" + dataInicial + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);
        manager.close();
        return saldo;
    }

    public Movimentocaixa consultaMovimentoCaixa(String sql) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery(sql);
        Movimentocaixa movimentocaixa = (Movimentocaixa) query.getResultList().get(0);
        manager.close();
        return movimentocaixa;
    }

    public double getSaldoAnterior(String dataCaixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(data<'" + dataCaixa + "')");
        Double valor = null;
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
        }
        manager.close();
        return valor.doubleValue();
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal ) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        Double valor;
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(data<'" + dataInicio + "')");

        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From movimentocaixa where(data<'" + dataInicio + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From movimentocaixa where(data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as entrada " +
                "From movimentocaixa where(data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor =  (Double) query.getSingleResult();
            saldo.add(valor.doubleValue());
        }else saldo.add(0.0);
        manager.close();
        return saldo;
    }
    
    public ResultSet ExportarExcel(String nomeRelatorio, String local, String porta, String senha, String banco, String usuario, String caminhoSalvarExcel, String dataInicial, String dataFinal) throws IOException {
        try {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {String conexao = "jdbc:mysql://" + local + ":" + porta + "/" + banco;
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(conexao, usuario, senha);
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();

                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                String sql = "Select * from viewmovimentocaixa where dataMovimento>='" + dataInicial +
                        "' and dataMovimento<='" + dataFinal + "'";
                rs = stm.executeQuery(sql);
                //GiroProdutoController giroProdutoController = new GiroProdutoController();
                
                    StringBuffer contenu; //// acho que seria melhor usar o StringBuilder
                    contenu = new StringBuffer("");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
                    contenu.append(rsMeta.getColumnLabel(i) + "\t"); /// nesta linha imprime somente os nome dos campos da tabela  
                }
                contenu.append("\n"); // e temos que colocar todos os dados no StringBuffer  
                rs.beforeFirst();
                while (rs.next()) {
                    for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
                        contenu.append(rs.getString(i) + "\t"); /// aqui mostra todos os dados  
                    }
                    contenu.append("\n");

                } //fim do while  
                //agora, salvando o StringBuffer no arquivo  
                FileWriter excelFile = new FileWriter(caminhoSalvarExcel); // nome do arquivo  
                excelFile.write(new String(contenu)); //aqui ele passa a String para salvar  
                excelFile.close();
                JOptionPane.showMessageDialog(null, "Relatorio Gerado");
                return rs;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
