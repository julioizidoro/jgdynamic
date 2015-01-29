/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FechamentoContasReceberDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.FechamentoCliente;
import model.FechamentoMes;
import view.ViewClienteFechamento;

/**
 *
 * @author wolverine
 */
public class FechamentoContasReceberFacade {
    
    FechamentoContasReceberDao fechamentoContasReceberDao;
    
    public FechamentoMes salvarFechamentoMes(FechamentoMes mes) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.salvarFechamentoMes(mes);
    }
    
    public FechamentoCliente salvarFechamentoCliente(FechamentoCliente fechamentoCliente) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.salvarFechamentoCliente(fechamentoCliente);
    }
    
    public void  apagarFechamentoCliente(FechamentoCliente fechamentoCliente) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        fechamentoContasReceberDao.apagarFechamentoCliente(fechamentoCliente);
    }
    
    public FechamentoCliente consultarFechamentoCliente(int idcliente, int mes) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.consultarFechamentoCliente(idcliente, mes);
    }
    
    public List<FechamentoCliente> ListaFechamentoCliente(int idFechamentoMes) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.ListaFechamentoCliente(idFechamentoMes);
    }
    
    public FechamentoMes consultaFechamentoMes(String mes) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.consultaFechamentoMes(mes);
    }
    
    public List<ViewClienteFechamento> consultaFechamentoCliente(int idMes) throws SQLException{
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        return fechamentoContasReceberDao.consultaFechamentoCliente(idMes);
    }
    
    public void exportarFechamentoClinte(String nomeRelatorio, String linhaBanco, String banco, String sql, String usuario, String senha) throws IOException {
        fechamentoContasReceberDao = new FechamentoContasReceberDao();
        fechamentoContasReceberDao.exportarFechamentoClinte(nomeRelatorio, linhaBanco, banco, sql, usuario, senha);
    }
    
}
