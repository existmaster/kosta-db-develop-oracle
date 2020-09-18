package jdbc.sub01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {


//jdbc : 기본 접속 실습

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            if (conn != null) {
                System.out.println("데이터베이스 접속성공");
            } else {
                System.out.println("데이터베이스 접속 실패");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
