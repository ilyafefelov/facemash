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

        server.setHandler(handler);
        server.start();
        server.join();
    }

}