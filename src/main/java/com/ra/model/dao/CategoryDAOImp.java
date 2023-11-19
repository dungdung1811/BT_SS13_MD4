package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.ulti.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImp implements CategoryDao{

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();

        Connection connection = null;
        connection = ConnectionDB.openconnection();
        try {
            PreparedStatement pmts = connection.prepareStatement("SELECT * FROM `ss13-crud`.category");
            ResultSet rs = pmts.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                list.add(category);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return list;
    }

    @Override
    public Boolean create(Category category) {
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        try {
            String sql = "INSERT INTO category (name, status) VALUES (?,?)";
            PreparedStatement pmts = connection.prepareStatement(sql);

            pmts.setString(1, category.getName());
            pmts.setBoolean(2,category.getStatus());

            int rs = pmts.executeUpdate();
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
    public Boolean update(Category category, Integer id) {
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "UPDATE category SET status =?,name=? WHERE  id= ?" ;
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setBoolean(1,category.getStatus());
            pstm.setString(2,category.getName());
            pstm.setInt(3,id);
            int check = pstm.executeUpdate();

            pstm.executeUpdate();
            if(check > 0){
                return  true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        Connection connection = null;
        Category category = new Category();
        connection = ConnectionDB.openconnection();
        String sql = "SELECT * FROM category WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return category;

    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        connection = ConnectionDB.openconnection();
        String sql = "DELETE FROM category WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
