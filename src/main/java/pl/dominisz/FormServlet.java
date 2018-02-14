package pl.dominisz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/processform")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String acceptance = req.getParameter("acceptance");
        String sex = req.getParameter("sex");
        String hardware = req.getParameter("hardware");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your details</h1>");
        out.println("Username: " + username + "<br>");
        out.println("Terms and conditions: " + acceptance + "<br>");
        out.println("Sex: " + sex + "<br>");
        out.println("Gaming platform: " + hardware + "<br>");
    }

}
