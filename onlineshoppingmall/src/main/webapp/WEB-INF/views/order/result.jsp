<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>주문완료 </h3>
<table border="1">
<tr><th>주문번호</th><th>제품번호</th><th>주문개수</th><th>총 결제금액</th>
<tr>
	<td>${o.num }</td>
	<td>${o.pnum }</a></td>
	<td>${o.order_num }</td>
	<td>${o.total_price }</td>
</tr>
</table>
</body>
</html>