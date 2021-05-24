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
            <c:if test="${sessionScope.role == null}">

                Her kan du registrere dig som kunde for at bestille carporte.
                <br>
                <a type="button" class="btn btn-sm  btn-outline-light"
                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                <a type="button" class="btn btn-sm  btn-outline-light"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>

            </c:if>

            <c:if test="${sessionScope.role == 'employee' }">
                <div style="margin-top: 3em;margin-bottom: 3em;">
                    Her kan du gå ind på admin siden og godkende kunders forespørgsel.
                </div>
                <form action="${pageContext.request.contextPath}/fc/Godkender" method="post" role="0">
                    <div class="row">
                        <div class="col-sm-4">
                            <button class="btn btn-primary" type="submit">Admin side</button>
                        </div>
                    </div>
                </form>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                 <div style="margin-top: 3em;margin-bottom: 3em;">
                     Her kan du bygge din egen carport.
                 </div>
            <form action="${pageContext.request.contextPath}/fc/createorder" method="post" role="1">
                <div class="row">
                    <div class="col-sm-4">
                        <button class="btn btn-primary" type="submit">Skræddersy din egen carport</button>
                    </div>
                </div>
            </form>
                </c:if>


        </div>

    </jsp:body>
</t:genericpage>