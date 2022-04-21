/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.vrstatroska;

import domen.Vrstatroska;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katarina
 */
@Stateless
public class SBVrstaTroska implements SBVrstaTroskaLocal {

    @PersistenceContext(unitName = "EJBJspPU")
    private EntityManager em;

    @Override
    public Vrstatroska vratiVrstuTroska(Integer vrstaTroskaID) {
        return em.find(Vrstatroska.class, vrstaTroskaID);

    }

    @Override
    public List<Vrstatroska> vratiListuVrstiTroska() {
        return em.createNamedQuery("Vrstatroska.findAll").getResultList();
    }

   
}
