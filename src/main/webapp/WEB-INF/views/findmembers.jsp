<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 조회</title>
</head>
<body>
<h1>회원 정보</h1>
<table border="1">
    <thead>
    <th>이름</th>
    <th>생년월일</th>
    <th>전화번호</th>
    </thead>
    <c:forEach var="item" items="${members}">
    <tr>

        <td>${item.username}</td>
        <td>${item.date_of_Birth}</td>
        <td>${item.phone_Num}</td>
    </tr>
    </c:forEach>
</table>
<a href="/index.html">메인</a>
</body>
</html>