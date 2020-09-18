package jdbc.sub04;

import java.sql.*;

public class JdbcPreparedStatement02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            String query = "insert into dept2 values(?, ?, ?)";
            pstmt = conn.prepareStatement(query);

            //pstmt.set~은 conn.prepareStatement(); 다음에 들어와야한다
            pstmt.setInt(1, 50);
            pstmt.setString(2, "총무부");
            pstmt.setString(3, "서울");
            int count = pstmt.executeUpdate();
            System.out.println("영향받은 행수 : " + count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};
            if(conn != null) try{ conn.close();} catch(SQLException e){};
        }
    }
}
