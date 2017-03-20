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
      <title>Addmission</title>
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
            <li ><a href="reg.html">Registration</a>
               </li>
               <li class="active_list"><a href="admission.html">Enrollment</a>
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
                  <form:form  modelAttribute="admissionFormBean"  action="admission.do" method="post" novalidate="novalidate">
                     <div class="row">
                        <div class="col s9">
                           <div class="input-field col s12 m4">
                              <label for="fname" class="">First Name of Scholar</label>
                              <form:input path="studentDetails.firstName" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Last Name Scholar</label>
                              <form:input path="studentDetails.lastName" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Date of Application</label>
                               <form:input path="applicationDate" type="text" class="datepicker" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Mother's Name </label>
                              <form:input path="studentDetails.motherName" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Father's Name </label>
                              <form:input path="studentDetails.fatherName" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="crole">Class to which Admission is sought*</label>
                               <form:select class="error browser-default" path="" >
                                <form:options items="${admissionFormBean.studentClassList}" itemValue="code"  itemLabel="name"  />
                               </form:select>
                              <div class="input-field">
                                 <div class="errorTxt6"></div>
                              </div>
                           </div>
                           <div class="col s12 m4">
                              <label for="crole">Section *</label>
                               <form:select class="error browser-default" path="studentDetails.section" >
                                <form:options items="${admissionFormBean.sectionList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                             
                           </div>
                           <div class="input-field col s12 m4">
                               <form:select class="error browser-default" path="studentDetails.house" >
                                <form:options items="${admissionFormBean.houseList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                            <label>Images in select</label>
                          </div>
                           <div class="input-field col s12 m4">
                              <select multiple>
                                 <option value="" disabled selected> chosee subject</option>
                                 <option value="1">Sinece</option>
                                 <option value="2">Math's</option>
                                 <option value="3">Bio</option>
                              </select>
                              <label>Subject Offered</label>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="password" class="">Date Of Birth*</label>
                              <form:input path="studentDetails.dob" type="text" class="datepicker" />
                              <div class="errorTxt3"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="date" class=""> since how long residing uttar pradesh</label>
                              <form:input path="timeOfResiding" type="text" class="datepicker" />
                              <div class="errorTxt3"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Nationality*</label>
                               <form:input path="studentDetails.nationality" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Religion*</label>
                               <form:input path="studentDetails.religion" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Caste*</label>
                               <form:input path="studentDetails.caste" type="text" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="crole">Category *</label>
                              <form:select class="error browser-default" path="" >
                                <form:options items="${admissionFormBean.categoryList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="address1" class="">Last School Attended</label>
                              <form:input path="lastSchool" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="address1" class="">Last Class Attended</label>
                              <form:input path="lastClass" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="address1" class="">Result of the last class</label>
                               <form:input path="lastClassResult" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="address1" class="">Name Of Institution (Last Attended)</label>
                               <form:input path="lastSchool" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="genter_select">Gender *</label>
                             <p>
                              	 <form:radiobutton path="studentDetails.gender"  value="M" />
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <form:radiobutton path="studentDetails.gender"  value="F" />
                                 <label for="gender_female">Female</label>
                              </p>
                              <div class="input-field">
                                 <div class="errorTxt8"></div>
                              </div>
                           </div>
                        </div>
                        <div class="col s12 m3">
                           <label for="address1" class="">Attech Photo</label>
                           <div class="input-field">
                              <input type="file" class="dropify" data-default-file="img/u.png" />
                           </div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="address1" class="">Attech Transfer/ proof of Date of Birth</label>
                           <div class="input-field">
                              <input type="file" class="dropify" data-default-file="img/u.png" />
                           </div>
                        </div>
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1</label>
                            <form:input path="contactDetails.address1" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line2</label>
                           <form:input path="contactDetails.address2" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Area</label>
                            <form:input path="contactDetails.area" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">City</label>
                           <form:input path="contactDetails.city" type="text" />
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
                            <form:input path="contactDetails.pincode" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Phone</label>
                            <form:input path="contactDetails.phone" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Mobile No.</label>
                           <form:input path="contactDetails.mobile" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Email</label>
                            <form:input path="contactDetails.email" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="col s12 m4 ">
                           <p>
                              <input type="checkbox" id="test5" />
                              <label for="test5">Do you want School vehicle for 12 months</label>
                           </p>
                        </div>
                        <div class="col s12 m4">
                           <p>
                              <input type="checkbox" id="test5" />
                              <label for="test5">Brother/Sister Studying in Morning Star</label>
                           </p>
                        </div>
                        <div class="col s12 m12">
                           <p class="p_check_mar">
                              <input type="checkbox" id="test5" />
                              <label for="test5">I have carefully read all the detalis of school, and i agree to pay all fees as may be prescribed by the institution form time to time</label>
                           </p>
                        </div>
                        <div class="input-field col s12 center-align button-margin">
                           <button class="btn waves-effect waves-light  submit left"  onclick = "submitForm('admissionFormBean')" >Save For Letter
                           <i class="mdi-content-save right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit center-btn"  onclick = "submitForm('admissionFormBean')" >Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
                        </div>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
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
             
             // Translated
         
         });
         
         function submitForm(formId){
       		 $("#"+formId).submit();
       	 }
          $(document).ready(function() {
         $('select').material_select();
         });
         
      </script>
      <!--materialize js-->
   </body>
</html>