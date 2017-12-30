/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Dueño;

/**
 *
 * @author Miranda
 */
@Stateless
public class DueñoFacade extends AbstractFacade<Dueño> {
    @PersistenceContext(unitName = "veterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DueñoFacade() {
        super(Dueño.class);
    }
    
}
