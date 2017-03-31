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
      <title>Payment</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
  	 <body class="dashboard-body">
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
   	  <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
            <li ><a href="javascript:void();">Registration</a>
               </li>
               <li ><a class="active_list" href="javascript:void();">Payment</a>
               </li>
               <li><a href="javascript:void();">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
      <div class="row_form valign-wrapper">
         <div class="col s12 offset-s1 valign">
            <div class="card-panel card-main">
               <div class="row">
                  <form:form  modelAttribute="paymentFormBean"  action="reg-payment.do" method="post" novalidate="novalidate">
                     <div class="col s4">
                        <h4 class="header2">Payment Details</h4>
                        <div class="input-field ">
                        <label for="address1" class="">TOTAL FEE</label>
                        <form:input path="amount" type="text" />
                        <div class="errorTxt1"></div>
                     </div>
                        <div class="input-field">
                           <div class="errorTxt6"></div>
                        </div>
                     </div>
                     <div class="col s12">
                        <h5 class="header2">Select Payment option</h5>

                       
                     
                        </div>
                        <div class="col s3 margin-cash"> <input name="payment" type="radio" id="cash" data-error=".errorTxt8">
                        <label for="cash">Cash</label></div>
                        
                     <div class="input-field col s4">
                        <label for="dd" class="">Cash Received by</label>
                        <input id="dd" name="dd" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s12 center-align button-margin">
                        
                        </button>
                        <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                        <i class="mdi-content-send right"></i>
                        </button>
                        <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
                        <i class="mdi-navigation-close right"></i>
                        </button>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <!--materialize js-->
     <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
      
      <script type="text/javascript" src="js/dropify.min.js"></script>
      <script type="text/javascript">
         $('.datepicker').pickadate({
             selectMonths: true, // Creates a dropdown to control month
             selectYears: 15 // Creates a dropdown of 15 years to control year
         });
         $(document).ready(function() {
             // Basic
             
             $('select').material_select();
             // Translated
         
         });
      </script>
   </body>
</html>