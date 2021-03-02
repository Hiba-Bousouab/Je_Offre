<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Title</title>
    <%@ include file="bootstrapIncludes.jsp" %>
</head>
<body>

<%@ include file="header.jsp" %>
<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <section >
            <form action="<c:url value="/upload" />" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend>Publier une Offre</legend>
                    <div class="form-group ">
                        <label for="title">Titre d'offre</label>
                        <input type="text" id="title" name="title"  placeholder="Title" value="<c:out value="${offer.titre}" />" />
                        <span class="erreur">${form.errors['title']}</span>
                        <span class="erreur">${form.errors['user']}</span>
                        <br />
                    </div>

                    <div class="form-group ">
                        <label for="description">Description d'offre</label>
                        <textarea type="text"  class="form-control"  id="description" placeholder="Description" rows="3" name="description" value="<c:out value="${offer.description}" />" >
                </textarea>
                        <span class="erreur">${form.errors['description']}</span>
                        <br />
                    </div>

                    <div class="form-group ">
                        <label for="city">Ville d'offre</label>
                        <select id="city" class="form-control" name="city" value="<c:out value="${offer.city}" />">
                            <c:forEach var="ville" items="${City}" varStatus="status" >
                                <option value="${status.index}">${ville}</option>
                            </c:forEach>
                        </select>
                        <span class="erreur">${form.errors["city"]}</span>
                        <br />
                    </div>

                    <div class="form-group ">
                        <label for="category">Catégorie</label>
                        <select id="category" class="form-control" name="category" value="<c:out value="${offer.category}" />">
                            <c:forEach var="category" items="${Category}" varStatus="status">
                                <option value="${status.index}">${category}</option>
                            </c:forEach>
                        </select>
                        <span class="erreur">${form.errors['category']}</span>
                        <br />
                    </div>
                    <div class="form-group ">
                        <label for="file">Emplacement du fichier <span class="required">*</span></label>
                        <input type="file" id="file" name="file" />
                        <span class="erreur">${form.errors['file']}</span>
                        <br />
                    </div>
                    <div class="centre">
                        <input type="submit" value="publier" class="sansLabel" />
                        <br />
                    </div>
                </fieldset>
            </form>
        </section>
    </div>
    <div class="col-sm-3"></div>
</div>


<%@ include file="bootstrapIncludeLast.jsp" %>
<div>
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>