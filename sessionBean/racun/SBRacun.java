/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.racun;

import domen.Racun;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katarina
 */
@Stateless
public class SBRacun implements SBRacunLocal {

       @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;
    
    @Override
    public Racun vratiRacun(Integer racunID) {
       return em.find(Racun.class, racunID);
    }

    @Override
    public List<Racun> vratiListuRacuna() {
        return em.createNamedQuery("Racun.findAll").getResultList();
    }

    @Override
    public void sacuvajRacun(Racun racun) {
        em.merge(racun);
    }

    @Override
    public void obrisiRacun(Racun racun) {
        em.remove(em.merge(racun));
    }
    
}
