/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Cliente;

import model.Municipios;

/**
 *
 * @author Wolverine
 */
public interface Icliente {
    
    void carregarTodosClientes();
    void setMunicipio(Municipios municipios);
    void resetMunicipio();
    
}
