/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import model.Encerramento;
import model.Inventario;

/**
 *
 * @author Wolverine
 */
public class EncerramentoDao {
    
    private EntityManager manager;
    
    public Encerramento salvar(Encerramento encerramento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        encerramento = manager.merge(encerramento);
        manager.getTransaction().commit(); 
        manager.close();
        return encerramento;
    }
    
    public List<Encerramento> listar() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select e from Encerramento e order by ano");
        List<Encerramento> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public void salvar(Inventario inventario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        manager.merge(inventario);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Inventario> listar(int idEncerramento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select i from Inventario i where i.encerramento.idencerramento=" + idEncerramento + " order by i.produto.descricao");
        List<Inventario> lista = q.getResultList();
        manager.getTransaction().commit(); 
        manager.close();
        return lista;
    }
    
    public ResultSet ExportarInventario(String nomeRelatorio, int idEncerramento) throws IOException {
        try {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:8082/jgdynamic", "root", "simples");
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();

                stm.execute("USE jgdynamic"); //Nome do DATABASE A SER ACESSADO  
                String sql = "Select * from viewExportarInventario where idencerramento=" + idEncerramento + " order by descricao";
                rs = stm.executeQuery(sql);
                
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
                FileWriter excelFile = new FileWriter(nomeRelatorio); // nome do arquivo  
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
