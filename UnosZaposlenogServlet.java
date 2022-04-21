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
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.tip.SBTip;
import sb.tip.SBTipLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet("/unos")
@ManagedBean
public class UnosZaposlenogServlet extends HttpServlet {

    @EJB
    private SBZaposleniLocal sbZaposleni;
    @EJB
    private SBTipLocal sbTip;

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
    int id;
    List<Zaposleni> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();

        try {

            ime = request.getParameter("ime");

            prezime = request.getParameter("prezime");
            JMBG = request.getParameter("JMBG");
            username = request.getParameter("username");
            password = request.getParameter("password");
            tip1 = request.getParameter("tip");

            Tip t = new Tip(Integer.parseInt(tip1));

            Zaposleni zap = new Zaposleni();

            zap.setZaposleniId(id);
            zap.setIme(ime);
            zap.setPrezime(prezime);
            zap.setJmbg(JMBG);
            zap.setUsername(username);
            zap.setPassword(password);
            zap.setTip(t);

            lista = sbZaposleni.vratiListuZaposlenih();

            for (Zaposleni z : lista) {
                if (z.getJmbg().equals(JMBG) && !z.equals(zap)) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('Korisnik sa tim JMBG već postoji!');");
                    out.println("</script>");

                    request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);
                    return;
                }
            }
            if (JMBG.length() != 13) {
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">"
                );
                out.println("alert('JMBG mora sadržati 13 karaktera!');");
                out.println("</script>");
                request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);

                return;

            }
            for (int i = 0; i < JMBG.length(); i++) {
                if (!Character.isDigit(JMBG.charAt(i))) {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('JMBG se mora sastojati isključivo od brojeva!');");
                    out.println("</script>");
                    request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);

                }
            }
            if (daLiJeEmail(username) != true) {
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">"
                );
                out.println("alert('Username mora biti e-mail adresa!');");
                out.println("</script>");
                request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);
            }
            for (Zaposleni z : lista) {
                if (username.equals(z.getUsername())) {
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('Vec postoji zaposleni sa tom mejl adresom.');");
                    out.println("</script>");
                    request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);
                    return;
                }
            }

            sbZaposleni.sacuvajZaposlenog(zap);

            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Uspešno ste sačuvali zaposlenog.');");
            out.println("</script>");
            request.getRequestDispatcher("template.jsp").include(request, response);
            //request.getRequestDispatcher("./proba.jsp").include(request, response);

            // request.getRequestDispatcher("./template.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Greška prilikom čuvanja zaposlenog!');");
            out.println("</script>");
        }

    }

    public static boolean daLiJeEmail(String vrednost) {
        return vrednost.matches("^([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)$");
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
        List<Tip> tip = sbTip.vratiListuTipa();
        System.out.println(tip.toString());
        request.setAttribute("tip", tip);
        request.getRequestDispatcher("/UnosZaposlenogMenadzer.jsp").forward(request, response);

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
