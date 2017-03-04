<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Dashboard</title>
  <!-- CORE CSS-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="shortcut icon" type="image/png" href="img/login.png"/>
<body class="dashboard-body">

<ul id="dropdown1" class="dropdown-content">
  <li><a href="login.html">Login</a></li>
  <li><a href="#!">Profile</a></li>
  <li class="divider"></li>
  <li><a href="#!">Logout</a></li>
</ul>
  <nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo"><i class="material-icons left">dashboard</i>Dashboard</a>
      <ul class="right hide-on-med-and-down">
        <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Welcome Alok Bajpai<i class="material-icons right">arrow_drop_down</i></a></li>
      </ul>
    </div>
  </nav>
  <div class="container">
  <div class="nav-wrapper">
      
    </div>
    <div class="row">
    <div class="col s12 m3 card-margin">
      <a href="dashboard.html">
        <div class="card card-1">
            <div class="card-image">
              <i class="mdi-social-person-add registations"></i>
              <p class="text-center">Registration</p>
            </div>
          </div>
        </a>
    </div>
      <div class="col s12 m3 card-margin">
      <a href="admission.html">
        <div class="card card-1">
            <div class="card-image">
              <img src="img/ad.png" class="img-card">
              <p class="text-center">Admission</p>
            </div>
          </div>
        </a>
    </div>
    <div class="col s12 m3 card-margin">
      <a href="dashboard.html">
        <div class="card card-1">
            <div class="card-image">
              <img src="img/pro.png" class="img-card">
              <p class="text-center">Profile</p>
            </div>
          </div>
        </a>
    </div>
    <div class="col s12 m3 card-margin">
      <a href="dashboard.html">
        <div class="card card-1">
            <div class="card-image">
              <img src="img/fin.png" class="img-card">
              <p class="text-center">$ Finance</p>
            </div>
          </div>
        </a>
    </div>
      </div>

 <script type="text/javascript" src="js/jquery.min.js"></script>
  <!--materialize js-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
      

 

  
</body>

</html>