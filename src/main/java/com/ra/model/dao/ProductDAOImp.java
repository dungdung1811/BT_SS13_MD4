package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.ulti.ConnectionDB;
import jdk.tools.jlink.plugin.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Controller
@Repository
public class ProductDAOImp implements ProductDAO {
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openconnection();

        String sql = "SELECT * FROM product";
        try {

            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                Category category = categoryDao.findById(rs.getInt("category_id"));
                product.setCategory(category);
                product.setImage(rs.getString("image"));
                list.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }



    @Override
    public Boolean create(Product product) {
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "INSERT INTO product (product_name, price, category_id,image) VALUES (?,?,?,?)";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,product.getProductName());
            pstm.setDouble(2,product.getPrice());
            pstm.setInt(3,product.getCategory().getId());
            pstm.setString(4,product.getImage());
            int rs = pstm.executeUpdate();
            if (rs>0){
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return false;
    }

    @Override
    public Boolean update(Product product, Integer id) {
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "UPDATE product SET product_name =?,price=?,category_id = ?, image=? WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,product.getProductName());
            pstm.setDouble(2,product.getPrice());
            pstm.setInt(3,product.getCategory().getId());
            pstm.setString(4,product.getImage());
            pstm.setInt(5,product.getId());
            int rs = pstm.executeUpdate();
            if (rs>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Product product = new Product();
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                Category category = categoryDao.findById(rs.getInt("category_id"));
                product.setCategory(category);
                product.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }

        return product;
    }

    @Override
    public void delete(Integer id) {

        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "DELETE FROM product WHERE id =?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

    }
}
