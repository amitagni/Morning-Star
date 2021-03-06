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
      <title>Search Page</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
      <style type="text/css">
         .placeholder {
    width: 175px;
    height: 150px;
    background-repeat: no-repeat;
    background-size: contain;
    border: 2px solid #aaaaaa;
}
.search-c{
    
    padding: 15px !important;
    
}
      </style>
   <body class="dashboard-body">
   	 <%@ include file="../includes/header.jsp"%>

     <div class="container_b serach-top">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                  <form class="formValidate" id="formValidate" method="get" action="" novalidate="novalidate">

                    <div class="col s12 m12 l12">
                        <div class="col s12 m4 input-field" style="margin-left: 50px;">
          <img src="img/search.png" class="serach-img">
          <input type="text" id="autocomplete-input" class="autocomplete">
          <label for="autocomplete-input">Search Student</label>
        </div><div class="col s12 m4 right">
                              <div class="placeholder">
    <div class="myimage"  style="background-image: url({somedynamicimageurl})"><img width="175px" height="150px" src="" id="stImage" /></div>
</div>
                           </div>
                           
                           <div class="col s12 m12" id="stDetails" >
                              
                                 <div class="col s12 m6">
                                    <h4> Student Details</h4>
                                 	   <div class=" col s12 m6">
                                           <p>UID</p>
                                           <p>Name</p>
                                           <p>Class</p>
                                           <p>Section</p>
                                           <p>House</p>
                                           <p>Father's Name </p>
                                       </div>
                                       <div class=" col s12 m6">
                                          <p id="uid"></p>
                                          <p id="stname"></p>
                                          <p id="stClass"></p>
                                          <p id="section"></p>
                                          <p id="house"></p>
                                          <p id="fname"></p>
                                       </div>
                                    
                                 </div>
                                 <div class="col s12 m6">
                                    <div class="col s12 m12">
                              <label for="crole">Choose Action</label>
                              <select class="error browser-default" id="crole" name="crole" onchange="openSelOption(this);">
                                 <option value="" disabled="" selected="">Choose your Action</option>
                                 <option value="1">Manage Admission Fee</option>
                                 <option value="2">Manage Registration Fee</option>
                                 <option value="3">Manage Acadamics</option>
                                 <option value="4">Manage Profile</option>
                              </select>
                              <div class="input-field">
                                 <div class="errorTxt6"></div>
                              </div>
                           </div>
                                 </div>
                              
                           </div>
                    </div>
       
                  </form>
               </div>
            </div>
         </div>
      </div>
      </div>
     
      </div>
      
      
 <!--      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
      <link href="css/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/jquery-ui.js" ></script> -->



<script type="text/javascript" src="js/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
  <script type="text/javascript" src="js/dropify.min.js"></script>
  <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>
 <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script> 
 <script type="text/javascript">
 var stId = -1;
	function openSelOption(obj){
	    	  if(stId == -1){
	    		  alert("Please Choose Student First");
	    	  }else{
	    		 // alert(obj.value);
	    		  if(obj.value == 1){
	    			  var url = "fee.do?id="+stId;
	    			  window.open(url, '_blank');
	    		  }else if(obj.value == 2){
	    			  var url = "reg-payment.do?id="+stId;
	    			  window.open(url, '_blank');
	    		  }
	    		  
	    	  }
	   }
	      
</script>
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
        
          $(document).ready(function() {
        	$('select').material_select();
        	/*  var fakedata = ['test1','test2','test3','test4','ietsanders'];
 			$("input.autocomplete").autocomplete({source:fakedata});
         	 }); */
          
           var fakedata = ['test1','test2','test3','test4','ietsanders'];
			$("input.autocomplete").autocomplete({source:function(request, response) {
	            $.ajax({
	                type: "get",
	          		url: "fetch-studentlist.do",
	          		cache: false,
	          		data: {"studentName":request.term},
	                dataType: "json",
	                success: function(data) {
	                    response(data);
	                }
	            });
	        },
	        select: function( event, ui ) {
	           console.log(ui.item.value)
	           this.value = ui.item.label;
	            $.ajax({
		                type: "get",
		          		url: "fetch-studentDetail.do",
		          		cache: false,
		          		data: {"studentId":ui.item.value},
		                dataType: "json",
		                success: function(data) {
		                    console.log(data);
		                    stId = data.id;
		                    document.getElementById('uid').innerHTML = data.id;
		                    document.getElementById('stname').innerHTML = data.name;
		                    document.getElementById('stClass').innerHTML = data.studentClass;
		                    if(data.section != null)
		                    	document.getElementById('section').innerHTML = data.section;
		                    else
		                    	document.getElementById('section').innerHTML = "N/A";
		                    if(data.house != null)
		                   	  document.getElementById('house').innerHTML = data.house;
		                    else
		                    	 document.getElementById('house').innerHTML = "N/A";
		                    if(data.fatherName != null)
		                    	document.getElementById('fname').innerHTML = data.fatherName;
		                    else
		                    	document.getElementById('fname').innerHTML = "N/A";
		                    document.getElementById('stImage').src = data.photoPath;
		                }
		            });
		       return false;
	          }, 
	        min_length: 3,
			autoFocus: true,
			cacheLength: 1,
			scroll: true,
			highlight: false,
	        delay: 300}); 
         });
          
        
        
      </script>
      <!--materialize js-->
   </body>
</html>