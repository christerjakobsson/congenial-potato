<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>

    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>

    <jsp:body>

        <ul>
            <c:forEach var="todo" items="${todos.getContent()}">
                <li>${todo.Name}</li>
            </c:forEach>
        <ul>

        <span>Total: ${todos.getTotalElements()}</span>
        <span>Total pages: ${todos.getTotalPages()}</span>

        <a href="/todos/new">New todo</a>

    </jsp:body>
</t:genericpage>