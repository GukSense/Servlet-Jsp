<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		text-align:center;
		width:200px
	}
	a{
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
</style>
</head>
<body>
<h1><br>회원상세정보</h1>

<table>
	<tr>
		<td>회원 번호</td>
		<td>${user.u_idx}</td>
	</tr>
	<tr>
		<td>회원 ID</td>
		<td>${user.u_id }</td>
	</tr>
	<tr>
		<td>회원 이름</td>
		<td>${user.u_pw }</td>
	</tr>
	<tr>
		<td>회원 전화번호</td>
		<td>${user.u_tel }</td>
	</tr>
	<tr>
		<td>회원 나이</td>
		<td>${user.u_age }</td>
	</tr>
	
</table>
		
	<button style="width:200px;font-weight:700;background-color:#818181;color:#fff;border:none; ">
		<a href="user/userEdit.jsp?u_idx=${user.u_idx }">수정</a>
	</button>
	<button style="width:200px;font-weight:700;background-color:red;color:#fff;border:none;">삭제</button>
	
	
	
	
	
</body>
</html>