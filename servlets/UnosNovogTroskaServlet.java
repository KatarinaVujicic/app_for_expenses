/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Statustroska;
import domen.Trosak;
import domen.Vrstatroska;
import domen.Zaposleni;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.status.SBStatusTroska;
import sb.status.SBStatusTroskaLocal;
import sb.trosak.SBTrosakLocal;
import sb.vrstatroska.SBVrstaTroskaLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "UnosNovogTroska", urlPatterns = {"/UnosNovogTroska"})
@ManagedBean
public class UnosNovogTroskaServlet extends HttpServlet {

    @EJB
    private SBTrosakLocal sbTrosak;

    @EJB
    private SBVrstaTroskaLocal sbVrsta;
    @EJB
    private SBStatusTroskaLocal sbStatus;
    @EJB
            private SBZaposleniLocal sbZap;

    int trosakID;
    String naziv;
    Vrstatroska vrstaTroska;
    Date datum;
    String opis;
    Zaposleni zaposleni;
    Statustroska status;
    List<Trosak> lista = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
      
        }
       
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
         List<Vrstatroska> vr = sbVrsta.vratiListuVrstiTroska();
        System.out.println(vr.toString());
        request.setAttribute("vr", vr);
        request.getRequestDispatcher("/UnosTroska.jsp").forward(request, response);
        
          
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();

     try{
         
            System.out.println("tu sam");
         
          naziv = request.getParameter("naziv");
    
      
        String dat = request.getParameter("datum");
        System.out.println(dat);
            
        try {
          datum = new SimpleDateFormat("yyyy-MM-dd").parse(dat);
            System.out.println("ovo je:"+datum);
          
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(UnosNovogTroskaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            opis = request.getParameter("opis");
            System.out.println(opis);
            
             String  idTemp = request.getParameter("zaposleniId");
             System.out.println(idTemp);
        int  id = Integer.parseInt(idTemp);
      Vrstatroska vt = new Vrstatroska(Integer.parseInt(request.getParameter("vrstaTroska")));
      Statustroska st = new Statustroska(3);
      Zaposleni zap = sbZap.vratiZaposlenog(id);
            Trosak tr = new Trosak();
            
            
            tr.setNaziv(naziv);
            tr.setDatum(datum);
            tr.setOpis(opis);
            tr.setStatusTroska(st);
            tr.setVrstaTroska(vt);
            tr.setZaposleni(zap);
            sbTrosak.sacuvajTrosak(tr);
           
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('Uspešno ste kreirali novi trošak');");
                    out.println("</script>");
            request.getRequestDispatcher("./PretragaTroskovaServletZaposleni").include(request, response);
//       request.getRequestDispatcher("./templateSupervizor.jsp").forward(request, response);
     }
       catch(Exception e){
       e.printStackTrace();
         response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('Greška prilikom čuvanja troška');");
                    out.println("</script>");
                    request.getRequestDispatcher("./templateSupervizor.jsp").forward(request, response);
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
