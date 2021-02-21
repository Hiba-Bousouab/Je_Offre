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

<form action="<c:url value="/upload" />" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Envoi de fichier</legend>

            <label for="title">titre d'offre</label>
            <input type="text" id="title" name="title" value="<c:out value="${title}" />" />
            <br />

            <label for="description">Description d'offre</label>
            <input type="text" id="description" name="description" value="<c:out value="${description}" />" />
            <br />

            <label for="city">Ville d'offre</label>
            <input type="text" id="city" name="city" value="<c:out value="${city}" />" />
            <br />

            <label for="category">Catégorie</label>
            <input type="text" id="category" name="category" value="<c:out value="${city}" />" />
            <br />

            <label for="file">Emplacement du fichier <span class="required">*</span></label>
            <input type="file" id="file" name="file" />
            <span><c:out value="${file}" /></span>
            <br />

            <input type="submit" value="Envoyer" class="sansLabel" />
            <br />
        </fieldset>
</form>


</body>
</html>
