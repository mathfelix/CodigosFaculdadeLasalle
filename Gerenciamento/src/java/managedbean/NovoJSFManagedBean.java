/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author aluno.unilasalle
 */
@Named(value = "novoJSFManagedBean")
@SessionScoped
public class NovoJSFManagedBean implements Serializable {

    private String teste;
    /**
     * Creates a new instance of NovoJSFManagedBean
     */
    public NovoJSFManagedBean() {
    }

    /**
     * @return the teste
     */
    public String getTeste() {
        return teste;
    }

    /**
     * @param teste the teste to set
     */
    public void setTeste(String teste) {
        this.teste = teste;
    }
    
}
