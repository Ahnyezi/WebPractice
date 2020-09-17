<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>my product list</h3>
<a href="/product">상품등록</a><br/>

<table border="1">
<tr><th>num</th><th>name</th><th>price</th><th>seller</th>
<c:forEach var="p" items="${list }">
<tr>
	<td>${p.num }</td>
	<td><a href="/product/details/${p.num }">${p.name }상세페이지</a></td>
	<td>${p.price }</td>
	<td>${p.seller }</td>
</tr>
</c:forEach>
</table>
</body>
</html>