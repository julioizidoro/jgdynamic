/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facadeRemoto;

import facade.*;
import dao.FornecedorDao;
import daoRemoto.FornecedorRemotoDao;
import java.sql.SQLException;
import java.util.List;
import model.Fornecedor;

/**
 *
 * @author Wolverine
 */
public class FornecedorRemotoFacade {

    FornecedorRemotoDao fornecedorDao;

     public List<Fornecedor> consultarFornecedor() throws SQLException{
        fornecedorDao = new FornecedorRemotoDao();
         return fornecedorDao.consultarFornecedor();
    }

    public Fornecedor consultarFornecedor(int idFornecedor) throws SQLException{
        fornecedorDao = new FornecedorRemotoDao();
        return fornecedorDao.consultarFornecedor(idFornecedor);
    }

    public List<Fornecedor> consultarFornecedorRazaoSocial(String razaoSocial, String nomeFantasia) throws SQLException{
        fornecedorDao = new FornecedorRemotoDao();
        return fornecedorDao.consultarFornecedorRazaoSocial(razaoSocial, nomeFantasia);
    }

    public Fornecedor consultarCNPJ(String cnpj){
        fornecedorDao = new FornecedorRemotoDao();
        return fornecedorDao.consultarCNPJ(cnpj);
    }

    public void salvarFronecedor(Fornecedor fornecedor) throws Exception{
         fornecedorDao = new FornecedorRemotoDao();
         fornecedorDao.salvarFronecedor(fornecedor);
    }

    public void excluir(Fornecedor fornecedor) throws Exception{
         fornecedorDao = new FornecedorRemotoDao();
         fornecedorDao.excluir(fornecedor);
    }

    public int getIdFornecedor() throws Exception {
        fornecedorDao = new FornecedorRemotoDao();
        return fornecedorDao.getIdFornecedor();
    }

}
