package ua.danit;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletWithLikedPeople extends HelloServlet {
  UserDao switcher = new UserDao();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();
    writer.write("<html><body>");
    for(User user : switcher.likedUsers()) {
      writer.write("<form action='/' method=\"post\">");
      writer.write("<p><img src='"+user.imgUrl+"' width= 100px height= 100px></p>");
      writer.write  ("<button type='submit' onClick=localhost:8080/chat src='"+user.id+"'>"+user.name+"</button>");
    }
    writer.write("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
