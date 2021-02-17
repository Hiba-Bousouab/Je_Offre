<%@ page import="com.JOffre.Model.OffreModel" %><%--
  Created by IntelliJ IDEA.
  User: dragon
  Date: 1/26/21
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Offres</title>
    <!-- mdb -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.2.0/mdb.min.css"
            rel="stylesheet"
    />
    <!-- font awsome-->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <div id="page_container" class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"> <img src="logo_don.jpg" class="rounded-circle" width="30" height="30" class="d-inline-block align-top" alt="Logo">J'offre.ma</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <!-- le carree de l'annonce -->
    <main>
        <div class="container my-5">

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-7">
                    <section class="newsfeed my-5">
                        <div class="post">
                            <div class="card">
                                <div class="card-body">
                                    <div class="container">
                                        <!--auteur -->
                                        <div class="row">
                                            <div class="col-md-8">
                                                <div class="d-flex story">
                                                    <img href="/Anas_Abou_Ali" src="logo_don.jpg" class="rounded-circle" width="40" height="40" alt="Avatar"/>
                                                    <div class="md-2">
                                                        <a href="/Anas_Abou_Ali">
                                                            <strong class="mt-5 ml-2">Anas_Abou_Ali</strong>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--l'offre-->
                                <div class="bg-image hover-overlay ripple shadow-1-strong rounded"
                                     data-mdb-ripple-color="light">
                                    <img src="https://mdbootstrap.com/img/new/fluid/city/113.jpg" class="w-100" />
                                    <a href="#!">
                                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
                                    </a>
                                </div>
                                <!-- Interactions -->
                                <div  class="card-body">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-8">
                                                <i class="far fa-heart fa-lg ml-0"></i>
                                                <i class="fas fa-heart fa-lg ml-0"></i>
                                                <i class="far fa-comment fa-lg mx-2"></i>
                                            </div>
                                            <div class="col-md-4 text-right">
                                                <i class="far fa-paper-plane fa-lg"></i>
                                            </div>
                                        </div>
                                        <!-- Liked by -->
                                        <div class="row">
                                            <div class="col-md-8 mt-1">
                                                <img href="/Anas_Abou_Ali" src="logo_don.jpg" class="rounded-circle" width="20" height="20" alt="Avatar"/>
                                                <small>Aimee par <strong>4232 </strong>people</small>
                                            </div>
                                        </div>
                                        <!-- Description -->
                                        <div class="row">
                                            <div class="col-md-12 mt-1">
                                                <p>
                                                    <strong class="text-dark">Anas_Abou_Ali</strong> J'offre ce pyramide de merde pour les gens qui sont interisee contactee moi au privee.
                                                </p>
                                            </div>

                                        </div>
                                        <!-- Comments -->
                                        <div class="row">
                                            <!-- Visualisee tout les comentaire -->
                                        </div>
                                        <!-- Ajouter un commentair -->
                                        <hr />
                                        <div class="row mt-2">
                                                <div class="col-md-11">
                                                   <div class="form-outline">
                                                       <input type="text" id="form1" class="form-control" placeholder="Ajouter un commentaire" />
                                                   </div>
                                                 </div>
                                                <div class="col-md-1">
                                                    <p class="text-info mt-1">Publier</p>
                                                </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </main>
</body>
</html>
