package ua.danit.Servlets;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import ua.danit.Template.Template;
import ua.danit.User;
import ua.danit.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/chat")
public class ChatServlet extends ChoiceServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    User chatter = UserDao.searchUserForChatting(UserDao.usersLiked);

    ArrayList<String> npe = Lists.newArrayList("Hello", "How are you?");

    Template.write("Chat.html",resp.getWriter(), ImmutableMap.of("user", chatter, "message", npe));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String posting = req.getParameter("button");

    User chatter = UserDao.searchUserForChatting(UserDao.usersLiked);

    String message = req.getParameter("message");
    chatter.messages.add(message);
    resp.sendRedirect("/chat");
  }
}
