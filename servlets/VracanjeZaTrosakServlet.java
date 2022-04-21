/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Trosak;
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
import sb.trosak.SBTrosakLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "VracanjeZaTrosakServlet", urlPatterns = {"/VracanjeZaTrosakServlet"})
public class VracanjeZaTrosakServlet extends HttpServlet {

    @EJB
    private SBZaposleniLocal sbZap;
    
    @EJB
    private SBTrosakLocal sbTrosak;
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
            System.out.println("hello");
          String  idTemp = request.getParameter("trID");
        int  id = Integer.parseInt(idTemp);
            System.out.println(id);
          
       List<Trosak> selektovaniTrosak = new ArrayList<>();
       
       Trosak trosakZaRacun = sbTrosak.vratiTrosak(id);
        String naziv = trosakZaRacun.getNaziv();
        
        
        selektovaniTrosak.add(trosakZaRacun);
        System.out.println(selektovaniTrosak);
      request.setAttribute("selektovaniTrosak", selektovaniTrosak);
        
        
  RequestDispatcher rd = request.getRequestDispatcher("./UnosRacunaZaTrosak.jsp");
 // RequestDispatcher rd2 = request.getRequestDispatcher("./PretragaRacuna.jsp");
  RequestDispatcher rd1 = request.getRequestDispatcher("./IzmenaTroskovaServlet.jsp");
 
  
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
           ex.printStackTrace();
        }
          
        //request.setAttribute("getNewsById", DataAccess.getNewById(id));
        
      
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
        System.out.println("cao");
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
