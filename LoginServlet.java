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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.BreakNode;
import sb.tip.SBTipLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@ManagedBean
public class LoginServlet extends HttpServlet {

    @EJB
    SBZaposleniLocal sbZaposleni;

    @EJB
    SBTipLocal sbTip;

    Tip tip;
    Zaposleni zaposleni;

    String nazivTipa;
    String username;
    String password;
    List<Zaposleni> listaZaposlenih;
    List<Tip> listaTipa;
    String rezultat;
    List<Zaposleni> listaZaVracanje = new ArrayList<>();

    @PostConstruct
    public void inicijalizujPodatke() {

        listaZaposlenih = sbZaposleni.vratiListuZaposlenih();
    }

    public SBZaposleniLocal getSbZaposleni() {
        return sbZaposleni;
    }

    public void setSbZaposleni(SBZaposleniLocal sbZaposleni) {
        this.sbZaposleni = sbZaposleni;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        username = request.getParameter("username");
        password = request.getParameter("password");
        try {

            boolean valid = true;
            for (Zaposleni z : listaZaposlenih) {
              
              
                if (z.getUsername().equals(username)) {
                    System.out.println("probam");
                }
                if (z.getPassword().equals(password)) {
                    System.out.println("ajde molim te"
                    );
                }
                // System.out.println(z.getIme());
                if (z.getUsername().equals(username) && z.getPassword().equals(password)) {
                  
                    zaposleni = sbZaposleni.vratiZaposlenog(z.getZaposleniId());
//                   
                   

//                return "index";
                    valid = true;
// if(zaposleni.getTip().getNaziv()=="Supervizor") response.sendRedirect("proba.html");

                }
                //  System.out.println("ne valja");

            }
            listaZaVracanje.clear();
            listaZaVracanje.add(zaposleni);
            for (Zaposleni zapp : listaZaVracanje) {

                request.getSession().setAttribute("listaZaVracanje", listaZaVracanje);

                request.getRequestDispatcher("./template.jsp");
            }
            request.getRequestDispatcher("./UnosTroska.jsp");
            request.getRequestDispatcher("./template.jsp");
            request.getRequestDispatcher("./.jsp");
            if (valid) {
                int t = zaposleni.getTip().getTipID();
                switch (t) {
                    case 1:

                        System.out.println("1");

                        response.sendRedirect("template.jsp");

                    case 2:
                        System.out.println("2");

                        response.sendRedirect("templateSupervizor.jsp");
                    case 3:
                        System.out.println("3");
                        response.sendRedirect("templateZaposleni.jsp");
                    default:
                        break;

                }
                response.sendRedirect("index.html");

            }

        } catch (Exception e) {
            out = response.getWriter();
          
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Neuspešno prijavljivanje na sistem! Proverite podatke i pokušajte ponovo!');");
            out.println("</script>");
            request.getRequestDispatcher("index.html").include(request, response);
//          request.getRequestDispatcher("index.html").include(request, response);  
//           
//          out.println("Niste uneli dobre podatke!");
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
