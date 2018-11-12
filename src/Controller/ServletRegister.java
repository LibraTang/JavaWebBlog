package Controller;

import Model.DatabaseConnection;
import Model.Format;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServletRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        List<String> info = new ArrayList<>(); //保存注册信息

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String confirmedpassword = req.getParameter("confirmedPassword");

        if(account == null || account.equals("") || !Format.accountFormat(account)) { //用户名格式问题
            info.add("用户名格式错误");
            System.out.println("用户名格式错误");
            req.setAttribute("info", info);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }
        else if(password == null || password.equals("") || !Format.passFormat(password)) { //密码格式问题
            info.add("密码格式错误");
            System.out.println("密码格式错误");
            req.setAttribute("info", info);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }
        else if(confirmedpassword == null || confirmedpassword.equals("") || !confirmedpassword.equals(password)) {
            info.add("确认密码错误");
            System.out.println("确认密码错误");
            req.setAttribute("info", info);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }
        else{
            try {
                conn = DatabaseConnection.dbconnect(conn);
                //查找是否有相同账户名
                sql = "SELECT account FROM accinfo WHERE account=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, account);
                ResultSet rs = pstmt.executeQuery();
                //若有结果说明账户已经存在
                if(rs.next()) {
                    info.add("账户已存在");
                }else {
                    info.add("注册成功");
                    sql = "INSERT INTO accinfo (account, password, confirmedpassword) VALUES (?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, account);
                    pstmt.setString(2, password);
                    pstmt.setString(3, confirmedpassword);
                    pstmt.executeUpdate();
                }

                //保存信息并跳转
                req.setAttribute("info", info);
                req.getRequestDispatcher("result.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if(conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
