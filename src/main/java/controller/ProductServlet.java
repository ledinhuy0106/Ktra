package controller;

import model.Category;
import model.Product;
import service.ICategoryDAO;
import service.IProductDAO;
import service.Impl.CategoryDAO;
import service.Impl.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ICategoryDAO categoryDAO=new CategoryDAO();
    IProductDAO productDAO=new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                try {
                    showCreate(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "delete":
                try {
                    deleteProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "edit":
                try {
                    showEdit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showList(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("product/edit.jsp");
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=productDAO.findById(id);
        request.setAttribute("product",product);
        List<Category> list1= categoryDAO.showAll();
        request.setAttribute("category",list1);
        requestDispatcher.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("product/create.jsp");

        List<Category> list1= categoryDAO.showAll();

        request.setAttribute("categorys",list1);
        requestDispatcher.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Category> categories = categoryDAO.showAll();
        List<Product> productList=productDAO.showAll();
        request.setAttribute("product",productList);
        request.setAttribute("category",categories);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                try {
                    createProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case "edit":
                try {
                    editProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int soluong= Integer.parseInt(request.getParameter("soluong"));
        String color= request.getParameter("color");
        String mota=request.getParameter("mota");
        int price = Integer.parseInt(request.getParameter("price"));
        productDAO.edit(id,new Product(name,soluong,color,mota,price));
        response.sendRedirect("/products");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String danhmuc=request.getParameter("danhmuc");
        String name=request.getParameter("name");
        int soluong= Integer.parseInt(request.getParameter("soluong"));
        String color= request.getParameter("color");
        String mota=request.getParameter("mota");
        int price = Integer.parseInt(request.getParameter("price"));
        categoryDAO.add(new Category(danhmuc));
        productDAO.add(new Product(name,soluong,color,mota,price));
        response.sendRedirect("/products");

    }
}
