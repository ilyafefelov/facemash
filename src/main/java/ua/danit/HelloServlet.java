package ua.danit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

class HelloServlet extends HttpServlet {
  UserDao switcher = new UserDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = switcher.showLikedUsersById();

    String name = user.name;
    String url = user.imgUrl;
    int id = user.id;
    PrintWriter writer = resp.getWriter();

    writer.write("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/styles.css\">\n" +
            "<style>\n" +
            "   img{\n" +
            "        width: 300px;\n" +
            "        height: 300px;\n" +
            "    }\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "\n" +
            "<div class=\"row\">");
    writer.write("<img src='"+url+"'>");
    writer.write("<p>"+ name +"</p>");
    writer.write("<form action='/' method=\"post\">");
    writer.write  ("<button type='submit' name='btn' value='Yes'>Yes</button>");
    writer.write(" <button name='btn' value='No'>No</button>\n");
    writer.write(" </form>\n" +
            "</div>\n" +
            "\n" +
            "</div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String posting = req.getParameter("btn");
    User user = switcher.showLikedUsersById();

    if(posting.equals("Yes")){
      UserDao.usersLiked.add(user);
    }else if(posting.equals("No")) {
      UserDao.usersDisliked.add(user);
    }
    resp.sendRedirect("/");
  }

}