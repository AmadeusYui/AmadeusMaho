<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约运动</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/orderServlet" method="post">
    <h3>学习预约界面</h3><br>
    <input type="radio" name="basketball" value="yes">篮球<br>
    <input type="radio" name="football" value="yes">足球<br>
    <input type="radio" name="tabletennis" value="yes">乒乓球<br>
    <td colspan="2"><input type="submit" value="预约"></td>
    </form>
</body>
</html>
