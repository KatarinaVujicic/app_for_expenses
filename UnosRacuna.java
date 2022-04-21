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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.racun.SBRacunLocal;

/**
 *
 * @author Katarina
 */
@ManagedBean
@WebServlet(name = "UnosRacuna", urlPatterns = {"/UnosRacuna"})
public class UnosRacuna extends HttpServlet {

    Date datum;
    @EJB
    private SBRacunLocal sbRacun;
  int rb;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            double ui = Double.parseDouble(request.getParameter("ui"));
            if(ui<0){
            return;
            }
             String dat = request.getParameter("datum");
        System.out.println(dat);
            
        try {
          datum = new SimpleDateFormat("yyyy-MM-dd").parse(dat);
            System.out.println("ovo je:"+datum);
          
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(UnosNovogTroskaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int brojRacuna = Integer.parseInt(request.getParameter("brojRacuna"));
          String  idZapp = request.getParameter("idZap");
            System.out.println(idZapp);
        int  idZaposlenog = Integer.parseInt(idZapp);
         String  idTroska= request.getParameter("trosakID");
            System.out.println(idTroska);
        int  id = Integer.parseInt(idTroska);
        
            Zaposleni zaposleni = new Zaposleni(idZaposlenog);
            Trosak tr = new Trosak(id);
            Racun r = new Racun();
            r.setBrojRacuna(rb);
            r.setRBRacuna(brojRacuna);
            r.setDatum(datum);
            r.setTrosak(tr);
            r.setZaposleni(zaposleni);
            r.setUkupanIznos(ui);
            sbRacun.sacuvajRacun(r);
       request.getRequestDispatcher("./PretragaRacunaServlet").forward(request, response);
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
