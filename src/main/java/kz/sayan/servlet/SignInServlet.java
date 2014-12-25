package kz.sayan.servlet;

import kz.sayan.entity.User;
import kz.sayan.service.Service;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: Sayan.Zhumashev
 * Date: 07.12.14
 * Time: 21:44
 */
@WebServlet(asyncSupported = false, name = "SignIn", urlPatterns = {"/sign_in"})
public class SignInServlet extends HttpServlet {

    @Inject
    private Service service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email=null, password=null;

        if(session.getAttribute("current_user")!=null){
            response.sendRedirect("/EntityManager");
            return;
        }

        if(request.getParameter("request")==null){
            response.sendRedirect("/EntityManager/sign_in.jsp");
            return;
        }

        if(request.getParameter("si_email")!=null && request.getParameter("si_password")!=null){
            email = request.getParameter("si_email");
            password = request.getParameter("si_password");
            session.setAttribute("si_email", email);
            session.setAttribute("si_password", password);

            User user = service.signIn(email, password);

            if(user!=null){
                session.setAttribute("si_error", null);
                session.setAttribute("si_email", null);
                session.setAttribute("si_password", null);
                session.setAttribute("current_user", user);
                response.sendRedirect("/EntityManager");
                return;
            }

        }

        session.setAttribute("si_error", "email or password incorrect");
        response.sendRedirect("/EntityManager/sign_in.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
