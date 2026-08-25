package model.dao;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC() {
    }

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department dep) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, dep.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    dep.setId(id);
                }

            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


    @Override
    public void update(Department dp) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
            st.setString(1, dp.getName());
            st.setInt(2, dp.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbIntegrityException("Error: " + e.getMessage());
        } finally {

            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
                st.setInt(1, id);
                rs = st.executeQuery();
                Department dep = null;
                if (rs.next()){

                    dep = new Department();
                    dep.setId(rs.getInt("Id"));
                    dep.setName(rs.getString("Name"));
                }
                return dep;
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            finally {
                DB.closeStatement(st);
                DB.closeResultSet(rs);
            }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();
                while (rs.next()) {
                    Department dep = new Department();
                    dep.setId(rs.getInt("Id"));
                    dep.setName(rs.getString("Name"));
                    list.add(dep);

                }
                return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }

    }
}

