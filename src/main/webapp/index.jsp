<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <%@ include file="WEB-INF/bootstrapIncludes.jsp" %>


</head>
<body style="background-color: #a598ee;text-align:center">
    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <form action="#" method="post" >
                <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12 p-0">
                                <input type="text" class="form-control search-slt" placeholder="Rechercher . . .">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                <select class="form-control search-slt" id="exampleFormControlSelect1">
                                    <option>Select Vehicle</option>
                                    <option>Example one</option>
                                </select>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                <button  type="submit button" class="btn btn-danger wrn-btn"><i class="fa fa-search fa-lg" aria-hidden="true"></i></button>
                            </div>
                </div>
                <div class="row categories">
                                <div class="col-md-4 card">
                                    <a href="offers">
                                        <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/Mb8kaPV.png" width="50">
                                            <div class="text-center mg-text"> <span class="mg-text">Account</span> </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 card">
                                    <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/ueLEPGq.png" width="50">
                                        <div class="text-center mg-text"> <span class="mg-text">Payments</span> </div>
                                    </div>
                                </div>
                                <div class="col-md-4 card">
                                    <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/tmqv0Eq.png" width="50">
                                        <div class="text-center mg-text"> <span class="mg-text">Delivery</span> </div>
                                    </div>
                                </div>
                                <div class="col-md-4  card">
                                    <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/D0Sm15i.png" width="50">
                                        <div class="text-center mg-text"> <span class="mg-text">Product</span> </div>
                                    </div>
                                </div>
                                <div class="col-md-4 card">
                                    <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/Z7BJ8Po.png" width="50">
                                        <div class="text-center mg-text"> <span class="mg-text">Return</span> </div>
                                    </div>
                                </div>
                                <div class="col-md-4 card">
                                    <div class="card-inner p-3 d-flex flex-column align-items-center"> <img src="https://i.imgur.com/YLsQrn3.png" width="50">
                                        <div class="text-center mg-text"> <span class="mg-text">Guarantee</span> </div>
                                    </div>
                                </div> 
                </div>
            </form>
        </div>
    </div>
       
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <div>
        <%@ include file="WEB-INF/footer.jsp" %>
    </div>
</body>
</html>
