package Controller;

import Model.Account;
import Model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletLogin", urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        ResultSet rs = null;
        conn = DatabaseConnection.dbconnect(conn);

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        List<String> info = new ArrayList<>(); //用一个list保存登录结果

        if(account == null || account.equals("")) { //用户名格式问题
            info.add("用户名不能为空");
            System.out.println("用户名不能为空");
        }
        if(password == null || password.equals("")) { //密码格式问题
            info.add("密码不能为空");
            System.out.println("密码不能为空");
        }

        sql = "SELECT account FROM accinfo WHERE account=? and password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                info.add("登录成功");
                HttpSession session = req.getSession(); //创建session对象
                session.setAttribute("account", account); //保存用户数据
            }else {
                info.add("登录失败，用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //保存信息并跳转
        req.setAttribute("info", info);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
