/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Regras.GiroProdutoController;
import Singleton.ConexaoSingleton;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.View.Viewconsultaprodutogrupo;
import view.ViewConsultaProdutoFornecedor;


/**
 *
 * @author wolverine
 */
public class GiroProdutoDao {
    
    private EntityManager manager;
    
    
    
    public void criarTabelas(String sql) throws SQLException{
        try {  
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            try {  
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:8082/jgdynamic", "root", "simples");  
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();  
                
                              
                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                stm.execute("Drop Table if exists relGiro"); //Tabela a ser crada com suas respectivas informações 
                
                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                stm.execute(sql); //Tabela a ser crada com suas respectivas informações  
                  
                stm.close();  
                conn.close(); 
                
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
    }
    
    public void SalvarValores(String sql) throws SQLException{
        try {  
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            try {  
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:8082/jgdynamic", "root", "simples");  
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();  
                  
                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                stm.executeUpdate(sql); //Tabela a ser crada com suas respectivas informações  
                  
                stm.close();  
                conn.close();  
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
    }
    
    
    public List<ViewConsultaProdutoFornecedor> listarProdutofornecedor(int idFornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select f From ViewConsultaProdutoFornecedor f where f.idfornecedor="+ idFornecedor);
        return  q.getResultList();
    }
    
    public List<Viewconsultaprodutogrupo> listarProdutoGrupo(int idSubGrupo, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select f From Viewconsultaprodutogrupo f where f.subgrupoprodutoidsubGrupoProduto="+ idSubGrupo + " and f.empresaIdempresa=" + idEmpresa);
        return  q.getResultList();
    }
    
    public ResultSet listarGiro(String nomeRelatorio) throws IOException {
        try {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:8082/jgdynamic", "root", "simples");
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();

                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                String sql = "Select * from relGiro order by descricao";
                rs = stm.executeQuery(sql);
                GiroProdutoController giroProdutoController = new GiroProdutoController();
                
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
                FileWriter excelFile = new FileWriter("relGiroVendas.xls"); // nome do arquivo  
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
