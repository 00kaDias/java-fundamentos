package app;


import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String name = "' OR '1'='1";
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT * FROM seller WHERE Name = ?");
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Name") + ", "
                        + ", " + rs.getString("Email")
                        + ", " + rs.getDate("BirthDate")
                        + ", " + rs.getDouble("BaseSalary")
                        + ", " + rs.getInt("DepartmentId"));
            }


            System.out.println("Done!  ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.CloseStatement(st);
            DB.closeConnection();
        }
    }
}