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
@Named(value = "equipeBean")
@SessionScoped
public class EquipeBean implements Serializable {

    /**
     * Creates a new instance of EquipeBean
     */
    public EquipeBean() {
    }
    
}