<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Title</title>

</head>
<body>

<form action="<c:url value="/upload" />" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Envoi de fichier</legend>

            <label for="title">Titre d'offre</label>
            <input type="text" id="title" name="title" value="<c:out value="${offer.titre}" />" />
            <span class="erreur">${form.errors['title']}</span>
            <br />

            <label for="description">Description d'offre</label>
            <input type="text" id="description" name="description" value="<c:out value="${offer.description}" />" />
            <span class="erreur">${form.errors['description']}</span>
            <br />

            <label for="city">Ville d'offre</label>
            <select id="city" name="city" value="<c:out value="${offer.city}" />">
                <c:forEach var="ville" items="${City}">
                    <option value="${ville.toString()}">${ville}</option>
                </c:forEach>
            </select>
            <span class="erreur">${form.errors["city"]}</span>
            <br />

            <label for="category">Catégorie</label>
            <select id="category" name="category" value="<c:out value="${offer.category}" />">
                <c:forEach var="category" items="${Category}">
                    <option value="${category.toString()}">${category}</option>
                </c:forEach>
            </select>
            <span class="erreur">${form.errors['category']}</span>
            <br />

            <label for="file">Emplacement du fichier <span class="required">*</span></label>
            <input type="file" id="file" name="file" />
            <span class="erreur">${form.errors['file']}</span>
            <br />

            <input type="submit" value="publier" class="sansLabel" />
            <br />
        </fieldset>
</form>



</body>
</html>
