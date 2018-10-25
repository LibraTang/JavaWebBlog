package Model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private DataSource dataSource;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private String sql;

    public AccountDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isAccountExisted(Account account) {
        ResultSet rs = null;
        boolean exist = false;

        try {
            conn = dataSource.getConnection();
            sql = "SELECT * FROM accinfo WHERE account=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getAccount());
            rs = pstmt.executeQuery();

            if(rs.next()) {
                exist = (rs.getInt(1) == 1); //判断有无查询结果
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

            return exist;
        }
    }

    public void addAccount(Account account) {
        try {
            conn = dataSource.getConnection();
            sql = "INSERT INTO accinfo(account,password) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getAccount());
            pstmt.setString(2, account.getPassword());
            pstmt.executeUpdate();
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

    public Account getAccount(Account account) {
        ResultSet rs = null;
        Account acc = null;

        try {
            conn = dataSource.getConnection();
            sql = "SELECT password FROM accinfo WHERE account=?";
            conn.prepareStatement(sql);
            pstmt.setString(1, account.getAccount());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                acc = new Account(account.getAccount(), rs.getString(1));
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
        }

        return acc;
    }
}
