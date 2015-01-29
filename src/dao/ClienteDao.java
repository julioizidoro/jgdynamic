/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Singleton.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ClienteDao {
    
    private EntityManager manager;
    
    
    //Classe Cliente
    public Cliente salvarCliente(Cliente cliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        cliente = manager.merge(cliente);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return cliente;
    }
    
    public Cliente consultarDocFederal(String docFederal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Cliente cliente = null;
        Query q = manager.createQuery("select c from Cliente c where c.docFederal='" + docFederal + "'");
        if (q.getResultList().size()>0){
            cliente =  (Cliente) q.getResultList().get(0);
        }
        manager.close();
        return cliente;
    }
    
    public Cliente consultarClienteId(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente();
        Query q = manager.createQuery("select c from Cliente c where c.idcliente=" + idCliente);
        if (q.getResultList().size()>0){
            cliente =  (Cliente) q.getResultList().get(0);
            manager.getTransaction().commit(); 
            manager.close();
            return cliente;
        }else {            
            manager.getTransaction().commit(); 
            manager.close();
            return null;
        }
    }
    
    public List<Cliente> consultarCliente() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Cliente> listaCliente = null;
        Query q = manager.createQuery("select c from Cliente c order by c.nome" );
        if (q.getResultList().size()>0){
            listaCliente =   q.getResultList();
        }
        manager.close();
        return listaCliente;
    }
    
    public List<Cliente> consultarClienteNome(String nome) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Cliente> listaCliente = null;
        Query q = manager.createQuery("select c from Cliente c where c.nome like '" + nome + "%' order by c.nome" );
        if (q.getResultList().size()>0){
            listaCliente =   q.getResultList();
        }
        manager.close();
        return listaCliente;
    }
    
    public List<Cliente> consultarClienteTipoCadastro(int operacao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Cliente> listaCliente = null;
        Query q = manager.createQuery("select c from Cliente c where c.operacao=" + operacao + " order by c.nome" );
        if (q.getResultList().size()>0){
            listaCliente =   q.getResultList();
        }
        manager.close();
        return listaCliente;
    }
    
    public Clientepessoajuridica consultarClientePessoaJuridica(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Clientepessoajuridica clientepessoajuridica = null;
        Query q = manager.createQuery("select c from Clientepessoajuridica c where c.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            clientepessoajuridica =  (Clientepessoajuridica) q.getResultList().get(0);
        }
        manager.close();
        return clientepessoajuridica;
    }
    
    public Clientepessoafisica consultarClientePessoaFisica(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Clientepessoafisica clientepessoafisica = null;
        Query q = manager.createQuery("select c from Clientepessoafisica c where c.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            clientepessoafisica =  (Clientepessoafisica) q.getResultList().get(0);
        }
        manager.close();
        return clientepessoafisica;
    }
    
    public Clientecondominio consultarClienteCondominio(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Clientecondominio clientecondominio = null;
        Query q = manager.createQuery("select c from Clientecondominio c where c.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            clientecondominio =  (Clientecondominio) q.getResultList().get(0);
        }
        manager.close();
        return clientecondominio;
    }
    
    public Clientefechamento consultarClienteFechamento(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Clientefechamento clientefechamento = null;
        Query q = manager.createQuery("select c from Clientefechamento c where c.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            clientefechamento =  (Clientefechamento) q.getResultList().get(0);
        }
        manager.close();
        return clientefechamento;
    }
    
    
    
    
    
    
    
    //Classe Cliente Endereco
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        endereco = manager.merge(endereco);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return endereco;
    }
    
    public Clienteendereco consultarClienteEndereco(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Clienteendereco endereco = null;
        Query q = manager.createQuery("select e from Clienteendereco e where e.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            endereco= (Clienteendereco) q.getResultList().get(0);
        }
        manager.close();
        return endereco;
    }
    
    //Classe Socios
    
    public List<Clientesocios> listarClienteSocios(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Clientesocios> listaClienteSocios = null;
        Query q = manager.createQuery("select c from Clientesocios c where c.clienteIdcliente = " + idCliente + " order by c.nome" );
        if (q.getResultList().size()>0){
            listaClienteSocios =   q.getResultList();
        }
        manager.close();
        return listaClienteSocios;
    }
    
    
    
    public Clientesocios salvarSocios(Clientesocios clienteSocios) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteSocios = manager.merge(clienteSocios);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return clienteSocios;
    }
    
    public Clientepessoajuridica salvarPessoaJuridica(Clientepessoajuridica clientepessoajuridica) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clientepessoajuridica = manager.merge(clientepessoajuridica);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return clientepessoajuridica;
    }
    
    public Clientecondominio salvarPessoaCondominio(Clientecondominio clientecondominio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clientecondominio = manager.merge(clientecondominio);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return clientecondominio;
    }
    
    public Clientepessoafisica salvarPessoaFisica(Clientepessoafisica clientepessoafisica) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clientepessoafisica = manager.merge(clientepessoafisica);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return clientepessoafisica;
    }
    
    public Clienteautorizados salvarAutorizado(Clienteautorizados clienteautorizados) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteautorizados = manager.merge(clienteautorizados);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return clienteautorizados;
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clientefechamento = manager.merge(clientefechamento);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return clientefechamento;
    }
    
    public List<Clienteautorizados> listarAutorizados(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Clienteautorizados> listaAutorizados= null;
        Query q = manager.createQuery("select c from Clienteautorizados c where c.clienteIdcliente = " + idCliente + " order by c.nome" );
        if (q.getResultList().size()>0){
            listaAutorizados =   q.getResultList();
        }
        manager.close();
        return listaAutorizados;
    }
    
    public void excluirClienteAutorizado(Clienteautorizados clienteautorizados) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteautorizados = manager.find(Clienteautorizados.class, clienteautorizados.getIdclienteAutorizados());
        //fechando uma transação
        manager.remove(clienteautorizados);
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Clienteenderecoentrega> listarEnderecoEntrega(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Clienteenderecoentrega> listaEnderecoEntrega= null;
        Query q = manager.createQuery("select c from Clienteenderecoentrega c where c.clienteIdcliente = " + idCliente + " order by c.logradouro" );
        if (q.getResultList().size()>0){
            listaEnderecoEntrega =   q.getResultList();
        }
        manager.close();
        return listaEnderecoEntrega;
    }
    
    public void excluirEndercoEntrega(Clienteenderecoentrega clienteenderecoentrega) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteenderecoentrega = manager.find(Clienteenderecoentrega.class, clienteenderecoentrega.getIdclienteEnderecoEntrega());
        //fechando uma transação
        manager.remove(clienteenderecoentrega);
        manager.getTransaction().commit(); 
        manager.close();
    }
 
    public Clienteenderecoentrega salvarEnderecoEntrega(Clienteenderecoentrega clienteenderecoentrega) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteenderecoentrega = manager.merge(clienteenderecoentrega);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return clienteenderecoentrega;
    }
    
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Clientehistorico> listaClienteHistoricos = null;
        Query q = manager.createQuery("select c from Clientehistorico c where c.cliente = " + idCliente + " order by c.data desc" );
        if (q.getResultList().size()>0){
            listaClienteHistoricos =   q.getResultList();
        }
        manager.close();
        return listaClienteHistoricos;
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteHistorico = manager.find(Clientehistorico.class, clienteHistorico.getIdclienteHistorico());
        //fechando uma transação
        manager.remove(clienteHistorico);
        manager.getTransaction().commit(); 
        manager.close();
    }
 
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteHistorico = manager.merge(clienteHistorico);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return clienteHistorico;
    }
    
    public Clientedocumentos salvarDocumentoCliente(Clientedocumentos documento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        documento = manager.merge(documento);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
        return documento;
    }
    
    public void ExcluirDocumentoCliente(Clientedocumentos documento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        documento = manager.find(Clientedocumentos.class, documento.getIdclienteDocumentos());
        manager.remove(documento);
        //fechando uma transação
        manager.getTransaction().commit(); 
        manager.close();
    }
    
    public List<Clientedocumentos> listarDocumentos(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Clientedocumentos> listaClienteDocumentos = new ArrayList<Clientedocumentos>();
        Query q = manager.createQuery("select c from Clientedocumentos c where c.cliente = " + idCliente + " order by c.nomeDocumento" );
        if (q.getResultList().size()>0){
            listaClienteDocumentos =   q.getResultList();
        }
        manager.close();
        return listaClienteDocumentos;
    }
}
