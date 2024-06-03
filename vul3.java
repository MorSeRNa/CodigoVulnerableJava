import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CommandInjectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String directory = request.getParameter("directory");
        ProcessBuilder pb = new ProcessBuilder("ls", directory);
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        PrintWriter out = response.getWriter();
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }
}
