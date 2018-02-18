package ua.danit.Servlets;

import ua.danit.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/chat")
public class ChatServlet extends HelloServlet{
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//    User thisUser = switcher.searchUserForChatting();
//
//    TemplateWriteFile.write(resp.getWriter(), thisUser);

    resp.getWriter().write("HI");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
