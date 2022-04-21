/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.zaposleni;


import domen.Zaposleni;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;


/**
 *
 * @author Katarina
 */
@Stateless
public class SBZaposleni implements SBZaposleniLocal {

    @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;

    @Override
    public Zaposleni vratiZaposlenog(Integer zaposleniID) {
        return em.find(Zaposleni.class, zaposleniID);
    }

    @Override
    public List<Zaposleni> vratiListuZaposlenih() {
        return em.createNamedQuery("Zaposleni.findAll").getResultList();
    }

    @Override
    public void sacuvajZaposlenog(Zaposleni zaposleni) {
        em.merge(zaposleni);

    }

    @Override
    public void obrisiZaposlenog(Zaposleni zaposleni) {
        em.remove(em.merge(zaposleni));
    }

    @Override
    public Zaposleni izmena(Integer zaposleniID, Zaposleni zaposleni) {
       
            zaposleni.setZaposleniId(zaposleniID);

            em.merge(zaposleni);
           
       
     return zaposleni;}

    @Override
    public List<Zaposleni> vratiZaposlenogPoID() {
       return em.createNamedQuery("Zaposleni.findByZaposleniId").getResultList();
    }

    @Override
    public List<Zaposleni> vratiListuZaposlenihPoJMBG() {
        return em.createNamedQuery("Zaposleni.findByJmbg").getResultList();
    }
}
    