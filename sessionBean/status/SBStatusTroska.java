/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.status;

import domen.Statustroska;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katarina
 */
@Stateless
public class SBStatusTroska implements SBStatusTroskaLocal{

    @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;
    @Override
    public Statustroska vratiStatus(Integer statusTroskaID) {
        return em.find(Statustroska.class, statusTroskaID);
    }

    @Override
    public List<Statustroska> vratiListuStatusa() {
   return em.createNamedQuery("Statustroska.findAll").getResultList();
    }
    
}
