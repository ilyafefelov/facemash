package ua;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.danit.LoginFilter;
import ua.danit.Servlets.ChatServlet;
import ua.danit.Servlets.ChoiceServlet;
import ua.danit.Servlets.LikedPeopleServlet;
import ua.danit.Servlets.LoginServlet;

import javax.servlet.DispatcherType;
import java.io.IOException;
import java.net.ServerSocket;

public class App {

    public static void main(String[] args) throws Exception {


//        ///////////////////////////////////////////////////
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        ServletHolder holder = new ServletHolder(new ChoiceServlet());
        handler.addServlet(holder, "/*");

        ServletHolder login = new ServletHolder(new LoginServlet());
        handler.addServlet(login, "/login");

//        ServletHolder choice = new ServletHolder(new ChoiceServlet());
//        handler.addServlet(choice, "/choice");

        ServletHolder liked = new ServletHolder(new LikedPeopleServlet());
        handler.addServlet(liked, "/liked");

        ServletHolder chat = new ServletHolder(new ChatServlet());
        handler.addServlet(chat, "/chat");

        LoginFilter loginFilter = new LoginFilter();
        handler.addFilter(new FilterHolder(loginFilter), "/*",
                Sets.newEnumSet(Lists.newArrayList(DispatcherType.REQUEST), DispatcherType.class));

        server.setHandler(handler);
        server.start();
//////////////////////////////////////////
        int portNumber = 4444;
        ServerSocket serverSocket;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println("could not listen on port: " + portNumber);
            System.exit(1);
        }


//        ///////////////////////
        server.join();
    }

}