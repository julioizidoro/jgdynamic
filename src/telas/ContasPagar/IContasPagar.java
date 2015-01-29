/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.ContasPagar;

import java.util.Date;
import java.util.List;
import telas.ControleCheques.ControleChequeBean;

/**
 *
 * @author Wolverine
 */
public interface IContasPagar {
    
    public void setNovaConta();
    public void setPagamento();
    public void setRelContasPagarPeriodo(Date dataInicial, Date dataFinal);
    public void setRelContasPagarFornecedor(int idFornecedor, String razaoSocial);
    public void setRelContasVencidasGeral();
    public void setRelContasVencidasFornecedor(Date dataInicial, Date dataFinal, int idFornecedor, String razaoSocial);
    public void setRelContasPagasPeriodo(Date dataInicial, Date dataFinal);
    public void setRelContasPagasFornecedor(int idFornecedor, String razaoSocial, Date dataInicial, Date dataFinal);
    public void setRelContasPagasPlanoContas(int idConta, String descricao, Date dataInicial, Date dataFinal);
    public void setListaCheques(List<ControleChequeBean> listaCheque, double valorFornecedor);
}
