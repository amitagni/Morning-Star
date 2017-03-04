<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Fee Details</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
   <body class="dashboard-body">
      <ul id="dropdown1" class="dropdown-content">
         <li><a href="login.html">Login</a>
         </li>
         <li><a href="#!">Profile</a>
         </li>
         <li class="divider"></li>
         <li><a href="#!">Logout</a>
         </li>
      </ul>
      <div class="navbar-fixed">
         <nav>
            <div class="nav-wrapper">
               <a href="#!" class="brand-logo img-logo"><img src="img/add.png">
               </a><span class="text-logo">Admission</span>
               <ul class="right hide-on-med-and-down">
                  <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Welcome Alok Bajpai<i class="material-icons right">arrow_drop_down</i></a>
                  </li>
               </ul>
            </div>
         </nav>
      </div>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
            <li ><a href="reg.html">Registration</a>
               </li>
                <li><a href="admission.html">Enrollment</a>
               </li>
               <li class="active_list"><a href="fee.html">Fee Details</a>
               </li>
               <li ><a href="payment.html">Payment</a>
               </li>
               <li><a href="#">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
      <div class="row_form valign-wrapper">
         <div class="col s12 offset-s1 valign">
            <div class="card-panel card-main">
               <div class="row">
                  <form class="formValidate" id="formValidate" method="get" action="" novalidate="novalidate">
                     <div class="col s4">
                        <h4 class="header2">Fee Details</h4>
                        <select class="error browser-default" id="crole" name="crole">
                           <option value="" disabled="" selected="">Payment Schedule</option>
                           <option value="1">xyz</option>
                           <option value="2">abc</option>
                           <option value="3">pqr</option>
                        </select>
                        <div class="input-field">
                           <div class="errorTxt6"></div>
                        </div>
                     </div>
                     <div class="col s12">
                        <h4 class="header2">Fee Structure</h4>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Class</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Monthly fee</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Quarterly fee</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Annual fee(12 Months)</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Exam fee</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">M.F (300X12)</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Annual Function</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">Miscellaneous</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s4">
                        <label for="address1" class="">TOTAL FEE</label>
                        <input id="fname" name="addresss1" type="text">
                        <div class="errorTxt1"></div>
                     </div>
                     <div class="input-field col s12 center-align button-margin">
                        <button class="btn waves-effect waves-light  submit left" type="submit" name="action">Save For Letter
                        <i class="mdi-content-save right"></i>
                        </button>
                        <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                        <i class="mdi-content-send right"></i>
                        </button>
                        <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
                        <i class="mdi-navigation-close right"></i>
                        </button>
                     </div>
                  </form>
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
             $('.dropify').dropify();
             $('select').material_select();
             // Translated
         
         });
      </script>
   </body>
</html>