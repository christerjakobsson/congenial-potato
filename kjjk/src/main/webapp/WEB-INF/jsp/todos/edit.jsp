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
        <span>${todo.Name}
    </jsp:body>
</t:genericpage>