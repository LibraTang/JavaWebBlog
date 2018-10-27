package Model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //得到所有博文保存在一个list中并返回
    public static List<Blog> showBlog() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql;
        List<Blog> blogs = new ArrayList<>();
        try {
            conn = DatabaseConnection.dbconnect(conn);
            sql = "SELECT * FROM blog";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Blog blog = new Blog(rs.getString(1), rs.getString(2), rs.getTimestamp(3));
                blogs.add(blog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

            return blogs;
        }
    }

    //得到登录账户的博文
    public static List<Blog> showMyblog(Account account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql;
        List<Blog> blogs = new ArrayList<>();
        try {
            conn = DatabaseConnection.dbconnect(conn);
            sql = "SELECT * FROM blog WHERE name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getAccount());
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Blog blog = new Blog(rs.getString(1), rs.getString(2), rs.getTimestamp(3));
                blogs.add(blog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

            return blogs;
        }
    }
}
