/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.racun;

import domen.Racun;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Katarina
 */
@Local
public interface SBRacunLocal {
      Racun vratiRacun(Integer racunID);
    List<Racun> vratiListuRacuna();
    void sacuvajRacun(Racun racun);
    void obrisiRacun(Racun racun);
}
