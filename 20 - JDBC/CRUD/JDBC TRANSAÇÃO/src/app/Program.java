package app;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            DB.CloseStatement(st);
            DB.closeConnection();
        }
    }
}
