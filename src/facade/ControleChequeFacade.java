/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ControleChequeDao;
import java.sql.SQLException;
import java.util.List;
import model.ChequeFechaCaixa;
import model.ChequeMovBanco;
import model.ChequeMovCaixa;
import model.Contolechequefornecedor;
import model.Controlecheques;

/**
 *
 * @author Wolverine
 */
public class ControleChequeFacade {
    
    ControleChequeDao controleChequeDao;
    
    public void salvarCehque(Controlecheques cheque) throws Exception {
       controleChequeDao = new ControleChequeDao();
       controleChequeDao.salvarCehque(cheque);
    }
    
    public List<Controlecheques> listarCheques(String sql) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.listarCheques(sql);
    }
    
    public List<Contolechequefornecedor> consultarFornecedor(int idForneceodr) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarFornecedor(idForneceodr);
    }
    
    public void salvarFornecedor(Contolechequefornecedor fornecedor) throws Exception {
        controleChequeDao = new  ControleChequeDao();
        controleChequeDao.salvarFornecedor(fornecedor);
    }
    
    public Controlecheques consultarCheque(int idControleCheques) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarCheque(idControleCheques);
    }
    
    public Contolechequefornecedor consultarFornecedorCheque(int idControleCheques) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarFornecedorCheque(idControleCheques);
    }
    
    public ChequeFechaCaixa salvarCehqueFechaCaixa(ChequeFechaCaixa chequeFechaCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarCehqueFechaCaixa(chequeFechaCaixa);
    }
    
    public ChequeMovBanco salvarChequeMovBanco(ChequeMovBanco chequeMovBanco) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarChequeMovBanco(chequeMovBanco);
    }
    
    public ChequeMovCaixa salvarChequeMovCaixa(ChequeMovCaixa chequeMovCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarChequeMovCaixa(chequeMovCaixa);
    }
    
    public float calcularValorChequesCompensarDia(String data) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.calcularValorChequesCompensarDia(data);
    }
    
    public List<ChequeFechaCaixa>  ListaChequesCaixa(int idFechaCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.ListaChequesCaixa(idFechaCaixa);
    }
}
