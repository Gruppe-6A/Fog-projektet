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
            Her vises alle forespørgsler, hvis der er nogen

        <table>
            <thead><th>Id  </th><th>Kunde Id  </th><th>Længde  </th><th>Bredde  </th><th>godkend ordre  </th><th>afvis ordre</th></thead>
        <c:forEach var="orderList" items="${requestScope.orderList}">
            <tr>
                <td>${orderList.order_id}</td>
                <td>${orderList.users_id}</td>
                <td>${orderList.length}</td>
                <td>${orderList.width}</td>

                <td>
                <form action="Godkender">
                    <input type="hidden"
                           name="orderid"
                           value="${orderList.order_id}">
                    <input type="hidden"
                           name="godkendt"
                           value="true">
                    <button class="btn btn-primary" type="submit">Godkend ordre</button>
                </form>
                </td>

                <td>
                <form action="Godkender">
                    <input type="hidden"
                           name="orderid"
                           value="${orderList.order_id}">
                    <input type="hidden"
                           name="godkendt"
                           value="false">

                    <button class="btn btn-primary" type="submit">Fjern ordre</button>
                </form>
                </td>
            </tr>
        </c:forEach>

        </table>


    </jsp:body>
</t:genericpage>