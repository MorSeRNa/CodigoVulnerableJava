import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UnsafeDeserializationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
        try {
            Object obj = ois.readObject();
            response.getWriter().println("Loaded object: " + obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
