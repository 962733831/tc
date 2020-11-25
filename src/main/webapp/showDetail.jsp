<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/21
  Time: 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <style type="text/css">
        a{
            text-decoration: none;
            color: blue;
        }
        a:hover{
            color: red;
        }

        img{
            width:120px;
            height: 90px;
        }
    </style>
</head>
<body>
<h1>商品详情</h1>
商品名称:${prd.name }<Br>
商品单价:${prd.price }<Br>
商品样式:<img src="${pageContext.request.contextPath}/${prd.pic }"/><Br>
<hr>
<a onclick="history.back()">返回</a>
</body>
</html>
