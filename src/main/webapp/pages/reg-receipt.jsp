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
      <title>Recipt Form</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" media="print" href="css/print.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
   <body class="dashboard-body">
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
            <li ><a href="javascript:void();">Registration</a>
               </li>
               <li ><a href="javascript:void();">Payment</a>
               </li>
               <li><a class="active_list" href="javascript:void();">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
      <div class="row_form valign-wrapper">
         <div class="col s12 m12 recipt-width" style="width: 100%;">
            <div class="card-panel card-main">
        
          <div class="col s12 m12 text-center logo-recipt">
            <img src="img/login.png" alt="" class="responsive-img valign profile-image-login size-logo center ">
          </div>
      
            <h4 class="text-center"><u>Registration Fee Receipt</u></h4>
            <br>
            <div class="row">
            <div class="col s6 offset-s2">
              <h5> Name    - ${name } </h5>  
            <h5> Class     - ${stcls }</h5>
            </div>
            <div class="col s4">
            
            <h5><span class="date">Date  -  ${dt }</span></h5>
            </div>
            </div>
            
               <h5 class="text-center">Congratulations, Registration process has been
Successfully Completed. !!!</h5>
<br>
<h5 class="text-center">This is notify  that sum of &#8377; <span><b>${amt}</b></span> has been deposited towards registration fee in cash</h5><BR>
<h5 class="text-center">Your registration no is :<b>${id }</b></h5>

<br>
<h5 class="text-center">Plesase keep this registration no. safe with you as this will be used further in admission process</h5>
<div class="input-field col s12 text-center">
            <button onclick="printme()" class="btn waves-effect waves-light">Print</button>
          </div>
         </div>
      </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      
      <script type="text/javascript">
         


function printme() {
    window.print();
}
      </script>
   </body>
</html>