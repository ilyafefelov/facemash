package ua.danit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;

class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    FileReader file = new FileReader("/home/DI/ydegtyar/danit/Tinder/src/main/resources/Index.html");

    char[] words = new char[10000];
    file.read(words);
    words.toString();

    resp.getWriter().write(words);
  }
}