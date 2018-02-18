package ua.danit.Servlets;

import ua.danit.Template.TemplateWriteFile;
import ua.danit.User;
import ua.danit.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(loadOnStartup = 1, urlPatterns = "/*")
public class HelloServlet extends HttpServlet {
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User thisUser = switcher.showLikedUsers();

    if(thisUser == null){
      resp.sendRedirect("/liked");
      return;
    }

    TemplateWriteFile.write("index.html", resp.getWriter(), thisUser);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String posting = req.getParameter("button");
    User user = switcher.showLikedUsers();

    if("Yes".equals(posting)){
      UserDao.usersLiked.add(user);
      resp.sendRedirect("/");
    }else if("No".equals(posting)) {
      UserDao.usersDisliked.add(user);
      resp.sendRedirect("/");
    }
  }

}