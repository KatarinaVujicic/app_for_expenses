/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.trosak;

import domen.Trosak;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Katarina
 */
@Local
public interface SBTrosakLocal {
    
    Trosak vratiTrosak(Integer trosakID);
    List<Trosak> vratiListuTroskova();
    void sacuvajTrosak(Trosak trosak);
    void obrisiTrosak(Trosak trosak);
 
}
