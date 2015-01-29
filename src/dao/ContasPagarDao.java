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
import model.Contaspagar;
import model.Formacontaspagar;
import model.Pagamentocontaspagar;
import model.View.Viewcontaspagar;

/**
 *
 * @author Wolverine
 */
public class ContasPagarDao {
    
    private EntityManager manager;
    
    public Contaspagar salvar(Contaspagar contasPagar) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasPagar = manager.merge(contasPagar);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return contasPagar;
    }
    
    public void excluir(Contaspagar contasPagar) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasPagar = manager.find(Contaspagar.class, contasPagar.getIdcontasPagar());
        manager.remove(contasPagar);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Contaspagar> listarContas(String sql) throws SQLException{
        List<Contaspagar> listaContasPagar = new ArrayList<Contaspagar>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        listaContasPagar = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaContasPagar;
    }
    
    public Formacontaspagar salvarFormaContasPagar(Formacontaspagar formacontaspagar) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        formacontaspagar = manager.merge(formacontaspagar);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return formacontaspagar;
    }
    
    public Pagamentocontaspagar salvarPagamentoContasPagar(Pagamentocontaspagar pagamentocontaspagar) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        pagamentocontaspagar = manager.merge(pagamentocontaspagar);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return pagamentocontaspagar;
    }
    
    public Float calcularValorContaPagarDia(String data) throws SQLException{
        Double valor= 0.0;
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("Select distinct sum(valorConta) as valorConta " +
                "From contaspagar where(dataVencimento='" + data + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        manager.getTransaction().commit(); 
        manager.close();
        return valor.floatValue();
    }
    
    public List<Viewcontaspagar> listarContasView(String sql) throws SQLException{
        List<Viewcontaspagar> listaContasPagar = new ArrayList<Viewcontaspagar>();
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        listaContasPagar = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return listaContasPagar;
    }
    
    public ResultSet ExportarExcel(String nomeRelatorio, String local, String porta, String senha, String banco, String usuario, String caminhoSalvarExcel, String sql) throws IOException {
        try {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {String conexao = "jdbc:mysql://" + local + ":" + porta + "/" + banco;
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(conexao, usuario, senha);
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();

                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
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
