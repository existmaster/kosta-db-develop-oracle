package jdbc.sub04;

import java.sql.*;

public class JdbcPreparedStatement01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            String query = "select * from emp where deptno=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 30);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String deptno = rs.getString("deptno");
                System.out.println(empno + "\t" + ename + "\t" + deptno + "\t");

            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }


            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }


            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }


        }
    }
}
