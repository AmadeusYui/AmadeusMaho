<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ChangepwdServlet">
    输入想要的新密码<input type="text" name="newpwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
