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
        <div class="container-fluid">
            <div class="row">
                <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                <p><a href="fc/employeepage">Employee Page</a>
                    </c:if>

                    <c:if test="${sessionScope.role == 'customer' }">
                <h2>Her kan du vælge størrelsen på din Carport</h2>
                <br/>
                <p>Alle carporte har en standard højde på 225 cm</p>
                </c:if>
                    <c:if test="${requestScope.error != null }">
                <div class="row">
                    <h2 class="text-danger">${requestScope.error}</h2>
                </div>
                    </c:if>
            </div>

            <form action="${pageContext.request.contextPath}/fc/price" method="post" role="form"
                  class="form-horizontal">
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="col" for="height">Højde i cm:</label>
                            <input name="height" class="form-control mb-3" type="number" placeholder="225"
                                   id="height" min="0" data-bind="value:height" aria-label="højde" readonly/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col" for="length">Længde i cm:</label>
                        <input name="length" class="form-control mb-3" type="number" id="length" min="0"
                               data-bind="value:length"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label for="width">Bredde i cm:</label>
                        <input name="width" class="form-control mb-3" type="number" id="width" min="0"
                               data-bind="value:width"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                            <button class="btn btn-primary" type="submit">Send forespørgsel</button>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:genericpage>