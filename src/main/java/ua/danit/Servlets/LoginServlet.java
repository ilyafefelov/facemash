package ua.danit.Servlets;

import ua.danit.LoginFilter;
import ua.danit.Template.Template;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "login", loadOnStartup = 1, urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public static Map<String,String> loginUsers = new HashMap<String, String>() {{
        put("Rik", "Morty");
        put("Cat", "Dog");
        put("John", "Zoidberg");
        put("Yarik", "admin");
    }};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template.write("login.html", resp.getWriter(), loginUsers);
    }

    public static Map<String, String> tokens =new HashMap<>();

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userName=req.getParameter("userName");
        String password=req.getParameter("password");

        boolean known = loginUsers.containsKey(userName)
                && loginUsers.get(userName).equals(password);

        if(known){

            String token = UUID.randomUUID().toString();
            tokens.put(token, userName);
            resp.addCookie(new Cookie("user-token", token));
            LoginFilter.cookieMap.put(token, userName);
            resp.sendRedirect("/*");
        }else{
            resp.sendRedirect("/login");
        }
    }
}