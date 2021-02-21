<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--FACEBOOK API SDK-->
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '{266620018232985}',
            cookie     : true,
            xfbml      : true,
            version    : '{v9.0}'
        });

        FB.AppEvents.logPageView();

    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>

<!--check authentication FACEBOOK == is authenticated-->
<script>
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
</script>

<c:forEach var="offer" items="${offers}">
    <p>
        <c:out value="${offer.titre}" />
    <p>
</c:forEach>





</body>
</html>
