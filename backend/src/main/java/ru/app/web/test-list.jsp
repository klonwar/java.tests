<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Choose test</h2>
<ul>
    <c:forEach items="${testList}" var="item">
        <li>
            <a href="/test?id=${item.id}">${item.id} - ${item.title}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
