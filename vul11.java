import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Random;

public class InsecureRandomnessServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int token = random.nextInt(999999);
        response.getWriter().println("Your security token is: " + token);
    }
}
