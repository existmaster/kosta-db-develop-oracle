package jdbc.sub03;

import java.sql.*;

public class JdbcStatement {

//jdbc : select 실습


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        //select한 리턴값을 자바객체로 표현
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            stmt = conn.createStatement();

            //select 구문 실습
            String query = "select deptno no, dname name, loc location from dept2";
            rs = stmt.executeQuery(query);

            //select한 값이 없을때까지 반복
            while (rs.next()) {

                //String deptno = rs.getString("deptno");
                //String dname = rs.getString("dname");
                //String loc = rs.getString("loc");

                String deptno = rs.getString(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);

                System.out.println(deptno + "\t" + dname + "\t" + loc + "\t");
            }

            int count = stmt.executeUpdate(query);
            System.out.println("영향받은 행수 : " + count);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
            }


            //신형버젼에선 auto commit을 해주지만 구형버젼에선 close를 해줘야 commit이 됨
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

