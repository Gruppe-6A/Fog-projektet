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

    <jsp:body>-
        <div>
            <h1>Velkommen til about</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis tincidunt tortor, a interdum diam. Donec accumsan, justo eu ultrices maximus, ligula nisl porta arcu, vitae maximus odio lorem blandit justo. Etiam mattis odio tortor, volutpat sagittis eros laoreet in. Nulla vitae congue nunc. Vivamus eget ultrices justo. Cras pellentesque mollis orci vel elementum. Donec suscipit fermentum velit non aliquet. Vestibulum et dapibus lorem. Quisque egestas diam in ante placerat, ac sodales mauris tempor. Curabitur non sodales diam. Mauris imperdiet ornare nulla a fermentum. Integer a mattis est. Nulla lobortis sapien et dolor interdum, nec tempus mauris bibendum.
                Nutella porttitor, justo eget congue gravida, arcu purus tristique magna, in molestie dolor velit non dui. Nullam magna mauris, venenatis sed tincidunt sed, scelerisque ut felis. Pellentesque euismod congue est, et scelerisque arcu laoreet eu. Aliquam venenatis nisi metus, et vulputate mi lacinia ac. Sed in pharetra risus. Suspendisse potenti. Nam vehicula porttitor dui, quis tempus nisl lacinia a. Pellentesque aliquet nibh et purus tincidunt, sed pellentesque mi condimentum. Morbi ac libero dictum, auctor tellus sed, dictum enim. Proin viverra enim a urna ultrices bibendum. Proin vel augue accumsan, porttitor risus nec, rhoncus nisi. Maecenas non pretium felis, vitae cursus lectus. Aenean semper condimentum orci volutpat aliquam. Nullam tempus ullamcorper sapien. Aliquam erat volutpat. Pellentesque rutrum eu nunc sed luctus.
                Ut ut dignissim ante, in fermentum ex. Etiam placerat sapien ante, eget euismod purus lobortis quis. Aenean in libero vitae massa convallis egestas. Aenean aliquam consectetur leo, eget luctus nisl auctor eu. Mauris molestie suscipit nisi, eget pellentesque nunc vulputate ut. Quisque auctor sed neque a rutrum. Donec ut imperdiet massa. In pharetra ante sit amet lacus fermentum, in tempus lorem porta. Suspendisse mollis mi scelerisque aliquam dictum. Quisque risus mi, ultricies ut congue a, commodo a nisl. Sed molestie ultricies dolor, nec tempus felis placerat id. Suspendisse interdum, turpis venenatis consectetur interdum, magna lorem vulputate metus, sed egestas diam arcu in ligula. Aliquam id laoreet lectus. Integer semper dui vel tempor tristique. Praesent posuere, orci eget cursus pretium, diam augue facilisis ex, placerat aliquet nisi orci nec urna. Duis efficitur iaculis tortor non cursus.
                Pellentesque consectetur odio ut lectus pulvinar, ornare cursus turpis mollis. Nullam sapien sem, consequat ut sodales sed, sollicitudin ut velit. Mauris tincidunt eget leo non fringilla. In nec risus nec erat ultrices scelerisque eget nec felis. Sed cursus congue sem, eu semper risus lacinia et. Ut fringilla id justo at rhoncus. Aenean finibus elit a quam porta, molestie laoreet nulla pulvinar. Nullam dapibus maximus tortor eu pretium.
                Nutella condimentum in ante et ornare. Donec eu velit lacus. Sed in arcu molestie, convallis dui vitae, pulvinar neque. Suspendisse ex sapien, blandit et consectetur quis, sagittis quis nulla. In sed sapien suscipit, hendrerit mauris a, fermentum felis. Nullam tincidunt dignissim lectus sit amet posuere. In hac habitasse platea dictumst. Nam nisi mi, tincidunt sit amet dui eget, tincidunt tempor odio. Curabitur porta luctus lacus, id porttitor metus suscipit in. Ut ac velit auctor, auctor lacus ac, pharetra ex. Donec placerat mi nisi, id semper orci ullamcorper ac.</p>
        </div>
    </jsp:body>
</t:genericpage>