/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Jogador;

/**
 *
 * @author aluno.unilasalle
 */
@Stateless
public class JogadorFacade extends AbstractFacade<Jogador> {

    @PersistenceContext(unitName = "GerenciamentoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JogadorFacade() {
        super(Jogador.class);
    }
    
    public Jogador findJogador(String str){
        String query = "SELECT c "
                + "FROM Categoria c "
                + "WHERE c.nome LIKE '%" + str + "%'";
        return em.createQuery(query, Jogador.class).getSingleResult();
    }
    
}
