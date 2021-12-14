<%--
  Created by IntelliJ IDEA.
  User: klonw
  Date: 12.12.2021
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Ваш результат по тесту:</h2>

<h4>${result.test.id} - ${result.test.title}</h4>
<pre>Балл: ${result.score}</pre>

<a href="/">На главную</a>
</body>
</html>
