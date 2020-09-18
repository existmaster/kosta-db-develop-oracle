package jdbc.sub05;

import java.sql.*;
import java.util.ArrayList;

public class JdbcDAO {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //DeptDAO를 여러개 담을 객체 : 테이블 내용 / select의 전체 내용
        ArrayList<DeptDAO> depts = new ArrayList<DeptDAO>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            String query = "select * from dept";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){

                //한행 데이터
                DeptDAO dao = new DeptDAO();
                dao.setDeptno(rs.getString("deptno"));
                dao.setDname(rs.getString("dname"));
                dao.setLoc(rs.getString("loc"));
                depts.add(dao);

            }
            for(int i = 0 ; i <depts.size() ; i++){

                DeptDAO tmp = depts.get(i);
                System.out.println(tmp.getDeptno() + "\t" + tmp.getDname() + "\t" + tmp.getLoc() + "\t");

            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally{

            if(pstmt != null) try{ pstmt.close();} catch(SQLException e){};
            if(rs != null) try{ rs.close();} catch(SQLException e){};
            if(conn != null) try{ conn.close();} catch(SQLException e){};

        }
    }
}
