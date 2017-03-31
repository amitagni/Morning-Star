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
      <title>Registration Form</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
   <body class="dashboard-body">
     
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
            <li class="active_list"><a href="javascript:void();">Registration</a>
               </li>
               <li ><a href="javascript:void();">Payment</a>
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
               <h4 class="header2">Student Details</h4>
               <div class="row">
                  <form:form  modelAttribute="registrationFormBean"  action="registration.do" method="post"  class="formValidate" novalidate="novalidate">
                     <div class="row">
                        
                           <div class="input-field col s12 m3">
                              <label for="fname" class="">Form No</label>
                              <form:input path="formNum" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Date of Issue</label>
                              <form:input path="dateOfIssue" class="datepicker" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Registration No.</label>
                              <form:input path="regNum"  type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class=""> Student First Name</label>
                              <form:input path="studentDetails.firstName"  type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Student Last Name</label>
                              <form:input path="studentDetails.firstName"  type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Date of Birth</label>
                              <form:input path="studentDetails.dob"  class="datepicker" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Father’s Name</label>
                              <form:input path="studentDetails.fatherName"  type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Mother’s Name</label>
                              <form:input path="studentDetails.motherName"  type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="col s12 m3">
                              <label for="crole">Class to which Admission is sought*</label>
                              <form:select class="error browser-default" path="" >
                                <form:options items="${registrationFormBean.studentClassList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                              
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
                              <form:select class="error browser-default" path="" >
                                <form:options items="${registrationFormBean.categoryList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Last School Attended</label>
                              <form:input path="lastSchool"  type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Last Class Attended</label>
                              <form:input path="lastClass" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Result of the last class</label>
                              <form:input path="lastClassResult"  type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="address1" class="">Name Of Institution (Last Attended)</label>
                              <form:input path="lastSchool" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="col s12 m3">
                              <label for="genter_select">Gender *</label>
                              <p>
                              	 <form:radiobutton path="studentDetails.gender" id="gender_male"  value="M" />
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <form:radiobutton path="studentDetails.gender" id="gender_female" value="F" />
                                 <label for="gender_female">Female</label>
                              </p>
                              
                           </div>
                        
                        
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1</label>
                           <form:input path="contactDetails.address1"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line2</label>
                           <form:input path="contactDetails.address2"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Area</label>
                           <form:input path="contactDetails.area"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">City</label>
                           <form:input path="contactDetails.city"  type="text" />
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
                           <form:input path="contactDetails.pincode"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Phone</label>
                           <form:input path="contactDetails.phone"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Mobile No.</label>
                           <form:input path="contactDetails.mobile"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Email</label>
                           <form:input path="contactDetails.email"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                       
                         <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action" onclick = "submitForm('registrationFormBean')" >Submit
                          			 <i class="mdi-content-send right"></i>
                          		 </button>
                          		 <button class="btn waves-effect waves-light  submit" type="submit" name="action">Cancel
                           			<i class="mdi-navigation-close right"></i>
                           		</button>
                          </div>
                        
                     <!--    <div class="input-field col s12 center-align button-margin">
                           <button class="btn waves-effect waves-light  submit left" onclick = "submitForm('registrationFormBean')" >Save For Letter
                           <i class="mdi-content-save right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit center-btn" onclick = "submitForm('registrationFormBean')" >Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light right submit" onclick = "" >Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
                        </div> -->
                     </div>
                  </form:form>
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
          
         function submitForm(formId){
       		 $("#"+formId).submit();
       	}
      </script>
      <!--materialize js-->
   </body>
</html>