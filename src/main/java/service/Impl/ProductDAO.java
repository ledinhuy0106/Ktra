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
        Product products;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String color = rs.getString("color");
            int soluong = rs.getInt("soluong");
            String mota = rs.getString("mota");
            products = new Product(id1, name, soluong, color, mota, price);
            return products;
        } catch (SQLException ignored) {
        }
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

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product WHERE name LIKE ?;");
        ) {
            preparedStatement.setString(1, "%" + name + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                String nameFind = rs.getString("name");
                String color = rs.getString("color");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                products.add(new Product(id, nameFind, price, color, mota, soluong));
            }
            return products;
        } catch (SQLException ignored) {
        }
        return null;
    }
}

