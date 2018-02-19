package ua.danit.Servlets;


import com.google.common.collect.ImmutableMap;
import ua.danit.Template.Template;
import ua.danit.User;
import ua.danit.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/liked")
public class LikedPeopleServlet extends HelloServlet {
    Set<User> users = UserDao.usersLiked;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


      Template.write("LikedPeople.html", resp.getWriter(), ImmutableMap.of("users", users, "Man", users.iterator().next()));

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name = req.getParameter("chatter");
      UserDao.chatBox = name;
      resp.sendRedirect("/chat");

  }
}
