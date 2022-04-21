/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.zaposleni;

import domen.Zaposleni;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Katarina
 */
@Local
public interface SBZaposleniLocal {
    List<Zaposleni> vratiZaposlenogPoID();
     Zaposleni vratiZaposlenog(Integer zaposleniID);
    List<Zaposleni> vratiListuZaposlenih();
     void sacuvajZaposlenog(Zaposleni zaposleni);
    void obrisiZaposlenog(Zaposleni zaposleni);
    Zaposleni izmena(Integer zaposleniID,Zaposleni zaposleni);
    List<Zaposleni> vratiListuZaposlenihPoJMBG();
}
