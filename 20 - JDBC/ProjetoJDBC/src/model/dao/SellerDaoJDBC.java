package model.dao;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.*;

public class SellerDaoJDBC implements SellerDao {
    private Connection conn;

    public SellerDaoJDBC() {
    }

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Seller sl) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("INSERT INTO seller " + "( Name, Email, BirthDate, BaseSalary, DepartmentId)" + " VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, sl.getName());
            st.setString(2, sl.getEmail());
            st.setDate(3, new java.sql.Date(sl.getBirthDate().getTime()));
            st.setDouble(4, sl.getBaseSalary());
            st.setInt(5, sl.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    sl.setId(id);
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
    public void update(Seller sl) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE seller SET Name = ?," + "Email = ?, BirthDate = ?, BaseSalary = ?" + ", DepartmentId = ? WHERE Id = ? ");
            st.setString(1, sl.getName());
            st.setString(2, sl.getEmail());
            st.setDate(3, new java.sql.Date(sl.getBirthDate().getTime()));
            st.setDouble(4, sl.getBaseSalary());
            st.setInt(5, sl.getDepartment().getId());
            st.setInt(6, sl.getId());

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
            st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " + "FROM seller " + "INNER JOIN department ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);

                Seller sel = instantiateSeller(rs, dep);

                return sel;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " + "FROM seller INNER JOIN department " + "ON seller.DepartmentID = department.Id " + "WHERE DepartmentId = ?  " + "ORDER BY Name");
            st.setInt(1, department.getId());
            rs = st.executeQuery();
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller sel = instantiateSeller(rs, dep);
                list.add(sel);

            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " + "FROM seller " + "INNER JOIN department ON seller.DepartmentId = department.Id " + "ORDER BY Name");
            rs = st.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> depMap = new HashMap<>();
            while (rs.next()) {
                int depId = rs.getInt("DepartmentId");
                Department dep;
                if (depMap.containsKey(depId)) {
                    dep = depMap.get(depId);
                } else {
                    dep = instantiateDepartment(rs);
                    depMap.put(depId, dep);
                }
                Seller sel = instantiateSeller(rs, dep);
                sellerList.add(sel);

            }
            return sellerList;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }

    }


    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(department);
        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DepName"));
        return department;
    }
}

