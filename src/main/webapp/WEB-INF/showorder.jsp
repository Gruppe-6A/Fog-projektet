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

                <form>
                    <div class="form-group">
                        <label for="replyNumberL">Længde</label>
                        <input type="number" id="replyNumberL" min="0" data-bind="value:replyNumber" />
                        <label for="replyNumberB">Bredde</label>
                        <input type="number" id="replyNumberB" min="0" data-bind="value:replyNumber" />
                        <p>Ønsker du at have et skur:</p>
                        <input type="radio" id="ja" name="skur" value="ja">
                        <label for="ja">Ja</label><br>
                        <input type="radio" id="nej" name="skur" value="nej">
                        <label for="nej">Nej</label><br>
                    </div>
                    <button type="submit" class="btn btn-primary">Send forespørgsel</button>
                </form>
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>