package Controller;

import Model.Account;
import Model.Blog;
import Model.DatabaseConnection;
import Model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "ServletMyblog", urlPatterns = "/ServletMyblog")
public class ServletMyblog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String name = (String)session.getAttribute("account"); //取出账户数据
        Account account = new Account(); //创建用户对象
        account.setAccount(name);
        List<Blog> myblogs = UserService.showMyblog(account);

        req.setAttribute("myblogs", myblogs);
        req.getRequestDispatcher("myblog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
