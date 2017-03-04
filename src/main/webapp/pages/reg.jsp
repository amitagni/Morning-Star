<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Registration Form</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
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
               </a><span class="text-logo">Registration</span>
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
            <li class="active_list"><a href="reg.html">Registration</a>
               </li>
               <li ><a href="admission.html">Enrollment</a>
               </li>
               <li ><a href="fee.html">Fee Details</a>
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
               <h4 class="header2">Student Details</h4>
               <div class="row">
                  <form class="formValidate" id="formValidate" method="get" action="" novalidate="novalidate">
                     <div class="row">
                        
                           <div class="input-field col s12 m3">
                              <label for="fname" class="">Form No</label>
                              <input id="fname" name="fname" type="text">
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Date of Issue</label>
                              <input type="date" class="datepicker">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Registration No.</label>
                              <input id="fname" name="fname" type="text">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class=""> Student First Name</label>
                              <input id="lname" type="text">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Student Last Name</label>
                              <input id="lname" type="text">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Date of Birth</label>
                              <input type="date" class="datepicker">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Father’s Name</label>
                              <input id="lname" type="text">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Mother’s Name</label>
                              <input id="lname" type="text">
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="col s12 m3">
                              <label for="crole">Class to which Admission is sought*</label>
                              <select class="error browser-default" id="crole" name="crole">
                                 <option value="" disabled="" selected="">Choose your Class</option>
                                 <option value="1">10th</option>
                                 <option value="2">11th</option>
                                 <option value="3">12th</option>
                              </select>
                              
                           </div>
                           <div class="input-field col s12 m3">
                              <select multiple>
                                 <option value="" disabled selected> chosee subject</option>
                                 <option value="1">Sinece</option>
                                 <option value="2">Math's</option>
                                 <option value="3">Bio</option>
                              </select>
                              <label>Subject Offered</label>
                           </div>
                           
                          
                           
                           <div class="col s12 m3">
                              <label for="crole">Category *</label>
                              <select class="error browser-default" id="crole" name="crole">
                                 <option value="" disabled="" selected="">Choose your Category</option>
                                 <option value="1">General</option>
                                 <option value="2">SC</option>
                                 <option value="3">OBC</option>
                              </select>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Last School Attended</label>
                              <input id="fname" name="addresss1" type="text">
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Last Class Attended</label>
                              <input id="fname" name="addresss1" type="text">
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Result of the last class</label>
                              <input id="fname" name="addresss1" type="text">
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Name Of Institution (Last Attended)</label>
                              <input id="fname" name="addresss1" type="text">
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="col s12 m3">
                              <label for="genter_select">Gender *</label>
                              <p>
                                 <input name="cgender" type="radio" id="gender_male" data-error=".errorTxt8">
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <input name="cgender" type="radio" id="gender_female" value="f">
                                 <label for="gender_female">Female</label>
                              </p>
                              
                           </div>
                        
                        
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line2</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Area</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">City</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="crole">States *</label>
                           <select class="error browser-default" id="crole" name="crole">
                              <option value="" disabled="" selected="">Choose your State</option>
                              <option value="1">Uttar Pradesh</option>
                              <option value="2">NCR</option>
                              <option value="3">Haryana</option>
                           </select>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Pin Code</label>
                           <input id="fname" name="Pincode" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Phone</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Mobile No.</label>
                           <input id="fname" name="addresss1" type="text">
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Email</label>
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
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
      
      <script type="text/javascript">
         $('.datepicker').pickadate({
             selectMonths: true, // Creates a dropdown to control month
             selectYears: 15 // Creates a dropdown of 15 years to control year
         });
         
          $(document).ready(function() {
         $('select').material_select();
         });
         
      </script>
      <!--materialize js-->
   </body>
</html>