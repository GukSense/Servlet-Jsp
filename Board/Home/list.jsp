<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board-list</title>
<style>
	table {
		border-collapse:collapse;
		margin:40px auto
	}
	
	table tr th, table tr td {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	.written {
		float:right;
	}
	
	
</style>
</head>
<body>
	<table>
		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		
		<tr>
			<td>1</td>
			<td>content</td>
			<td>0</td>
			<td>id</td>
			<td>2023.01.16</td>
		</tr>
		<tr>
			<td colspan="5" style="border:none; padding:10px 0px;" >
				<input type="button" class="written" onclick="location='/lcomputerstudy/board-registration.do'" value="글쓰기"  name="write">
    		</td>
		</tr>
	</table>
	
</body>
</html>