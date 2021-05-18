<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Create order
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <c:if test="${requestScope.status == 'forespørgelse' }">
            <p style="font-size: larger">Din ordre venter på bekræftelse</p>
        </c:if>

        <c:if test="${requestScope.status == null }">
            <h2>Du har ikke bestilt en carport endnu</h2>
            <br/>
            <a href="${pageContext.request.contextPath}/fc/createorder">Du kan bestille en her</a>
        </c:if>

        <c:if test="${requestScope.status == 'godkendt' }">
            <h2>Betal for din carport</h2>
            <br/>
            <form action="${pageContext.request.contextPath}/fc/showorder">
                <input type="hidden"
                       name="status"
                       value="${requestScope.status}">
                <button class="btn btn-primary" type="submit">Betal</button>
            </form>
        </c:if>

        <c:if test="${requestScope.status == 'betalt' }">
            <h2>Her er din stykliste</h2>
            <table>
                <thead><th>Navn  </th><th>Længde  </th><th>Antal  </th><th>Beskrivelse  </th></thead>
                <c:forEach var="BOMItem" items="${requestScope.BOMList}">
                    <tr>
                        <td>${BOMItem.name}</td>
                        <td>${BOMItem.length}</td>
                        <td>${BOMItem.quantity}</td>
                        <td>${BOMItem.description}</td>
                    </tr>

                </c:forEach>

            </table>
        </c:if>

    </jsp:body>
</t:genericpage>