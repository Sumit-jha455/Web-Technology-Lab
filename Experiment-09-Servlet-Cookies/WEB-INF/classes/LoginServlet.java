import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String USER_CREDENTIALS =
        "user1:pwd1,user2:pwd2,user3:pwd3,user4:pwd4";

    // Create cookie and display login form
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie = new Cookie("userCredentials", USER_CREDENTIALS);
        cookie.setMaxAge(60 * 60);
        cookie.setPath(request.getContextPath());

        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    // Authenticate user using cookie
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userid");
        String password = request.getParameter("password");

        boolean authenticated = false;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("userCredentials".equals(cookie.getName())) {

                    String[] users = cookie.getValue().split(",");

                    for (String user : users) {

                        String[] credentials = user.split(":", 2);

                        if (credentials.length == 2 &&
                            credentials[0].equals(userId) &&
                            credentials[1].equals(password)) {

                            authenticated = true;
                            break;
                        }
                    }
                }
            }
        }

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (authenticated) {
            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + escapeHtml(userId) + "</p>");
        } else {
            out.println("<h2>Invalid User ID or Password!</h2>");
        }

        out.println("<a href='index.html'>Back to Login</a>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}