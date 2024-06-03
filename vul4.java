import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShellInjectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host = request.getParameter("host");
        Process process = Runtime.getRuntime().exec("ping -c 1 " + host);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        PrintWriter out = response.getWriter();
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }
}
