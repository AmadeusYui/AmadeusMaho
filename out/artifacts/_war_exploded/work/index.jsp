<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <!--    当前文档编码-->
    <meta charset="utf-8">
    <!--    为了让IE以最新的标准和模式进行当前页面的渲染-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--    移动端的适配-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>柚约</title>

    <!-- Bootstrap 引入核心的样式文件-->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/yy_index.css"  rel="stylesheet">
    <link rel="stylesheet" href="css/yy_nav.css">
    <link rel="shortcut icon" href="favicon.ico">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="lib/html5shiv/html5shiv.min.js"></script>
    <script src="lib/respond/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--导航条-->
<nav class="navbar navbar-default yy_nav">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header ">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">
                <img src="images/222.png" alt="logo">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left hidden-sm">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入关键字" style="display: inline-block">
                </div>
                <button type="submit" class="btn btn-default" style="display: inline-block"></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href= <%= request.getSession().getAttribute("user") == null
                                ? request.getContextPath()+"/A1/login.jsp" : "#"%> class="fir">您好，<%= request.getSession().getAttribute("user") == null
                        ? "请登录" : request.getSession().getAttribute("user")%></a></li>
                <li><a href="${pageContext.request.contextPath}/A1/regist.jsp"><%= request.getSession().getAttribute("user") == null
                        ? "注册" : ""%></a></li>
                <li>
                    <span></span>
                    <a href="#">消息</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle  last" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的柚约<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/A1/msg.jsp">我的信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/myydServlet">我的约定</a></li>
                        <li><a href="myindex.html">我的收藏</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="jumbotron yy_choice">

            <a href= <%= request.getSession().getAttribute("user") == null
                                ? "#" : request.getContextPath()+"/A1/Orderst.jsp"%> class="sports"></a>
            <a href=<%= request.getSession().getAttribute("user") == null
                                ? "#" : request.getContextPath()+"/A1/Ordersy.jsp"%> class="study"></a>

<!--        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
<!--        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="lib/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>