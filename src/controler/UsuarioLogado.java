/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Acesso;
import model.Usuarios;

/**
 *
 * @author Wolverine
 */
public class UsuarioLogado {
    
    private Usuarios usuario;
    private Acesso acesso;

    public UsuarioLogado() {
        this.usuario = new Usuarios();
        this.acesso = new Acesso();
    }

    
    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    
}
