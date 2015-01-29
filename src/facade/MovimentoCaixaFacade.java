/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.MovimentoCaixaDao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Movimentocaixa;


/**
 *
 * @author Wolverine
 */
public class MovimentoCaixaFacade {

    private MovimentoCaixaDao movimentoCaixaDao;

    public Movimentocaixa consultarMovimentoCaixa(int idMovimentoCaixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(idMovimentoCaixa);
    }

    public Movimentocaixa salvarCaixa(Movimentocaixa caixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.salvarCaixa(caixa);
    }
    
    public void excluirCaixa(Movimentocaixa caixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        movimentoCaixaDao.excluirCaixa(caixa);
    }


    public List<Movimentocaixa> conusltarMovimentoCaixas(String descricao, String data) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.conusltarMovimentoCaixas(descricao, data);
    }

    public List<Movimentocaixa> consutlarMovimentoCaixa(String data) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(data);
    }

    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim, int planoContas) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(inicio, fim, planoContas);
    }

    public List<Double> calculaSaldos(String dataCaixa) throws SQLException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.calculaSaldos(dataCaixa);
    }
    
    public List<Double> calculaSaldosRelatorio(String dataInicial, String dataFinal) throws SQLException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.calculaSaldosRelatorio(dataInicial, dataFinal);
    }

    public Movimentocaixa consultaMovimentoCaixa(String sql) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultaMovimentoCaixa(sql);
    }

    public double getSaldoAnterior(String dataCaixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.getSaldoAnterior(dataCaixa);
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal ) throws SQLException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.calculaSaldos(dataInicio, dataFinal);
    }
    
    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(inicio, fim);
    }
    
    public ResultSet ExportarExcel(String nomeRelatorio, String local, String porta, String senha, String banco, String usuario, String caminhoSalvarExcel, String dataInicial, String dataFinal) throws IOException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.ExportarExcel(nomeRelatorio, local, porta, senha, banco, usuario, caminhoSalvarExcel, dataInicial, dataFinal);
    }

}
