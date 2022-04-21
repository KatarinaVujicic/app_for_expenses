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
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.tip.SBTipLocal;
import sb.zaposleni.SBZaposleniLocal;
import static server.UnosZaposlenogServlet.daLiJeEmail;

/**
 *
 * @author Katarina
 */
@WebServlet(name = "IzmenaZaposlenogServlet", urlPatterns = {"/IzmenaZaposlenogServlet"})
@ManagedBean
public class IzmenaZaposlenogServlet extends HttpServlet {

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
    // int id;
    List<Zaposleni> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();
        // String t = tip.getNaziv();
        try {
//id = 5;
            String idTemp = request.getParameter("idZap");
            int id = Integer.parseInt(idTemp);
            ime = request.getParameter("ime");
            //out.println(ime);
            prezime = request.getParameter("prezime");
            JMBG = request.getParameter("JMBG");
            username = request.getParameter("username");
            password = request.getParameter("password");
            tip1 = request.getParameter("tip");
            //out.println(tip1);
            Tip t = new Tip(Integer.parseInt(tip1));

//                 if(JMBG.equals(zaposleni.getJmbg()))
//               out.println("Postoji vec");
////                
//            
            Zaposleni zap = new Zaposleni(id);

            zap.setZaposleniId(id);
            zap.setIme(ime);
            zap.setPrezime(prezime);
            zap.setJmbg(JMBG);
            zap.setUsername(username);
            zap.setPassword(password);
            zap.setTip(t);

            lista = sbZaposleni.vratiListuZaposlenih();

            if (JMBG.length() != 13) {
                out.println("<script type=\"text/javascript\">"
                );
                out.println("alert('JMBG mora imati 13 karaktera.');");
                out.println("</script>");
                request.getRequestDispatcher("/IzmenaZaposlenogServlet").include(request, response);
                return;
            }
            for (int i = 0; i < JMBG.length(); i++) {
                if (!Character.isDigit(JMBG.charAt(i))) {
                    out.println("<script type=\"text/javascript\">"
                    );
                    out.println("alert('JMBG se mora sastojati samo iz brojeva.');");
                    out.println("</script>");
                    request.getRequestDispatcher("/IzmenaZaposlenogServlet").include(request, response);

                }
            }
      if (daLiJeEmail(username) != true) {
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">"
                );
                out.println("alert('Username mora biti e-mail adresa!');");
                out.println("</script>");
                  response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Neuspešna izmena zaposlenog');");
            out.println("</script>");
                request.getRequestDispatcher("UnosZaposlenogMenadzer.jsp").include(request, response);
            }
          
            sbZaposleni.sacuvajZaposlenog(zap);

            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Uspešno ste izmenili zaposlenog.');");
            out.println("</script>");
            response.sendRedirect("./pretraga");
           // r("/pretraga").include(request, response);
            

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Greška prilikom čuvanja novog zaposlenog!');");
            out.println("</script>");
            request.getRequestDispatcher("/Proba").include(request, response);
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
        List<Tip> tip = sbTip.vratiListuTipa();
        System.out.println(tip.toString());
        request.setAttribute("tip", tip);
        request.getRequestDispatcher("/IzmenaZaposlenog.jsp").forward(request, response);
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
          response.setContentType("text/html;charset=UTF-8");
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

    public static boolean daLiJeEmail(String vrednost) {
        return vrednost.matches("^([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)$");
    }
}
