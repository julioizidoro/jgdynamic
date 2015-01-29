/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TransferenciaSaidaDao;
import java.sql.SQLException;
import java.util.List;
import model.Saidatransferencia;
import model.Saidatransferenciaproduto;

/**
 *
 * @author Wolverine
 */
public class TransferenciaSaidaFacade {
    
    TransferenciaSaidaDao transferenciaSaidaDao;
    
    public Saidatransferencia salvarTransferencia(Saidatransferencia transferencia) throws Exception{
        transferenciaSaidaDao = new TransferenciaSaidaDao();
        return transferenciaSaidaDao.salvarTransferencia(transferencia);
    }
    
    public Saidatransferenciaproduto salvarTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) throws Exception{
        transferenciaSaidaDao = new TransferenciaSaidaDao();
        return transferenciaSaidaDao.salvarTransferenciaProduto(transferenciaProduto);
    }
    
    public void excluirTransferenciaProduto(Saidatransferenciaproduto transferenciaProduto) throws Exception{
        transferenciaSaidaDao.excluirTransferenciaProduto(transferenciaProduto);
    }
    
    public void excluirTransferencia(Saidatransferencia transferencia) throws Exception{
         transferenciaSaidaDao.excluirTransferencia(transferencia);
    }
    
    public List<Saidatransferencia> listaTransferencia(String dataInicio, String dataFinal) throws SQLException{
        transferenciaSaidaDao = new TransferenciaSaidaDao();
        return transferenciaSaidaDao.listaTransferencia(dataInicio, dataFinal);
        
    }
    
    public List<Saidatransferenciaproduto> listaTransferenciaProduto(int idTransferencia) throws SQLException{
        transferenciaSaidaDao = new TransferenciaSaidaDao();
        return transferenciaSaidaDao.listaTransferenciaProduto(idTransferencia);
    }
    
}
