import javax.script.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class EvalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expression = request.getParameter("expression");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            Object result = engine.eval(expression);
            response.getWriter().println("Result: " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
