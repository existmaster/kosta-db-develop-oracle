package jdbc.sub06;

import java.sql.*;
public class JdbcGetMetadata01 {
    public static void main(String[] args) {

        Connection con = null;
        String driver = "oracle.jdbc.driver.OracleDriver";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            DatabaseMetaData data = con.getMetaData();
            System.out.println(data.getDatabaseProductName());
            System.out.println(data.getDatabaseProductVersion());
            System.out.println(data.getDriverName());
            System.out.println(data.getURL());
            ResultSet rs = data.getSchemas();

            while (rs.next()) {
                System.out.println("계정명 : " + rs.getString(1));
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
            }

        }
    }
}