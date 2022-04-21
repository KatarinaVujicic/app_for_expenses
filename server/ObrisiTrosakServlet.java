/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Racun;
import domen.Trosak;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Katarina
 */
@WebServlet(name = "ObrisiTrosakServlet", urlPatterns = {"/ObrisiTrosakServlet"})
public class ObrisiTrosakServlet extends HttpServlet {

  @EJB
  private SBTrosakLocal sbTrosak;
  @EJB
          private SBRacunLocal sbRacun;
    List<Trosak> listaTroskova;
    
    List<Racun> listaRacuna = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();
      try{    //int id1 =Integer.parseInt(request.getParameter("trosakID"));
          String  idTemp = request.getParameter("troID");
        int  id = Integer.parseInt(idTemp);
        System.out.println(id);
        Trosak tr = new Trosak(id);
          for(Racun r : listaRacuna){
          if(r.getTrosak().equals(tr))sbRacun.obrisiRacun(r);
          }
        
           // int id = Integer.parseInt(id1);
               
               
               sbTrosak.obrisiTrosak(tr);
      //  processRequest(request, response);
        response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Uspešno ste obrisali trošak');");
            out.println("</script>");
            
           request.getRequestDispatcher("./template.jsp").include(request, response);}
      catch(Exception e){
      e.printStackTrace();
      
      response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Greška prilikom brisanja troška');");
            out.println("</script>");
           request.getRequestDispatcher("./template.jsp").include(request, response);}
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
