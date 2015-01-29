/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.MovimentoBancoDao;
import java.sql.SQLException;
import java.util.List;
import model.Banco;
import model.Movimentobanco;


/**
 *
 * @author Wolverine
 */
public class MovimentoBancoFacade {

    private MovimentoBancoDao movimentoBancoDao;

    public Movimentobanco consultarMovimentoBanco(int idMovimentoBanco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.consultarMovimentoBanco(idMovimentoBanco);
    }

    public Movimentobanco salvarBanco(Movimentobanco banco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.salvarBanco(banco);
    }


    public List<Movimentobanco> conusltarMovimentoBanco(String descricao, Banco banco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.conusltarMovimentoBanco(descricao, banco);
    }

    public List<Movimentobanco> consutlarMovimentoBanco(String inicio, String fim, Banco banco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.consultarMovimentoBanco(inicio, fim, banco);
    }

    public List<Movimentobanco> MovimentoBanco(String inicio, String fim, int planoContas, Banco banco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.consultarMovimentoBanco(inicio, fim, planoContas, banco);
    }

    public List<Double> calculaSaldos(String dataBanco, Banco banco) throws SQLException {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.calculaSaldos(dataBanco, banco);
    }

    public Movimentobanco consultaMovimentoBanco(String sql) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.consultaMovimentoBanco(sql);
    }

    public double getSaldoAnterior(String dataBanco, Banco banco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.getSaldoAnterior(dataBanco, banco);
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal, Banco banco ) throws SQLException {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.calculaSaldos(dataInicio, dataFinal, banco);
    }
    
    public List<Movimentobanco> consultarMovimentoBancoDia(String data, int idBanco) throws Exception {
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.consultarMovimentoBancoDia(data, idBanco);
    }
    
    public float calcularValorChequesBancoDia(String sql) throws SQLException{
        movimentoBancoDao = new MovimentoBancoDao();
        return movimentoBancoDao.calcularValorChequesBancoDia(sql);
    }

}
