/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Trosak;
import domen.Vrstatroska;
import domen.Zaposleni;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.trosak.SBTrosakLocal;
import sb.vrstatroska.SBVrstaTroskaLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@ManagedBean
@WebServlet(name = "PretragaTroskovaServletZaposleni", urlPatterns = {"/PretragaTroskovaServletZaposleni"})
public class PretragaTroskovaServletZaposleni extends HttpServlet {

    @EJB
    private SBTrosakLocal sbTrosak;
    @EJB
    private SBZaposleniLocal sbZaposleni;
    @EJB
    private SBVrstaTroskaLocal sbVrstaTroska;

    int id;
    String naziv;
    Vrstatroska vrstaTroska;
    Date datum;
    String opis;
    Zaposleni zaposleni;
    Trosak trosak;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();
        try {
            String idZap = request.getParameter("zaposleniId");
            System.out.println(idZap);
            int id = Integer.parseInt(idZap);
            Zaposleni zap = new Zaposleni(id);
            List<Trosak> lista = sbTrosak.vratiListuTroskova();
            List<Trosak> lista1 = new ArrayList<>();

            for (Trosak t : lista) {
                System.out.println("tu sam");
                System.out.println(id);
                if (id == t.getZaposleni().getZaposleniId()) {
                    System.out.println(t.getZaposleni().getZaposleniId());

                    trosak = sbTrosak.vratiTrosak(t.getTrosakID());
                    lista1.add(trosak);

                    request.getSession().setAttribute("lista1", lista1);
                    request.setAttribute("lista1", lista1);

                }
            }

            request.getRequestDispatcher("./PretragaTroskovaZaposleni.jsp").forward(request, response);
//        request.getRequestDispatcher("./PretragaTroskovaSupervizor.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
              response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Ne postoje troškovi sa zadatim vrednostima');");
            out.println("</script>");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
