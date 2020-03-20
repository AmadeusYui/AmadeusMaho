<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        h3{
            padding-top: 100px;
            text-align: center;
        }
        table{
            position: absolute;/*绝对定位*/
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }
        div{
            position: absolute;/*绝对定位*/
            top: 60%;
            left: 60%;
            margin-top: -100px;
            margin-left: -250px;
        }
    </style>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src ="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/registServlet" method="post" >
        <table align="center">
            <h3>注 册</h3>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="${pageContext.request.contextPath}/checkCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
    <div align="center"><%= request.getAttribute("regist_error") == null ? "" : request.getAttribute("regist_error") %></div>
    <div align="center"><%= request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error") %></div>
</body>
</html>
