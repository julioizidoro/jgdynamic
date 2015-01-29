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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.FechamentoCliente;
import model.FechamentoMes;
import view.ViewClienteFechamento;

/**
 *
 * @author wolverine
 */
public class FechamentoContasReceberDao {
    
    private EntityManager manager;
    
    public FechamentoMes salvarFechamentoMes(FechamentoMes mes) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        mes = manager.merge(mes);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return mes;
    }
    
    public FechamentoCliente salvarFechamentoCliente(FechamentoCliente fechamentoCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fechamentoCliente = manager.merge(fechamentoCliente);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return fechamentoCliente;
    }
    
    public void  apagarFechamentoCliente(FechamentoCliente fechamentoCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fechamentoCliente = manager.find(FechamentoCliente.class, fechamentoCliente.getIdfechamentoCliente());
        //fechando uma transação
        manager.remove(fechamentoCliente);
        manager.getTransaction().commit();
        manager.close();
    }
    
    
    public FechamentoCliente consultarFechamentoCliente(int idcliente, int mes) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT f FROM FechamentoCliente f WHERE f.cliente ="+ idcliente + " and f.fechamentoMes=" + mes);
        FechamentoCliente fecha = null;
        if (q.getResultList().size()>0){
            fecha =  (FechamentoCliente) q.getResultList().get(0);
        }
        manager.close();
        return fecha;
    }
    
    public List<FechamentoCliente> ListaFechamentoCliente(int idFechamentoMes) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT f FROM FechamentoCliente f WHERE f.fechamentoMes ="+ idFechamentoMes);
        List<FechamentoCliente> lista = null;
        if (q.getResultList().size()>0){
            lista =   q.getResultList();
        }
        manager.close();
        return lista;
    }
    
    public FechamentoMes consultaFechamentoMes(String mes) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT f FROM FechamentoMes f WHERE f.mes ='"+ mes + "'");
        FechamentoMes fechamentoMes = null;
        if (q.getResultList().size()>0){
            fechamentoMes =   (FechamentoMes) q.getResultList().get(0);
        }
        manager.close();
        return fechamentoMes;
        
    }
    
    
    //View
    
    public List<ViewClienteFechamento> consultaFechamentoCliente(int idMes) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("SELECT f FROM ViewClienteFechamento f WHERE f.fechamentomesIdfechamentomes ="+ idMes + " order by f.nome");
        List<ViewClienteFechamento> lista = null;
        if (q.getResultList().size()>0){
            lista =  q.getResultList();
        }
        manager.close();
        return lista;
        
    }
    
    
    
    public void exportarFechamentoClinte(String nomeRelatorio, String linhaBanco, String banco, String sql, String usuario, String senha) throws IOException {
        try {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {
                com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(linhaBanco, usuario, senha);
                com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement) conn.createStatement();

                stm.execute(banco); //Nome do DATABASE A SER ACESSADO  
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
                FileWriter excelFile = new FileWriter("FechamentoCliente.xls"); // nome do arquivo  
                excelFile.write(new String(contenu)); //aqui ele passa a String para salvar  
                excelFile.close();
                JOptionPane.showMessageDialog(null, "Relatorio Gerado");
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
    
}
