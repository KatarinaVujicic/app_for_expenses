/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.tip;

import domen.Tip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Katarina
 */
@Local
public interface SBTipLocal {
 
    Tip vratiTip(Integer tipID);
    List<Tip>vratiListuTipa();
}
