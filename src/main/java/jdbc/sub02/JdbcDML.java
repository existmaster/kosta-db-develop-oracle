package jdbc.sub02;

import java.sql.*;

public class JdbcDML {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            stmt = conn.createStatement();
//                     insert
//                     String query = "insert into dept2 values(60, '경리부', '수원')";

//                     update
//                     String query = "update dept2 set loc='부산' where deptno = 60";

//                     delete
//                     String query = "delete from dept2 where deptno in(50, 60)";
//                     DDL실습(Table 생성)
            String query = "create table tbla(col1 varchar2(10), col2 varchar2(20))";
            int count = stmt.executeUpdate(query);
            System.out.println("영향받은 행수 : " + count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(stmt != null) try{ stmt.close();} catch(SQLException e){};
            //신형버젼에선 auto commit을 해주지만 구형버젼에선 close를 해줘야 commit이 됨
            if(conn != null) try{ conn.close();} catch(SQLException e){};
        }
    }
}
