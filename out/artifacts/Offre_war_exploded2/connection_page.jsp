<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<!-- Danger Zone facebook login api loader -->
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v9.0&appId=266620018232985&autoLogAppEvents=1" nonce="Z43c2Xq9"></script>
<script src="js/Oauth2.js"></script>
<div class="fb-login-button" data-width="" data-size="large" data-button-type="login_with" data-layout="default"
     data-auto-logout-link="false" data-use-continue-as="true" onLogin="checkLoginState()"></div>


</body>
</html>