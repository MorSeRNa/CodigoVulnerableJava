import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InfoDisclosureServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(InfoDisclosureServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        try {
            int result = Integer.parseInt(a) / Integer.parseInt(b);
            logger.log(Level.INFO, "Dividing {0} by {1}", new Object[]{a, b});
            response.getWriter().println("Result: " + result);
        } catch (ArithmeticException | NumberFormatException e) {
            logger.log(Level.SEVERE, "Exception occurred: ", e);
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
