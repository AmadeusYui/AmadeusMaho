<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的约定</title>
</head>
<body>
    <h3>我现在的约定有:</h3>
    <%= request.getSession().getAttribute("Myyd")%><br>
    <a href="${pageContext.request.contextPath}/work/index.jsp">回到首页</a>
</body>
</html>
