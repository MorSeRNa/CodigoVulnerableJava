import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SQLInjectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:example.db");
             Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM users WHERE id = " + userId;
            ResultSet rs = stmt.executeQuery(query);
            PrintWriter out = response.getWriter();
            while (rs.next()) {
                out.println("User: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
