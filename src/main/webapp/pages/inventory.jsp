<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Inventory</title>
  <!-- CORE CSS-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <link rel="stylesheet" href="css/materialize.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="shortcut icon" type="image/png" href="img/login.png"/>
<body class="dashboard-body">

  <%@ include file="../includes/header.jsp"%>
  <div class="container">
  <div class="nav-wrapper">
      
    </div>
    <div class="row">
    <div class="col s12 m3 card-margin">
      <a href="inventoryCategory.do">
        <div class="card card-1">
            <div class="card-image" style="height: 187px;">
              <img src="img/addc.png" class="img-card" style="padding: 16px;">
              <p class="text-center">Add Item</p>
            </div>
          </div>
        </a>
    </div>
      <div class="col s12 m3 card-margin">
      <a href="report.do">
        <div class="card card-1">
            <div class="card-image" style="height: 187px;">
              <img src="img/add-file.png" class="img-card" style="padding: 16px;">
              <p class="text-center">Add Inventory</p>
            </div>
          </div>
        </a>
    </div>
    <div class="col s12 m3 card-margin">
      <a href="daybook.do">
        <div class="card card-1">
            <div class="card-image" style="height: 187px;">
              <img src="img/sc.png" class="img-card" style="padding: 16px;">
              <p class="text-center">sample</p>
            </div>
          </div>
        </a>
    </div>

     
 </div>

 <script type="text/javascript" src="js/jquery.min.js"></script>
  <!--materialize js-->
  <script src="js/materialize.min.js"></script>
      

 

  
</body>

</html>