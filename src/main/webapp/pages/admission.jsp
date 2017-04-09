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
      <link rel="stylesheet" href="css/materialize.min.css">
   <body class="dashboard-body">
        <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
               <li class="active_list"><a href="javascript:void();">Enrollment</a>
               </li>
               <li ><a href="javascript:void();">Fee Details</a>
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
            <div class="row">
            <div class="col s4 m3 input-field">
               <h4 class="header2">Student Details</h4>
               </div>
               <div class="col s8 m4 input-field searchtop">
          <i class="material-icons prefix">search</i>
          <input type="text" id="autocomplete-input" class="autocomplete">
          <label for="autocomplete-input">Registration no</label>
        </div>
        </div>
               <div class="row">
                  <form:form  modelAttribute="admissionFormBean"  action="admission.do" method="post" enctype="multipart/form-data" class="formValidate" novalidate="novalidate">
                     <div class="row">
                        <div class="col s9">
                           <div class="input-field col s12 m4">
                              <label for="fname" class="">First Name of Student*</label>
                              <form:input path="studentDetails.firstName" type="text" id="fname"  required="required" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Last Name Student</label>
                              <form:input path="studentDetails.lastName" type="text" id="lname" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="da" class="">Date of Application*</label>
                               <form:input path="applicationDate" type="text" id="da" class="datepicker" required="required" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="mn" class="">Mother's Name*</label>
                              <form:input path="studentDetails.motherName" id="mn" type="text" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="ffname" class="">Father's Name *</label>
                              <form:input path="studentDetails.fatherName" id="ffname" type="text" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="fatho" class="">Father's Occupation </label>
                               <input  id="fatho" type="text" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="classto">Class to which Admission is sought*</label>
                               <form:select  class="error browser-default" path="studentDetails.studentAdmissionClass"  id="classto">
                                <form:options items="${admissionFormBean.studentClassList}" itemValue="code"  itemLabel="name"  />
                               </form:select>
                              
                                 <div class="errorTxt6"></div>
                              
                           </div>
                           <div class="col s12 m4">
                              <label for="section">Section </label>
                               <form:select class="error browser-default" path="studentDetails.section" id="section">
                                <form:options items="${admissionFormBean.sectionList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                             
                           </div>
                           <div class="col s12 m4">
                          		 <label for="house">House </label>
                               <form:select class="error browser-default" path="studentDetails.house" id="house">
                                <form:options items="${admissionFormBean.houseList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                            <label></label>
                          </div>
                           <div class="input-field col s12 m4">
                              <select multiple>
                                 <option value="" disabled selected> Choose Subject</option>
                                 <option value="1">Science</option>
                                 <option value="2">Math's</option>
                                 <option value="3">Biology</option>
                              </select>
                              <label>Subject Offered</label>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="dob" class="">Date Of Birth*</label>
                              <form:input path="studentDetails.dob" type="text" id="dob" class="datepicker" required="required" />
                              <div class="errorTxt3"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for=up class=""> Since how long residing Uttar Pradesh</label>
                              <form:input path="timeOfResiding" type="text" id="up" class="datepicker" />
                              <div class="errorTxt3"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="section">Nationality </label>
                               <form:select class="error browser-default" path="studentDetails.nationality" id="section">
                                <form:options items="${admissionFormBean.sectionList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                             
                           </div>
                           <%-- <div class="input-field col s12 m4">
                              <label for="nati" class="">Nationality*</label>
                               <form:input path="studentDetails.nationality" id="nati" type="text" />
                              <div class="errorTxt2"></div>
                           </div> --%>
                           <div class=" col s12 m4">
                               <label for="reli" class="">Religion</label>
                               <%--<form:input path="studentDetails.religion" id="reli" type="text" />
                              <div class="errorTxt2"></div> --%>
                              <form:select class="error browser-default" path="studentDetails.religion" id="reli" name="crole">
                              <option value="" disabled="" selected="">Choose  Religion</option>
                              <option value="1">Hindu</option>
                              <option value="2">Muslim</option>
                              <option value="3">Sikh </option>
                              <option value="3">Christian </option>
                           </form:select>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="caste" class="">Caste</label>
                               <form:input path="studentDetails.caste" id="caste" type="text" onkeypress="return onlyAlphabets(event,this);"/>
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="col s12 m4">
                              <label for="categ">Category *</label>
                              <form:select class="error browser-default" path="studentDetails.category" id="categ">
                                <form:options items="${admissionFormBean.categoryList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lasts" class="">Last School Attended</label>
                              <form:input path="lastSchool" type="text" id="lasts"/>
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lastca" class="" id="lastca">Last Class Attended</label>
                              <form:input path="lastClass" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class=" col s12 m4">
                             <%--  <label for="resullast" class="">Result of the last class</label>
                               <form:input path="lastClassResult" id="resullast" type="text" />
                              <div class="errorTxt1"></div> --%>
                              <label for="lastClassResult">Result of the last class *</label>
                          <form:select class="error browser-default" path="lastClassResult" id="lastClassResult" name="crole">
                             
                              <option value="1"  selected="1">Pass</option>
                              <option value="2">Fail</option>
                              <option value="3">Awaited</option>
                           </form:select>
                           </div>
                           
                           <div class="col s12 m4">
                              <label for="genter_select">Gender *</label>
                              <p>
                              	 <form:radiobutton path="studentDetails.gender" id="gender_male"  value="M" />
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <form:radiobutton path="studentDetails.gender" id="gender_female" value="F" />
                                 <label for="gender_female">Female</label>
                              </p>
                              <div class="input-field">
                                 <div class="errorTxt8"></div>
                              </div>
                           </div>
                        </div>
                        <div class="col s12 m3">
                           <label for="att" class="">Attach Photo</label>
                           <div class="input-field">
                           		 <form:input type="file" path="studentPhoto"  class="dropify" data-default-file="img/u.png"  />
                             	 <!-- <input type="file" class="dropify" data-default-file="img/u.png" /> -->
                           </div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="doc" class="">Attach Transfer/ proof of Date of Birth</label>
                           <div class="input-field">
                           		<form:input type="file" path="studentTc" class="dropify" data-default-file="img/f.png"  />
                               <!--  <input type="file" class="dropify" data-default-file="img/f.png" /> -->
                           </div>
                        </div>
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1*</label>
                            <form:input path="contactDetails.address1" id="address1" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address2" class="">Address Line2</label>
                           <form:input path="contactDetails.address2" id="address2" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="area" class="">Area/Locality/Landmark*</label>
                            <form:input path="contactDetails.area" id="area" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="city" class="">City*</label>
                           <form:input path="contactDetails.city" type="text" id="city" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                           <div class="errorTxt1"></div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="state">States*</label>
                           <select class="error browser-default" id="state" name="crole">
                              <option value="" disabled="" selected="">Choose your State</option>
                              <option value="1">Uttar Pradesh</option>
                              <option value="2">NCR</option>
                              <option value="3">Haryana</option>
                           </select>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="pin" class="">Pin Code *</label>
                            <form:input path="contactDetails.pincode" id="pin" type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="phone" class="">Father's Mobile No.*</label>
                            <form:input path="contactDetails.phone" id="phone" type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="mob" class="">Mother's Mobile No.</label>
                           <form:input path="contactDetails.mobile" id="mob" type="number" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="email" class="">Email*</label>
                            <form:input path="contactDetails.email" id="email" type="email" required="required" />
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
                              <input type="checkbox" id="test6" />
                              <label for="test6">Brother/Sister Studying in Morning Star</label>
                           </p>
                        </div>
                        <div class="col s12 m12">
                           <p class="p_check_mar">
                              <input type="checkbox" id="test7" />
                              <label for="test7">I have carefully read all the detalis of school, and i agree to pay all fees as may be prescribed by the institution form time to time</label>
                           </p>
                        </div>
                        
                         <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action" onclick = "submitForm('admissionFormBean')" >Submit
                          			<img src="img/save.png" class="button-img">
                          		 </button>
                          		 <a class="btn waves-effect waves-light  submit  reset" type="submit" name="action">Reset
                           			<img src="img/cancel.png" class="button-img">
                           		</a>
                          </div>
                        <!-- <div class="input-field col s12 center-align button-margin">
                           <button class="btn waves-effect waves-light  submit left"  onclick = "submitForm('admissionFormBean')" >Save For Letter
                           <i class="mdi-content-save right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit center-btn"  onclick = "submitForm('admissionFormBean')" >Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
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
      <script src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
       <link href="css/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/jquery-ui.js" ></script>
<script src="js/jquery.validate.min.js"></script>
      <script type="text/javascript">
         $('.datepicker').pickadate({
        	 closeOnSelect: true,
        	 onSet: function (ele) {
        		   if(ele.select){
        		          this.close();
        		   }
        		}
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
          /* $.validator.setDefaults({
       	    errorClass: 'invalid',
       	    validClass: "valid",
       	    errorPlacement: function (error, element) {
       	        $(element)
       	            .closest("form")
       	            .find("label[for='" + element.attr("id") + "']")
       	            .attr('data-error', error.text());
       	    },
       	    submitHandler: function (form) {
       	        console.log('form ok');
       	       
       	    }
       	});

       	$(".formValidate").validate({
       	    rules: {
       	        dateField: {
       	            date: true
       	        }
       	    }
       	
       	}); */
        function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
        }
        $('input').bind("cut copy paste",function(e) {
            e.preventDefault();
        });
        $(".reset").click(function() {
            $(this).closest('form').find("input[type=text], textarea,input[type=number], textarea,input[type=email]").val("");
        });
      </script>
      <!--materialize js-->
   </body>
</html>