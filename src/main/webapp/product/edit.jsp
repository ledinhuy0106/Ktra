<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UyLe
  Date: 12/9/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name" placeholder="${product1.name}"><br>
    <input type="text" name="soluong" placeholder="${product1.soluong}"><br>
    <input type="text" name="color" placeholder="${product1.color}"><br>
    <input type="text" name="mota" placeholder="${product1.mota}"><br>
    <input type="text" name="price" placeholder="${product1.price}"><br>
    <button>sửa</button>
</form>
</body>
</html>
