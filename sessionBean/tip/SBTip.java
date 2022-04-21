/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.tip;

import domen.Tip;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katarina
 */
@Stateless
public class SBTip implements SBTipLocal {

    @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;

    @Override
    public Tip vratiTip(Integer tipID) {
        Tip t= new Tip(1);
        System.out.println(t);
        return t;
        
    }
    
    @Override
    public List<Tip> vratiListuTipa() {
        return em.createNamedQuery("Tip.findAll").getResultList();
    }

}
