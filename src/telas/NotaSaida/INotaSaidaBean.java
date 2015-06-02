/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.NotaSaida;

import java.io.File;
import java.util.List;
import model.Cliente;
import model.Docentrada;
import model.Fornecedor;
import model.Municipios;
import model.Terminalcliente;
import telas.ContasReceber.CreditoBean;
import telas.NotaSaida.Fatura.DuplicataBean;
import telas.NotaSaida.Fatura.FaturaBean;

/**
 *
 * @author wolverine
 */
public interface INotaSaidaBean {
    
    void inlcluirProdutoContas(Object objeto);
    void incluirProdutoVenda(Object objeto);
    void consultarCliente(Cliente cliente);
    void finalizarBuscaTerminalCliente(Terminalcliente terminalCliente);
    void carregarArquivoXMLLocalizado(File file);
    void carregarFaturas(FaturaBean fatura, List<DuplicataBean> listaDuplicata);
    void setModel();
    void filtrarNotaSaida(String sql);
    void consultaFornecedor(Fornecedor fornecedor);
    void setMunicipio(Municipios municipios);
    void utilizarCreditos(List<CreditoBean> listaCreditos);
    void setDocEntrada(Docentrada docEntrada);
}
