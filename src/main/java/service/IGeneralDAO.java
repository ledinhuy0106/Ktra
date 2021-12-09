package service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralDAO <T>{
    List<T> showAll() throws SQLException;
    List<T> showAllIdCategory() throws SQLException;
    T findById(int id) throws SQLException;
    void add(T t) throws SQLException;
    void edit(int id,T t) throws SQLException;
    void delete(int id) throws SQLException;


}
