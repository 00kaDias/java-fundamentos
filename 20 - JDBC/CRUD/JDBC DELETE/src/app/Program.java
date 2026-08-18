package app;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("DELETE FROM department  WHERE Id = ?");
            st.setInt(1, 2);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {

            DB.CloseStatement(st);
            DB.closeConnection();
        }
    }
}
