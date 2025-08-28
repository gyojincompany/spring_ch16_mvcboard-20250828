<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
	<h2>${bDto.bnum }번 글 내용</h2>
	<hr>
	글 제목 : ${bDto.btitle } <br><br>
	글 내용 : ${bDto.bcontent } <br><br>
	글 작성자 : ${bDto.bname } <br><br>
	글 조회수 : ${bDto.bhit } <br><br>
	글 등록일 : ${bDto.bdate } <br><br>
	<hr>
	<input type="button" value="글목록" onclick="javascript:window.location.href='boardlist'">
</body>
</html>