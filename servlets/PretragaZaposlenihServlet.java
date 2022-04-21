
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
//import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.jboss.weld.servlet.SessionHolder;
import sb.tip.SBTipLocal;
import sb.zaposleni.SBZaposleniLocal;

/**
 *
 * @author Katarina
 */
@WebServlet("/pretraga")
@ManagedBean
public class PretragaZaposlenihServlet extends HttpServlet {

    @EJB
    private SBZaposleniLocal sbZaposleni;
    @EJB
    private SBTipLocal sbTip;
    String tip1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PrintWriter writer = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            List<Tip> tip = sbTip.vratiListuTipa();
            request.setAttribute("tip", tip);
            List<Zaposleni> lista = sbZaposleni.vratiListuZaposlenih();
            List<Zaposleni> lista1 = new ArrayList<>();
            tip1 = request.getParameter("tip");
            String proba = request.getParameter("proba");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i);
                request.getSession().setAttribute("zap", lista);
                System.out.println(lista.get(i));
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("./PretragaZaposlenih.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script type=\"text/javascript\">"
            );
            out.println("alert('Greška prilikom učitavanja zaposlenih');");
            out.println("</script>");
            request.getRequestDispatcher("template.jsp").include(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
        String ime = request.getParameter("ime");
        System.out.println(ime);

        // System.out.println(ID);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
