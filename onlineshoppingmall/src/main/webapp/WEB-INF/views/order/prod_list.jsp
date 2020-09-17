<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $("#bar").mousedown(function(){
		  $("#bar").val('');
	  });
	  $("#search").click(function(){
		  //검색시 get과 post로 구분
		  var input = $("#bar").val();
		  var search_type = $("#search_op option:selected").val();
		  if(search_type=="1"){//상품명
			  location.href = "/order/prod_list/name/"+input;
		  }else{//판매자명
			 location.href = "/order/prod_list/seller/"+input;
		  }
	  });
});
</script>
</head>
<body>
<h3>all product list</h3>

<select name="search_op" id="search_op">
	<option value="1">상품명</option>
	<option value="2">판매자명</option>
</select>
<input type="text"  value="상품명 또는 판매자명으로 검색" id="bar" >
<input type="button" value="검색" id="search"><br/>

<table border="1">
<tr><th>num</th><th>name</th><th>price</th><th>seller</th>
<c:forEach var="p" items="${list }">
<tr>
	<td>${p.num }</td>
	<td><a href="/order/details/${p.num }">${p.name }</a></td>
	<td>${p.price }</td>
	<td>${p.seller.id }</td>
</tr>
</c:forEach>
</table>
</body>
</html>