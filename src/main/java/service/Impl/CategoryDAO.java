package service.Impl;

import model.Category;
import model.Product;
import service.ICategoryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    public CategoryDAO() {
    }


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List showAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from category");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String danhmuc = rs.getString("danhmuc");
            categories.add(new Category(danhmuc));

        }

        return categories;
    }

    @Override
    public List showAllIdCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from category");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String danhmuc = rs.getString("danhmuc");
            categories.add(new Category(id, danhmuc));

        }

        return categories;
    }

    @Override
    public Category findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void add(Category category) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into category (danhmuc) value (?)");
        preparedStatement.setString(1, category.getDanhmuc());
        preparedStatement.executeUpdate();
    }

    @Override
    public void edit(int id, Category category) throws SQLException {
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from category where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
