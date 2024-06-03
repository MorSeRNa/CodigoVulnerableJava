import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LackOfAccessControlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        File file = new File("/secure/files/" + fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             PrintWriter out = response.getWriter()) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        }
    }
}
