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
import sb.status.SBStatusTroskaLocal;
import sb.trosak.SBTrosakLocal;
import sb.vrstatroska.SBVrstaTroskaLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "IzmenaTroskovaServlet", urlPatterns = {"/IzmenaTroskovaServlet"})
@ManagedBean
public class IzmenaTroskovaServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();
      try{
          String  idTrosak = request.getParameter("trID");
        int  idTroska = Integer.parseInt(idTrosak);
            System.out.println("tu sam");
         
          naziv = request.getParameter("naziv");
    
      
        String dat = request.getParameter("datum");
        System.out.println(dat);
            
      
          datum = new SimpleDateFormat("yyyy-MM-dd").parse(dat);
            System.out.println("ovo je:"+datum);
          
       
           
            opis = request.getParameter("opis");
            System.out.println(opis);
            
             String  idTemp = request.getParameter("zaposleniId");
             System.out.println(idTemp);
        int  id = Integer.parseInt(idTemp);
      Vrstatroska vt = new Vrstatroska(Integer.parseInt(request.getParameter("vt")));
      Statustroska st = new Statustroska(Integer.parseInt(request.getParameter("StatusTroska")));
          System.out.println("ststus je" +st);
      Zaposleni zap = sbZap.vratiZaposlenog(id);
            Trosak tr = new Trosak(idTroska);
            
            
            tr.setNaziv(naziv);
            tr.setDatum(datum);
            tr.setOpis(opis);
            tr.setStatusTroska(st);
            tr.setVrstaTroska(vt);
            tr.setZaposleni(zap);
            System.out.println(tr);
            sbTrosak.sacuvajTrosak(tr);
            
       request.getRequestDispatcher("./PretragaTroskovaServlet").forward(request, response);}
       catch(Exception e){
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
           response.setContentType("text/html;charset=UTF-8");
     
        request.getRequestDispatcher("./IzmenaTroska.jsp").forward(request, response);
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
