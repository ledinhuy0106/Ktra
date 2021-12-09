<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UyLe
  Date: 12/9/2021
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container text-left">

    <a href="/products?action=create" class="btn btn-success">Add
        New Product</a>
</div>
<br>
<table>
    <thead>
    <th>#</th>
    <th>Tên sản phẩm</th>
    <th>Số lượng</th>
    <th>Màu</th>
    <th>Mô tả</th>
    <th>Danh mục</th>
    <th>Gía</th>
    <th>Sửa</th>
    <th>Xóa</th>
    </thead>
    <tbody>
    <c:forEach var="i" begin="0" end="${product.size()-1}">
    <tr>
        <td>${product.get(i).id}</td>
        <td>${product.get(i).name}</td>
        <td>${product.get(i).soluong}</td>
        <td>${product.get(i).color}</td>
        <td>${product.get(i).mota}</td>
        <td>${category.get(i).danhmuc}</td>
        <td>${product.get(i).price}</td>
        <td><a href="/products?action=delete&id=${product.get(i).id}">Xóa</a></td>
        <td><a href="/products?action=edit&id=${product.get(i).id}">Sửa</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
