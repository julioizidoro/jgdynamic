/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import facade.ClienteFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ClienteController {
    
    private ClienteFacade clienteFacade;
    
    public Cliente salvarCliente(Cliente cliente){
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Clienten " +ex);
            return null;
        }
    }
    
    public Cliente consultarDocFederal(String docFederal) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarDocFederal(docFederal);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Documento Federal " + ex);
            return null;
        }
    }
    
    public Cliente consultarClienteId(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteId(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Cliente pelo Id " + ex);
            return null;
        }
    }
    
    public List<Cliente> consultarCliente() {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Clientes " + ex);
            return null;
        }
    }
    
    public List<Cliente> consultarClienteNome(String nome) {
    clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Clientes por Nome " + ex);
            return null;
        }
    }
    
    public List<Cliente> consultarClienteTipoCadastro(int operacao) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteTipoCadastro(operacao);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Clientes por Tipo de Cadastro " + ex);
            return null;
        }
    }
    
    public List<Clientesocios> listarClienteSocios(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarClienteSocios(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Sócios " + ex);
            return null;
        }
    }
    
    public Clientepessoajuridica consultarClientePessoaJuridica(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClientePessoaJuridica(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Dados Pessoa Jurídica " + ex);
            return null;
        }
    }
    
    public Clientepessoafisica consultarClientePessoaFisica(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClientePessoaFisica(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Dados Pessoa Física " + ex);
            return null;
        }
    }
    
    public Clientecondominio consultarClientecondominio(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteCondominio(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Dados Condominio " + ex);
            return null;
        }
    }
    
    public Clienteendereco consultarClienteEndereco(int idCliente)  {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteEndereco(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Endereço " + ex);
            return null;
        }
    }
    
    public Clientefechamento consultarClienteFechamento(int idCliente){
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteFechamento(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Dados Fechamento " + ex);
            return null;
        }
    }
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarEndereco(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro Salvar Endereço " + ex);
            return null;
        }
    }
    
        
     public Clientesocios salvarSocios(Clientesocios clienteSocios) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarSocios(clienteSocios);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Sócio " + ex);
            return null;
        }
    }
    
    public Clientepessoajuridica salvarPessoaJuridica(Clientepessoajuridica clientepessoajuridica) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarPessoaJuridica(clientepessoajuridica);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Dados Pessoa Jurídica " + ex);
            return null;
        }
    }
    
    public Clientepessoafisica salvarPessoaFisica(Clientepessoafisica clientepessoafisica) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarPessoaFisica(clientepessoafisica);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Dados Pessoa Física " + ex);
            return null;
        }
    }
    
    public Clientecondominio salvarCondominio(Clientecondominio clientecondominio) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarCondominio(clientecondominio);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Dados Condominio " + ex);
            return null;
        }
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarFechamento(clientefechamento);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Dados Fechamento "  + ex);
            return null;
        }
    }
    
    public List<Clienteautorizados> listarAutorizados(int idCliente){
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarAutorizados(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Autorizados " + ex);
            return null;
        }
    }
    
    public Clienteautorizados salvarAutorizado(Clienteautorizados clienteautorizados) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarAutorizado(clienteautorizados);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Autorizado " + ex);
            return null;
        }
    }
    
    public void excluirClienteAutorizado(Clienteautorizados clienteautorizados) {
        clienteFacade = new ClienteFacade();
        try {
            clienteFacade.excluirClienteAutorizado(clienteautorizados);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Autorizado " + ex);
        }
    }
    
    public List<Clienteenderecoentrega> listarEnderecoEntrega(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarEnderecoEntrega(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Endereço de Entrega " + ex);
            return null;
        }
    }
    
    public void excluirEndercoEntrega(Clienteenderecoentrega clienteenderecoentrega) {
        clienteFacade = new ClienteFacade();
        try {
            clienteFacade.excluirEndercoEntrega(clienteenderecoentrega);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Enderço Entrega " + ex);
        }
    }
    
    public Clienteenderecoentrega salvarEnderecoEntrega(Clienteenderecoentrega clienteenderecoentrega) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarEnderecoEntrega(clienteenderecoentrega);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Endereço de Entrega " + ex);
            return null;
        }
    }
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarClienteHistorico(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Histórico " + ex);
            return null;
        }
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) {
        clienteFacade = new ClienteFacade();
        try {
            clienteFacade.excluirClienteHistorico(clienteHistorico);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Histórico " + ex);
        }
    }
    
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarClienteHistorico(clienteHistorico);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Histórico "  + ex);
            return null;
        }
    }
    
    public Clientedocumentos salvarDocumentoCliente(Clientedocumentos documento){
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarDocumentoCliente(documento);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Documento Cliente " + ex);
            return null;
        }
    }
    
    public void ExcluirDocumentoCliente(Clientedocumentos documento) {
        clienteFacade = new ClienteFacade();
        try {
            clienteFacade.ExcluirDocumentoCliente(documento);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Documento Cliente " + ex);
        }
    }
    
    public List<Clientedocumentos> listarDocumentos(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarDocumentos(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar documentos Cliente " + ex);
            return null;
        }
    }
}
