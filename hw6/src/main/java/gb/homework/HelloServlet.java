package gb.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet implements Servlet {

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        servletResponse.getWriter().println("<html><body>");
        servletResponse.getWriter().println("<h1>Hello World</h1>");
        servletResponse.getWriter().println("</body><html>");

    }

    @Override
    public String getServletInfo() {
        return "Hello World servlet";
    }

    @Override
    public void destroy() {

    }
}
