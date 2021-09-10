<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- jsp 파일을 명시 -->
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="save" method="post">
    <table>
        <tr>
            <td>이름 : </td>
            <td><input type="text" name="name" maxlength="15" /></td>
        </tr>
        <tr>
            <td>생년원일 : </td>
            <td><input type="text" name="date_Of_Birth" maxlength="15" /></td>
        </tr>
        <tr>
            <td>전화번호 : </td>
            <td><input type="text" name="phone_Number" maxlength="15" /></td>
        </tr>
        <tr>
            <td><button type="submit">등록</button></td>
        </tr>
    </table>
</form>
</body>
</html>