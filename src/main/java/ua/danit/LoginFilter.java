package ua.danit;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "cookieFilter", urlPatterns = "/*")
public class LoginFilter implements Filter{

    static Set<String> publicsUrls = new HashSet<String>() {{ add("/login");}};
    public static Map<String, String> cookieMap = new HashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie [] cookies = req.getCookies();
        boolean logined = false;

        for(Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();

            if(name.equals("user-token")&& cookieMap.containsKey(value)){
                logined = true;

            }
        }

        if(logined || publicsUrls.contains(req.getRequestURI())) {
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
