<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Show order
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            Her er længden: ${requestScope.length}  <br>
            Her er bredden: ${requestScope.width} <br>
            Prisen på din carport er: ${requestScope.price} kr. <br>
            <button type="button" class="btn btn-outline-success">Køb nu</button>
        </div>

    </jsp:body>
</t:genericpage>