package ua.danit.Servlets;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import ua.danit.Template.TemplateWriteFile;
import ua.danit.User;
import ua.danit.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/chat")
public class ChatServlet extends HelloServlet{
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    User chatter = UserDao.searchUserForChatting(UserDao.usersLiked);

    ArrayList<String> npe = Lists.newArrayList("Hi", "How are you?");

    TemplateWriteFile.write("Chat.html",resp.getWriter(), ImmutableMap.of("message", npe, "user", chatter));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User chatter = UserDao.searchUserForChatting(UserDao.usersLiked);

    String message = req.getParameter("message");
    chatter.messages.add(message);
    resp.sendRedirect("/chat");
  }
}
