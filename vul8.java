import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InputValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        try {
            int number = Integer.parseInt(data);
            if (number > 10) {
                response.getWriter().println("Data is greater than 10");
            } else {
                response.getWriter().println("Data is not greater than 10");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid input");
        }
    }
}
