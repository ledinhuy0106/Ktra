package service;

import model.Product;

import java.util.List;

public interface IProductDAO extends IGeneralDAO<Product> {
    List<Product> findByName(String name ) ;
}
