<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Solve the test</h2>
<h4>${chosenTest.id} - ${chosenTest.title}</h4>
<form method="post" action="test?id=${chosenTest.id}">
    <c:forEach items="${chosenTest.questions}" var="q">
        <div style="padding: 10px 15px; border: 1px solid #333; margin-bottom: 10px">
            <p>${q.getContent()}</p>
            <div>
                <c:forEach items="${q.getAnswers()}" var="a">
                    <div>
                        <input id="q${q.getId()}_a${a.getId()}" type="radio" name="q${q.getId()}" value="${a.getId()}">
                        <label for="q${q.getId()}_a${a.getId()}">${a.getContent()}</label>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
    <button type="submit">Send</button>
</form>
</body>
</html>
