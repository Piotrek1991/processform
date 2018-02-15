package pl.dominisz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generatepassword")
public class PasswordGeneratorServlet extends HttpServlet {

    private static final String ON = "on";

    private RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int length = Integer.parseInt(req.getParameter("length"));
        boolean useSymbols = ON.equals(req.getParameter("symbols"));
        boolean useNumbers = ON.equals(req.getParameter("numbers"));
        boolean useLowerCase = ON.equals(req.getParameter("lowercase"));
        boolean useUpperCase = ON.equals(req.getParameter("uppercase"));

        String password = randomPasswordGenerator.generate(length,
                useSymbols, useNumbers, useUpperCase, useLowerCase);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your password: " + password + "</h1>");
    }

}
