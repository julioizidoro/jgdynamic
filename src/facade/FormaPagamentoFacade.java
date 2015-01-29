/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FormaPagamentoDao;
import java.sql.SQLException;
import java.util.List;
import model.Formapagamento;

/**
 *
 * @author Wolverine
 */
public class FormaPagamentoFacade {
    
    private FormaPagamentoDao formaPagamentoDao;

    public List<Formapagamento> ListarFormaPagamento(int idEmpresa) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.ListaFormaPagamento(idEmpresa);
    }
    
    public Formapagamento getFormaPagamento(int idFormaPagamento) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamento(idFormaPagamento);
    }
    
    public Formapagamento salvar(Formapagamento formaPagamento) throws Exception {
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.salvar(formaPagamento);
    }
    
    public void excluir(Formapagamento formaPagamento) throws Exception {
        formaPagamentoDao = new FormaPagamentoDao();
        formaPagamentoDao.excluir(formaPagamento);
    }
    
    public List<Formapagamento> listarFormaPagamentoValor() throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.listarFormaPagamentoValor();
    }
    
    public List<Formapagamento> getFormaPagamentoBandeiraCartao(int idBandeiraCartao) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamentoBandeiraCartao(idBandeiraCartao);
    }
    
    public List<Formapagamento> getFormaPagamento() throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamento();
    }
    
    public List<Formapagamento> getFormaPagamentoCartao() throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamentoCartao();
    }

}