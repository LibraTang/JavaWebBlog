package Controller;

import Model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteblog", urlPatterns = "/ServletDeleteblog")
public class ServletDeleteblog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService.deleteBlog(req.getParameter("id")); //删除操作
        resp.sendRedirect("/ServletMyblog");
    }
}
