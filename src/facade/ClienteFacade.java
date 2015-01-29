/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ClienteDao;
import java.sql.SQLException;
import model.Cliente;
import model.Clienteendereco;
import java.util.*;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ClienteFacade {
     
    ClienteDao clienteDao;
    
     public Cliente salvarCliente(Cliente cliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarCliente(cliente);
    }
    
    public Cliente consultarDocFederal(String docFederal) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarDocFederal(docFederal);
    }
    
    public Cliente consultarClienteId(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteId(idCliente);
    }
    
    public List<Cliente> consultarCliente() throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarCliente();
    }
    
    public List<Cliente> consultarClienteNome(String nome) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteNome(nome);
    }
    
    public List<Cliente> consultarClienteTipoCadastro(int operacao) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteTipoCadastro(operacao);
    }
    
    public Clientepessoajuridica consultarClientePessoaJuridica(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClientePessoaJuridica(idCliente);
    }
    
    public Clientepessoafisica consultarClientePessoaFisica(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClientePessoaFisica(idCliente);
    }
    
    public Clientecondominio consultarClienteCondominio(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteCondominio(idCliente);
    }
    
    public Clientefechamento consultarClienteFechamento(int idCliente) throws SQLException{
        clienteDao= new ClienteDao();
        return clienteDao.consultarClienteFechamento(idCliente);
    }
    
    
    //Classe Cliente Endereco
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarEndereco(endereco);
    }
    
    public Clienteendereco consultarClienteEndereco(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteEndereco(idCliente);
    }
    
    
    
    
    //Cliente Socio
    
    public List<Clientesocios> listarClienteSocios(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarClienteSocios(idCliente);
    }
    
     public Clientesocios salvarSocios(Clientesocios clienteSocios) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarSocios(clienteSocios);
    }
    
    public Clientepessoajuridica salvarPessoaJuridica(Clientepessoajuridica clientepessoajuridica) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarPessoaJuridica(clientepessoajuridica);
    }
    
    public Clientecondominio salvarCondominio(Clientecondominio clientecondominio) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarPessoaCondominio(clientecondominio);
    }
    
    public Clientepessoafisica salvarPessoaFisica(Clientepessoafisica clientepessoafisica) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarPessoaFisica(clientepessoafisica);
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) throws SQLException{
        clienteDao= new ClienteDao();
        return clienteDao.salvarFechamento(clientefechamento);
    }
    
    public List<Clienteautorizados> listarAutorizados(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarAutorizados(idCliente);
    }
    
    public Clienteautorizados salvarAutorizado(Clienteautorizados clienteautorizados) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarAutorizado(clienteautorizados);
    }
    
    public void excluirClienteAutorizado(Clienteautorizados clienteautorizados) throws SQLException{
        clienteDao = new ClienteDao();
        clienteDao.excluirClienteAutorizado(clienteautorizados);
    }
    
    public List<Clienteenderecoentrega> listarEnderecoEntrega(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarEnderecoEntrega(idCliente);
    }
    
    public void excluirEndercoEntrega(Clienteenderecoentrega clienteenderecoentrega) throws SQLException{
        clienteDao = new ClienteDao();
        clienteDao.excluirEndercoEntrega(clienteenderecoentrega);
    }
    
    public Clienteenderecoentrega salvarEnderecoEntrega(Clienteenderecoentrega clienteenderecoentrega) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarEnderecoEntrega(clienteenderecoentrega);
    }
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarClienteHistorico(idCliente);
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        clienteDao = new ClienteDao();
        clienteDao.excluirClienteHistorico(clienteHistorico);
    }
    
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarClienteHistorico(clienteHistorico);
    }
    
    public Clientedocumentos salvarDocumentoCliente(Clientedocumentos documento) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarDocumentoCliente(documento);
    }
    
    public void ExcluirDocumentoCliente(Clientedocumentos documento) throws SQLException{
        clienteDao = new ClienteDao();
        clienteDao.ExcluirDocumentoCliente(documento);
    }
    
    public List<Clientedocumentos> listarDocumentos(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarDocumentos(idCliente);
    }
}
