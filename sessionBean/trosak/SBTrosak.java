/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.trosak;

import domen.Trosak;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katarina
 */
@Stateless
public class SBTrosak implements SBTrosakLocal {

    @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;

    @Override
    public Trosak vratiTrosak(Integer trosakID) {
        Trosak t = em.find(Trosak.class, trosakID);
        return t;
    }

    @Override
    public List<Trosak> vratiListuTroskova() {
        return em.createNamedQuery("Trosak.findAll").getResultList();
    }

    @Override
    public void sacuvajTrosak(Trosak trosak) {
        em.merge(trosak);
    }

//    @Override
//    public List<Trosak> vratiListuTroskovaZaZaposlenog(int zaposleniID) {
//           return em.createNamedQuery("Trosak.").getResultList();
//    }

    @Override
    public void obrisiTrosak(Trosak trosak) {
        em.remove(em.merge(trosak));
    }

    
}
