import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExposeStackTraceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Simulate an error
            throw new Exception("An error occurred");
        } catch (Exception e) {
            e.printStackTrace(response.getWriter()); // Exposing stack trace
        }
    }
}
