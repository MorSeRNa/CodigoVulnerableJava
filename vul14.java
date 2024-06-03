import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InsecureCookieAttributesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("sessionID", "123456");
        // Missing secure attribute
        response.addCookie(cookie);
        response.getWriter().println("Cookie set without secure attribute");
    }
}
