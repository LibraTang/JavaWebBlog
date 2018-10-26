package Controller;

import Model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletRegister", urlPatterns = "/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;

        conn = DatabaseConnection.dbconnect(conn);
        sql = "INSERT INTO accinfo (account, password, confirmedpassword) VALUES (?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, req.getParameter("account"));
            pstmt.setString(2, req.getParameter("password"));
            pstmt.setString(3, req.getParameter("confirmedPassword"));
            pstmt.executeUpdate();

            resp.sendRedirect("success.jsp");
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
