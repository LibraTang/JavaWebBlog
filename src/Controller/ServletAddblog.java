package Controller;

import Model.Account;
import Model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletAddblog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String name = (String)session.getAttribute("account"); //取出账户数据
        Account account = new Account(); //创建用户对象
        account.setAccount(name);
        UserService.addBlog(account, req.getParameter("blog")); //添加博文

        resp.sendRedirect("/ServletMyblog"); //回到我的博客界面
    }
}
