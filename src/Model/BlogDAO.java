package Model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    private DataSource dataSource;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private String sql;

    public BlogDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Blog> getBlog(Blog blog) {
        ResultSet rs = null;
        List<Blog> blogs = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            sql = "SELECT txt, date FROM blog WHERE name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, blog.getName());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                blogs.add(new Blog(blog.getName(), rs.getString(2), rs.getTimestamp(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public void addBlog(Blog blog) {
        try {
            conn = dataSource.getConnection();
            sql = "INSERT INTO blog(name, txt, date) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, blog.getName());
            pstmt.setString(2, blog.getTxt());
            pstmt.setTimestamp(3, new Timestamp(blog.getDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void deleteBlog(Blog blog) {
        try {
            conn = dataSource.getConnection();
            sql = "DELETE FROM blog WHERE name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, blog.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
