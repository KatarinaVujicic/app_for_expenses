/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.vrstatroska;

import domen.Vrstatroska;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Katarina
 */
@Local
public interface SBVrstaTroskaLocal {
    Vrstatroska vratiVrstuTroska(Integer vrstaTroskaID);
    List<Vrstatroska>vratiListuVrstiTroska();
}
