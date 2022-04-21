/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Racun;
import domen.Trosak;
import domen.Zaposleni;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.racun.SBRacunLocal;
import sb.trosak.SBTrosakLocal;
import sb.zaposleni.SBZaposleni;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet("/brisanje")
public class ObrisiZaposlenogServlet extends HttpServlet {

    @EJB
    private SBZaposleniLocal sbZaposleni;

    @EJB
    private SBTrosakLocal sbTrosak;
    @EJB
    private SBRacunLocal sbRacun;
    List<Zaposleni> zapp = new ArrayList<>();
    List<Trosak> tr = new ArrayList<>();
    List<Racun> ra = new ArrayList<>();
    //Racun r= new  Racun();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        PrintWriter out = response.getWriter();
        try {

            String idTemp = request.getParameter("zaposleniId");
            int id = Integer.parseInt(idTemp);
            System.out.println(idTemp);
           
            Zaposleni da = new Zaposleni(id);
 for(Racun r : ra){
                System.out.println("KATARINA");
            if(r.getZaposleni().getZaposleniId()==id)sbRacun.obrisiRacun(r);
            }
            for(Trosak t: tr){
            if(t.getZaposleni().equals(da))sbTrosak.obrisiTrosak(t);
            }
            
            sbZaposleni.obrisiZaposlenog(da);
            response.sendRedirect("./pretraga");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Uspešno ste obrisali zaposlenog!');");
            out.println("</script>");
            request.getRequestDispatcher("/proba.jsp").include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Greška prilikom brisanja zaposlenog!');");
            out.println("</script>");
            request.getRequestDispatcher("/proba.jsp").include(request, response);
        }
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
//      zapp  = sbZaposleni.vratiListuZaposlenih();
//        for (int i = 0; i < zapp.size(); i++) {
//
//            System.out.println(i);
//         request.setAttribute("zaposleni", zapp);
//        String imeZapp = request.getParameter("imeZaposlenog");
//            System.out.println(imeZapp);
//        }

        int id1 = Integer.parseInt(request.getParameter("zaposleniID"));

        // int id = Integer.parseInt(id1);
        Zaposleni zap = new Zaposleni(id1);

        sbZaposleni.obrisiZaposlenog(zap);

        //  processRequest(request, response);
        request.getRequestDispatcher("./PretragaZaposlenih.jsp").forward(request, response);

        // request.getRequestDispatcher("./PretragaZaposlenih.jsp").forward(request, response);
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
