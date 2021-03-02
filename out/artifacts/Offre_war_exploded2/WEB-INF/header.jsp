<header>
    <div class="wrapper">
        <div class="logo">
            <a href="">J'offre <strong>GRATUIREMENT</strong></a>
            <%-- <a class="navbar-brand" href="#"> <img src="logo_d.png" class="rounded-circle" width="30" height="30" class="d-inline-block align-top" alt="Logo">J'offre.ma</a>
            --%>
        </div>
        <nav>
            <a href="">Acceuil</a>
            <a href="">A propos</a>
            <a href="">Services</a>
            <a href="">Contact</a>
            <a href="">J'offre</a>
            <a href="">Se connecter</a>
        </nav>
    </div>
</header>


<%-- Previous Script --%>
<%--
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
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#connexion" >Se connecter</button>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="connexion" tabindex="-1" role="dialog" aria-labelledby="connexionLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                    <div id="fb-root"></div>
                    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v9.0&appId=266620018232985&autoLogAppEvents=1" nonce="Z43c2Xq9"></script>
                    <script src="js/Oauth2.js"></script>
                    <div class="fb-login-button" data-width="" data-size="large" data-button-type="login_with" data-layout="default"
                         data-auto-logout-link="false" data-use-continue-as="true" onLogin="checkLoginState()"></div>
                         <p> Bonjour <span id="name"></span> </p>
                <form method="POST" action="offers">
                    <input type="hidden" id="username" name="username"  />
                    <input type="hidden" id="idUser" name="idUser"  />
                    <button type="submit button" class="btn btn-primary">Continuer...</button>
                </form>
            </div>
        </div>
    </div>
</div>
--%>