<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
<table align="center" width="60%">
    <c:forEach items="${requestScope.list }" var="k" varStatus="st">
        <tr>
            <Td>${st.count }</Td>
            <Td>${k.name }</Td>
            <Td>${k.price}</Td>
            <Td>
                <img src="${k.pic }"/>
            </Td>
            <Td>
                <A href="showDetails/${k.id }.do">查看详情</A>
            </Td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
