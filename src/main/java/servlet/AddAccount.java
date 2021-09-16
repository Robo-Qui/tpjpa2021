package servlet;

import jpa.business.Professionnel;
import jpa.business.Utilisateur;
import jpa.dao.ProfessionnelManager;
import jpa.dao.UtilisateurManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addaccount", urlPatterns = "/addAccount")
public class AddAccount extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");

        if(request.getParameter("type") != null){
            if(request.getParameter("type").equals("Professionnel")){
                createProf(request,response);
            }
            else{
                createUtil(request,response);
            }
        }
        else{
            response.getWriter().println("<HTML>\n<BODY>\n" +
            "<H1>PK SE NULL</H1>");
        }
    }

    public void createProf(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException{
        ProfessionnelManager profMan = new ProfessionnelManager();
        if(profMan.getProfessionnelByLogin(request.getParameter("login"))==null){
            profMan.save(new Professionnel(request.getParameter("login"),
                                           request.getParameter("password"),
                                           request.getParameter("name")));
        }

        PrintWriter out = response.getWriter();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Type:"
                + request.getParameter("type") + "\n" +
                " <LI>Login: "
                + request.getParameter("login") + "\n" +
                " <LI>Password: "
                + request.getParameter("password") + "\n" +
                " <LI>Name: "
                + request.getParameter("name") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }

    public void createUtil(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException{
        UtilisateurManager utilMan = new UtilisateurManager();
        utilMan.save(new Utilisateur(request.getParameter("login"),
                                     request.getParameter("password")));

        PrintWriter out = response.getWriter();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Type:"
                + request.getParameter("type") + "\n" +
                " <LI>Login: "
                + request.getParameter("login") + "\n" +
                " <LI>Password: "
                + request.getParameter("password") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}
