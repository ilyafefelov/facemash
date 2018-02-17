package ua.danit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        ServletHolder holder = new ServletHolder(new HelloServlet());
        handler.addServlet(holder, "/*");

        ServletHolder liked = new ServletHolder(new LikedPeopleServlet());
        handler.addServlet(liked, "/liked");

        ServletHolder chat = new ServletHolder(new ChatServlet());
        handler.addServlet(chat, "/chat");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}