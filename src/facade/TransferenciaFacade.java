/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TransferenciaDao;
import java.sql.SQLException;
import java.util.List;
import model.Tranfereciaproduto;
import model.Transferencia;

/**
 *
 * @author Wolverine
 */
public class TransferenciaFacade {
    
    TransferenciaDao transfereciaDao;
    
    public Transferencia salvarTransferencia(Transferencia transferencia) throws Exception{
         transfereciaDao = new TransferenciaDao();
         return transfereciaDao.salvarTransferencia(transferencia);
    }
    
    public Tranfereciaproduto salvarTransferenciaProduto(Tranfereciaproduto transferenciaProduto) throws Exception{
         transfereciaDao = new TransferenciaDao();
         return transfereciaDao.salvarTransferenciaProduto(transferenciaProduto);
    }
    
    public void excluirTransferenciaProduto(Tranfereciaproduto transferenciaProduto) throws Exception{
         transfereciaDao = new TransferenciaDao();
         transfereciaDao.excluirTransferenciaProduto(transferenciaProduto);
    }
    
    public void excluirTransferencia(Transferencia transferencia) throws Exception{
        transfereciaDao = new TransferenciaDao();
        transfereciaDao.excluirTransferencia(transferencia);
    }
    
    public List<Transferencia> listaTransferencia(String dataInicio) throws SQLException{
        transfereciaDao = new TransferenciaDao();
        return transfereciaDao.listaTransferencia(dataInicio);
    }
    
    public List<Tranfereciaproduto> listaTransferenciaProduto(int idTransferencia) throws SQLException{
        transfereciaDao = new TransferenciaDao();
        return transfereciaDao.listaTransferenciaProduto(idTransferencia);
    }
    
}
