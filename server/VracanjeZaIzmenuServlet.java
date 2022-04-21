/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Tip;
import domen.Zaposleni;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.tip.SBTipLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "testServlet", urlPatterns = {"/testServlet"})
public class VracanjeZaIzmenuServlet extends HttpServlet {

    @EJB
    private SBTipLocal sbTip;
    @EJB
    private SBZaposleniLocal sbZap;
    //Zaposleni zap;
    List<Zaposleni> lista;
    List<Tip> listaTipa;
    Tip tip;
    Zaposleni zaposleni;
    List<Zaposleni> listaZaposlenih;
    public boolean izmena;
    String ime;
    String prezime;
    String username;
    String password;
    String JMBG;
    String tip1;

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

        String idTemp = request.getParameter("ZaposleniId");
        int id = Integer.parseInt(idTemp);

        List<Zaposleni> selektovani = new ArrayList<>();

        Zaposleni zaposleniZaEdit = sbZap.vratiZaposlenog(id);
        String imeZap = zaposleniZaEdit.getIme();

        selektovani.add(zaposleniZaEdit);
        System.out.println(selektovani);
        request.setAttribute("selektovani", selektovani);
        System.out.println(imeZap);
        List<Tip> tip = sbTip.vratiListuTipa();
        System.out.println(tip.toString());
        request.setAttribute("tip", tip);

        RequestDispatcher rd = request.getRequestDispatcher("./IzmenaZaposlenog.jsp");
        //request.setAttribute("getNewsById", DataAccess.getNewById(id));
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">"
        );
        out.println("alert('Sistem je učitao podatke o zaposlenom');");
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
//         String  idTemp = request.getParameter("ZaposleniId");
//        int  id = Integer.parseInt(idTemp);
//        
//        Zaposleni zap = sbZap.vratiZaposlenog(id);
//        
//        request.setAttribute("imeZaposlenog1", zap.getIme());
//        
//        
//        
//        System.out.println(zap.getIme());
//         List<Tip> tip = sbTip.vratiListuTipa();
//        System.out.println(tip.toString());
//        request.setAttribute("tip", tip);
//
//        //request.setAttribute("getNewsById", DataAccess.getNewById(id));
//        RequestDispatcher rd = request.getRequestDispatcher("./IzmenaZaposlenog.jsp");
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
