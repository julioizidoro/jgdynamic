/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.FornecedorDao;
import java.sql.SQLException;
import java.util.List;
import model.Fornecedor;

/**
 *
 * @author Wolverine
 */
public class FornecedorFacade {

    FornecedorDao fornecedorDao;

     public List<Fornecedor> consultarFornecedor() throws SQLException{
        fornecedorDao = new FornecedorDao();
         return fornecedorDao.consultarFornecedor();
    }

    public Fornecedor consultarFornecedor(int idFornecedor) throws SQLException{
        fornecedorDao = new FornecedorDao();
        return fornecedorDao.consultarFornecedor(idFornecedor);
    }

    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) throws SQLException{
        fornecedorDao = new FornecedorDao();
        return fornecedorDao.consultarFornecedorRazaoSocial(razaoSocial, nomeFantasia);
    }

    public Fornecedor consultarCNPJ(String cnpj){
        fornecedorDao = new FornecedorDao();
        return fornecedorDao.consultarCNPJ(cnpj);
    }

    public Fornecedor salvarFronecedor(Fornecedor fornecedor) throws Exception{
         fornecedorDao = new FornecedorDao();
         return fornecedorDao.salvarFronecedor(fornecedor);
    }

    public void excluir(Fornecedor fornecedor) throws Exception{
         fornecedorDao = new FornecedorDao();
         fornecedorDao.excluir(fornecedor);
    }

    public int getIdFornecedor() throws Exception {
        fornecedorDao = new FornecedorDao();
        return fornecedorDao.getIdFornecedor();
    }

}
