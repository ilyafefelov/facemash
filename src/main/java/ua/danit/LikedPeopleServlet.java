package ua.danit;


import com.google.common.collect.ImmutableMap;
import ua.danit.Templates.TemplateForLiked;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/liked")
public class LikedPeopleServlet extends HelloServlet {
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Set<User> users = switcher.likedUsers();

      TemplateForLiked.write(resp.getWriter(), ImmutableMap.of("users", users, "Man", users.iterator().next()));

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.sendRedirect("/chat");

  }
}
