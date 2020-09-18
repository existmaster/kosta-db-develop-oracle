package jdbc.sub06;

import java.sql.*;

public class JdbcGetMetadata02 {
    public static void main(String[] args) {

        Connection con = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            stmt = con.createStatement();
            String query = "select * from dept";
            rs = stmt.executeQuery(query);

            ResultSetMetaData data = rs.getMetaData();
            System.out.println(data.getColumnCount());

            for(int i = 1 ; i <=data.getColumnCount() ; i++){
                System.out.print(data.getColumnName(i) + "   ");
                System.out.print(data.getColumnTypeName(i));
                System.out.println("(" + data.getPrecision(i) + ")");
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally{

            try{ con.close(); rs.close(); stmt.close();} catch(SQLException e){}

        }
    }
}
