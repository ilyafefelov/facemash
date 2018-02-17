package ua.danit;

import ua.danit.Templates.TemplateWriteFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(loadOnStartup = 1, urlPatterns = "/*")
class HelloServlet extends HttpServlet {
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User thisUser = switcher.showLikedUsersById();

    if(thisUser == null){
      resp.sendRedirect("/liked");
      return;
    }

    TemplateWriteFile.write(resp.getWriter(), thisUser);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String posting = req.getParameter("button");
    User user = switcher.showLikedUsersById();

    if("Yes".equals(posting)){
      UserDao.usersLiked.add(user);
      resp.sendRedirect("/");
    }else if("No".equals(posting)) {
      UserDao.usersDisliked.add(user);
      resp.sendRedirect("/");
    }


  }

}