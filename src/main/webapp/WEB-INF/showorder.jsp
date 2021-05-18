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
            Længde: ${requestScope.order.length} <br/>
            Højde: ${requestScope.order.height} <br/>
            Bredde: ${requestScope.order.width} <br/>
            Pris: ${requestScope.order.price}
            <br/>
            <form action="${pageContext.request.contextPath}/fc/showorder">
                <input type="hidden"
                       name="status"
                       value="${requestScope.status}">
                <button class="btn btn-primary" type="submit">Betal</button>
            </form>
        </c:if>

        <c:if test="${requestScope.status == 'betalt' }">
            <h1>Her er din stykliste</h1>
            <table class="table table-hover table-bordered bg-#001276 text-white">
                <thead>
                <tr>
                    <th scope="col">Navn</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Beskrivelse</th>
                    <th scope="col">Pris</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="BOMItem" items="${requestScope.BOMList}">
                    <tr>
                        <td>${BOMItem.name}</td>
                        <td>${BOMItem.length}</td>
                        <td>${BOMItem.quantity}</td>
                        <td>${BOMItem.description}</td>
                        <td>${BOMItem.price} kr.</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </table>
            <h2>Samlet pris:</h2>
            <h3>${requestScope.samletpris} kr.</h3>
        </c:if>
    </jsp:body>
</t:genericpage>