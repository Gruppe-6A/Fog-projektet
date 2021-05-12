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

        <div>
            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <h2>Her kan du vælge størrelsen på din Carport</h2>
                <br/>
                <p>Alle carporte har en standard højde på 2,25 mtr</p>
                <div style="margin-top: 3em;margin-bottom: 3em;">
                </div>

                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="customerpage">Customer Page</a>
            </c:if>
        </div>

        <form action="${pageContext.request.contextPath}/fc/price" method="post" role="form" class="form-horizontal">
            <div class="container-fluid">
                <div class="form-group">
                    <div class="row">
                        <label class="col" for="height">højde i cm:</label>
                    </div>
                    <div class="row">
                        <input name="height" class="col-2 mb-2" type="number" id="height" min="0" data-bind="value:height" />
                    </div>
                    <div class="row">
                        <label class="col" for="length">Længde i cm:</label>
                    </div>
                    <div class="row">
                        <input name="length" class="col-2 mb-2" type="number" id="length" min="0" data-bind="value:length" />
                    </div>
                    </br>
                    <div class="row">
                        <label for="width">Bredde i cm:</label>
                    </div>
                    <div class="row">
                        <input name="width" class="col-2 mb-2"type="number" id="width" min="0" data-bind="value:width" />
                    </div>
                </div>
                <button class="btn btn-primary" type="submit" >Udregn pris</button>
            </div>
        </form>

    </jsp:body>
</t:genericpage>