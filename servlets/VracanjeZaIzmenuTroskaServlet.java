/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Statustroska;
import domen.Trosak;
import domen.Vrstatroska;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.status.SBStatusTroskaLocal;
import sb.trosak.SBTrosakLocal;
import sb.vrstatroska.SBVrstaTroskaLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "VracanjeZaIzmenuTroskaServlet", urlPatterns = {"/VracanjeZaIzmenuTroskaServlet"})
public class VracanjeZaIzmenuTroskaServlet extends HttpServlet {

    @EJB
    private SBZaposleniLocal sbZap;

    @EJB
    private SBTrosakLocal sbTrosak;
    @EJB
    private SBVrstaTroskaLocal sbVrsta;
    @EJB
    private SBStatusTroskaLocal sbStatus;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VracanjeZaIzmenuTroskaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VracanjeZaIzmenuTroskaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idTemp = request.getParameter("trID");
        int id = Integer.parseInt(idTemp);
        System.out.println("trosak" + id);

        List<Trosak> selektovaniTrosakZaIzmenu = new ArrayList<>();

        Trosak trosakZaRacun = sbTrosak.vratiTrosak(id);
        String naziv = trosakZaRacun.getNaziv();

        selektovaniTrosakZaIzmenu.add(trosakZaRacun);
        System.out.println(selektovaniTrosakZaIzmenu);
        request.setAttribute("selektovaniTrosakZaIzmenu", selektovaniTrosakZaIzmenu);

        List<Vrstatroska> vr = sbVrsta.vratiListuVrstiTroska();
        System.out.println(vr.toString());
        request.setAttribute("vr", vr);

        List<Statustroska> st1 = sbStatus.vratiListuStatusa();
        System.out.println(st1.toString());
        request.setAttribute("st1", st1);

        RequestDispatcher rd = request.getRequestDispatcher("./IzmenaTroska.jsp");
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">"
        );
        out.println("alert('Sistem je učitao podatke o trošku');");
        out.println("</script>");

        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
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
