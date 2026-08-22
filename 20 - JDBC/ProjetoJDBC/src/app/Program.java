package app;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.List;

public class Program {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("TEST");
        Department dep = new Department(2, null);
        List<Seller> sList = sellerDao.findByDepartment(dep);
        sList.stream().forEach(System.out::println);


    }

}
