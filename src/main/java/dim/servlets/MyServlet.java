package dim.servlets;


// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by dkomp on 28/6/2016.
 */
public class MyServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/new.jsp");
        RequetsDispatcherObj.forward(request, response);

        out.println("<h1>" + message + "</h1>");
    }

    public void destroy()
    {
        // do nothing.
    }
}
