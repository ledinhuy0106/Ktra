package service.Impl;

import model.Product;
import service.IProductDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Product> showAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from product");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int soluong = rs.getInt("soluong");
            String color = rs.getString("color");
            String mota = rs.getString("mota");
            int price = rs.getInt("price");
            productList.add(new Product(id, name, soluong, color, mota, price));

        }

        return productList;
    }

    @Override
    public List<Product> showAllIdCategory() throws SQLException {
        return null;
    }


    @Override
    public Product findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product (name,soluong,color,mota,price) value (?,?,?,?,?)");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getSoluong());
        preparedStatement.setString(3, product.getColor());
        preparedStatement.setString(4, product.getMota());
        preparedStatement.setInt(5, product.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public void edit(int id, Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update product set name=? , soluong =?, color=?, mota=?,price=?  where id=?");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getSoluong());
        preparedStatement.setString(3, product.getColor());
        preparedStatement.setString(4, product.getMota());
        preparedStatement.setInt(5, product.getPrice());
        preparedStatement.setInt(6, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
