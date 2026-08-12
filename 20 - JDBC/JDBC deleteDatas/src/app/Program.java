package app;


import db.DB;
import db.DbException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            String name = "' OR '1'='1";
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM seller WHERE Name = '" + name + "'");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + ", "
                        + ", " + rs.getString("Email")
                        + ", " + rs.getDate("BirthDate")
                        + ", " + rs.getDouble("BaseSalary")
                        + ", " + rs.getInt("DepartmentId"));
            }


            System.out.println("Done! Rows affected: ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.CloseStatement(st);
            DB.closeConnection();
        }
    }
}
