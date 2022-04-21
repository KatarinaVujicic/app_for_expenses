/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Racun;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.racun.SBRacunLocal;
import sb.trosak.SBTrosakLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@ManagedBean
@WebServlet(name = "PretragaRacunaServlet", urlPatterns = {"/PretragaRacunaServlet"})
public class PretragaRacunaServlet extends HttpServlet {

    @EJB
    private SBTrosakLocal sbTrosak;
    @EJB
    private SBZaposleniLocal sbZaposleni;
    @EJB
    private SBRacunLocal sbRacun;
    Racun rac;

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
        try {
            System.out.println("caos");
            String idTroska = request.getParameter("trosakID");
            System.out.println(idTroska);
            int id = Integer.parseInt(idTroska);

            List<Racun> listaRacuna = sbRacun.vratiListuRacuna();
            List<Racun> listaRacuna1 = new ArrayList<>();
            for (Racun r : listaRacuna) {

                if (id == r.getTrosak().getTrosakID()) {

                    rac = sbRacun.vratiRacun(r.getBrojRacuna());
                    listaRacuna1.add(rac);

                    //  System.out.println(i);
                    request.getSession().setAttribute("listaRacuna1", listaRacuna1);

                    // System.out.println(listaRacuna1.get(i));
                    request.setAttribute("listaRacuna1", listaRacuna1);

                }
            }
            request.getRequestDispatcher("./PretragaRacuna.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
       try {
            System.out.println("caos");
            String idTroska = request.getParameter("trID");
            System.out.println(idTroska);
            int id = Integer.parseInt(idTroska);

            List<Racun> listaRacuna = sbRacun.vratiListuRacuna();
            List<Racun> listaRacuna1 = new ArrayList<>();
            for (Racun r : listaRacuna) {

                if (id == r.getTrosak().getTrosakID()) {

                    rac = sbRacun.vratiRacun(r.getBrojRacuna());
                    listaRacuna1.add(rac);

                    //  System.out.println(i);
                    request.getSession().setAttribute("listaRacuna1", listaRacuna1);

                    // System.out.println(listaRacuna1.get(i));
                    request.setAttribute("listaRacuna1", listaRacuna1);

                }
            }
            request.getRequestDispatcher("./PretragaRacuna.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
         try {
            System.out.println("caos");
            String idTroska = request.getParameter("trosakID");
            System.out.println(idTroska);
            int id = Integer.parseInt(idTroska);

            List<Racun> listaRacuna = sbRacun.vratiListuRacuna();
            List<Racun> listaRacuna1 = new ArrayList<>();
            for (Racun r : listaRacuna) {

                if (id == r.getTrosak().getTrosakID()) {

                    rac = sbRacun.vratiRacun(r.getBrojRacuna());
                    listaRacuna1.add(rac);

                    //  System.out.println(i);
                    request.getSession().setAttribute("listaRacuna1", listaRacuna1);

                    // System.out.println(listaRacuna1.get(i));
                    request.setAttribute("listaRacuna1", listaRacuna1);

                }
            }
            request.getRequestDispatcher("./PretragaRacuna.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
