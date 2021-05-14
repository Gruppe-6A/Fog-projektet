<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Velkommen til Fog</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
               Her kan du bygge din egen carport
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

            <form action="${pageContext.request.contextPath}/fc/createorder" method="post" role="form">
            <div class="row">
                <div class="col-sm-4">
                    <button class="btn btn-primary" type="submit">Skræddersy din egen carport</button>
                </div>
            </div>
        </form>
        </div>

    </jsp:body>
</t:genericpage>