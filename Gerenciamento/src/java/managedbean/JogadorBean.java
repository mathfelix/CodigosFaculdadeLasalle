/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import facade.JogadorFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import model.Jogador;

/**
 *
 * @author aluno.unilasalle
 */
@Named(value = "jogadorBean")
@SessionScoped
public class JogadorBean extends AbstractBean<Jogador> implements Serializable {
    
    @EJB
    JogadorFacade jogadorFacade;
    /**
     * Creates a new instance of JogadorBean
     */
    public JogadorBean() {
        super(Jogador.class);
    }
    
    @Override
    public String salvar(){
        if(getEdt() != null){
            jogadorFacade.edit(getEdt());
        }else{
            jogadorFacade.create(getObj());
        }
        
        return null;
    }
    
    @Override
    public void cleanUp(){
        super.cleanUp();
    }
    
    @Override
    public String excluir(){
        jogadorFacade.remove(getSelecionado());
        return null;
    }
    
    public String buscar(){
        Jogador c = jogadorFacade.findJogador(getObj().getNome());
        System.out.println("c="+c.getId()+" "+c.getNome());
        return null;
    }
    
    public List<Jogador> getJogadores(){
        return jogadorFacade.findAll();
    }
    
    
}
