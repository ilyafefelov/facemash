package ua.danit;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(urlPatterns = "/liked")
public class ServletWithLikedPeople extends HelloServlet {
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Set<User> users = switcher.likedUsers();

//    if(thisUser == null){
//      resp.sendRedirect("/chat");
//      return;
//    }
    for (User user : users)
      TemplateForLiked.write(resp.getWriter(), user);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
