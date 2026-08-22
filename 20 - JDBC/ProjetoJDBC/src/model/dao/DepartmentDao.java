package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface DepartmentDao {
    void insert(Department dp);

    void update(Department dp);

    void delete(Integer id);

    Department select(Integer id);

    List<Department> findAll();

}
