<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="hello.SE.DatabaseUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    con = DatabaseUtil.getConnection();
    String query = "select * from membership";
    pstmt = con.prepareStatement(query);
    rs = pstmt.executeQuery();

%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script>
    function search(name){
        if(name.keyword.value==""){
            alert("검색 단어를 입력하세요.");
            name.keyword.focus();
            return;
        }
        name.submit();
    }
</script>
<body>
<h1>회원 정보</h1>
<table border="1">
    <thead>
    <th>이름</th>
    <th>생년월일</th>
    <th>전화번호</th>
    </thead>
    <tbody>
    <%
        while (rs.next()){

            String name = rs.getString(1);
            int birth = rs.getInt(2);
            String phone = rs.getString(3);
            out.write(" <tr>");
            out.write(" <td>" +name + "</td>");
            out.write(" <td>" +birth + "</td>");
            out.write(" <td>" + phone + "</td>");
            out.write(" </tr>");
        }
    %>
    </tbody>
</table>
<a href="/index.html">메인</a>
<tr>
    <td colspan="10"> <br/>
        <form  method="post" action="find">
            <select name="keyfield">
                <option value="0">---선택---</option>
                <option value="name">이름</option>
            </select>
            <input type="text" name="keyword" />
            <input type="button" value="검색" onclick="search(form)">
        </form>
    </td>
</tr>
</body>
</html>
