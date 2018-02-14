package pl.dominisz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp, "<h1>Jestem w metodzie GET</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp, "<h1>Jestem w metodzie POST</h1>");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp, "<h1>Jestem w metodzie PUT</h1>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp, "<h1>Jestem w metodzie DELETE</h1>");
    }

    private void process(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(message);
        out.println("<ul>");
        Enumeration<String> parameters = req.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            String value = req.getParameter(parameter);
            out.println("<li>" + parameter + " - " + value + "</li>");
        }
        out.println("</ul>");
    }

    //http://localhost:8080/servlettemplate/welcome?param1=value&name=ala&kot=mruczek
}
