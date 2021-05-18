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
        </table>
        <h1>Her vises alle forespørglser</h1>
        <table class="table table-bordered bg-#001276 text-white">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Kunde id</th>
                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Godkend ordre</th>
                <th scope="col">Afvis ordre</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orderList" items="${requestScope.orderList}">
                <c:if test="${orderList.status == 'forespørgelse' }">
                <tr>
                    <td class="col-sm-1">${orderList.order_id}</td>
                    <td class="col-sm-1">${orderList.users_id}</td>
                    <td class="col-sm-1">${orderList.length}</td>
                    <td class="col-sm-1">${orderList.width}</td>
                    <td class="col-sm-2">
                        <form action="Godkender">
                        <input type="hidden"
                               name="orderid"
                               value="${orderList.order_id}">
                        <input type="hidden"
                               name="godkendt"
                               value="true">
                        <button class="btn btn-success" type="submit">Godkend ordre</button>
                    </form>
                    </td>
                    <td class="col-sm-2">
                    <form action="Godkender">
                        <input type="hidden"
                               name="orderid"
                               value="${orderList.order_id}">
                        <input type="hidden"
                               name="godkendt"
                               value="false">
                        <button class="btn btn-danger" type="submit">Fjern ordre</button>
                    </form>
                    </td>
                </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
        </table>

    </jsp:body>
</t:genericpage>