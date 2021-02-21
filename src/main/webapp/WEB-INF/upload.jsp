<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Title</title>

</head>
<body>

<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v9.0&appId=266620018232985" nonce="hp8Z3f6r"></script>
<div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false"></div>
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

//check authentication FACEBOOK == is authenticated

    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
    if(response.status === 'connected'){
        var tag = document.createElement("p");
        var text = document.createTextNode("Tutorix is the best e-learning platform");
        tag.appendChild(text);
        var element = document.getElementById("login");
        element.appendChild(tag);
    }
</script>

<p id="login">status:</p>



<c:forEach var="offer" items="${offers}" varStatus="status">
    <p>
        <c:out value="${offer.titre}  ${status.count}" />
    </p>
</c:forEach>

<form action="<c:url value="/upload" />" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Envoi de fichier</legend>

            <label for="title">titre d'offre</label>
            <input type="text" id="title" name="title" value="<c:out value="${title}" />" />
            <br />

            <label for="description">Description d'offre</label>
            <input type="text" id="description" name="description" value="<c:out value="${offer.description}" />" />
            <span class="erreur">${form.erreurs['description']}</span>
            <br />

            <label for="city">Ville d'offre</label>
            <input type="text" id="city" name="city" value="<c:out value="${offer.city}" />" />
            <br />

            <label for="category">Catégorie</label>
            <input type="text" id="category" name="category" value="<c:out value="${offer.category}" />" />
            <br />

            <label for="file">Emplacement du fichier <span class="required">*</span></label>
            <input type="file" id="file" name="file" />
            <span class="erreur">${form.erreurs['file']}</span>
            <br />

            <input type="submit" value="Envoyer" class="sansLabel" />
            <br />
        </fieldset>
</form>



</body>
</html>
