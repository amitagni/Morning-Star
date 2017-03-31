<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Fee Details</title>
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
               <li ><a href="javascript:void();">Enrollment</a>
               </li>
               <li class="active_list"><a href="javascript:void();">Fee Details</a>
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
          <form:form modelAttribute="feeFormBean"  action="fee.do" method="post" novalidate="novalidate" >
          <form:input path="studentId" type="hidden" />
           <form:input path="feeSummaryId" type="hidden" />
            <div class="card-panel card-main">
            <div class="row">
            
            <div class="col s12 m3"><h4 class="header2 text-center">Fee Details</h4></div>
               
                <div class="input-field col s12 m3">
               				 <form:select class="error browser-default" path="selMonth" >
                                <form:options items="${feeFormBean.monthList}" itemValue="code" id="month" itemLabel="name"  />
                              </form:select>
                              <!-- <select multiple>
                                 <option value="" disabled selected> Choose Months</option>
                                 <option value="1">L.KG</option>
                                 <option value="2">U.KG</option>
                                 <option value="3">PG</option>
                              </select> -->
                           </div>
                           </div>
               <div class="row">
                     <div class="row">

                        <!-- <div class="col s12 m12">
                           <h5> Monthly Fee</h5>
                        </div> -->
                        <div class="fee-selction col s12 m12">
                      <c:forEach items="${feeFormBean.monthlyFeeList}" var="feeDto" varStatus="status">
                   		  <form:hidden path="monthlyFeeList[${status.index}].id"  />
		                           
	                      <div class="input-field col s12 m3 col-fee">
	                           <label class="label-fee">${feeDto.name}</label>
	                        </div>
	
	                         <div class="input-field col s12 m3">
	                            <form:input placeholder="Placeholder" id="mfamt_${status.index}" path="monthlyFeeList[${status.index}].amount"  type="text" class="validate" />
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <form:input placeholder="Discount" id="mfdis_${status.index}" path="monthlyFeeList[${status.index}].discount" type="text" class="validate disc" onblur="setPaidAmount('m',this)" />
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <form:input placeholder="Final Amount" id="mfpamt_${status.index}" path="monthlyFeeList[${status.index}].paidAmount" type="text" class="validate" />
	                         </div>
                      </c:forEach>
                       
                        
                         
                         
                         <!-- <div class="col s12 m3 col-fee">
                           <label class="label-fee">M.F</label>
                        </div>
                        
                         <div class="input-field col s12 m3">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div>
                         <div class="col s12 m3 col-fee">
                           <label class="label-fee">Tution Fee</label>
                        </div>
                        
                         <div class="input-field col s12 m3">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div> -->
                         </div>
                         <!-- <div class="col s12 m12">
                           <h5>Quarterly Fee</h5>
                        </div> -->
                        <div class="fee-selction col s12 m12">
                        <div class="input-field col s12 m3 col-fee">
                           <label class="label-fee">Exam Fee</label>
                        </div>
                         <c:forEach items="${feeFormBean.quarterlyFeeList}" var="feeDto" varStatus="status">
                          	<form:hidden path="quarterlyFeeList[${status.index}].id"  />
		                        
		                         <c:choose>
		                         	<c:when test="${feeDto.paid}">
				                         <div class="input-field col s12 m2">
				                            <p class="text-center"><i class="material-icons green-text">done</i>${feeDto.name}</p>
				                           
				                         </div>
				                         <div class="input-field col s12 m2">
				                            <form:input placeholder="Placeholder" id="qfamt_${status.index}" path="quarterlyFeeList[${status.index}].amount" type="text" class="validate" />
				          
				                         </div>
		                         		<div class="input-field col s12 m2">
			                             	Paid
		                        		 </div>
				                         <div class="input-field col s12 m2">
				                            <form:input placeholder="inal Amount"   path="quarterlyFeeList[${status.index}].paidAmount" type="text" class="validate" disabled="true" />
				          
				                         </div>
		                         	</c:when>
		                         	<c:otherwise>
				                         <div class="input-field col s12 m2">
				                            <p class="text-center">${feeDto.name}</p>
				                           
				                         </div>
				                         <div class="input-field col s12 m2">
				                            <form:input placeholder="Placeholder" id="qfamt_${status.index}" path="quarterlyFeeList[${status.index}].amount" type="text" class="validate" />
				          
				                         </div>
		                         		 <div class="input-field col s12 m2">
		                             		<form:input placeholder="Discount" id="qfdis_${status.index}" path="quarterlyFeeList[${status.index}].discount" type="text" class="validate" onblur="setPaidAmount('q',this)" />
		          
		                        		 </div>
				                         <div class="input-field col s12 m2">
				                            <form:input placeholder="inal Amount" id="qfpamt_${status.index}" path="quarterlyFeeList[${status.index}].paidAmount" type="text" class="validate"/>
				          
				                         </div>
		                         	</c:otherwise>
		                         
		                         </c:choose>
		                         <!--  <div class="input-field col s12 m2">
                              <p class="text-center"><i class="material-icons green-text">done</i>APR</p>
                         </div>
                         <div class="input-field col s12 m2">
                            <p>500</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                           <P>PAID</P>
                         </div>
                         
                         <div class="input-field col s12 m2">
                         </div> -->
		                         <div class="col s12 m3 col-fee">
		                           &nbsp;
		                        </div>
                         </c:forEach>
                      
                        
                       <!--  <div class="input-field col s12 m2">
                            <p class="text-center">AUG</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div>
                         <div class="col s12 m3 col-fee">
                          &nbsp;
                        </div>
                        <div class="input-field col s12 m2">
                            <p class="text-center">SEP</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div>
                         <div class="col s12 m3 col-fee">
                          &nbsp;
                        </div>
                         <div class="input-field col s12 m2">
                            <p class="text-center">OCT</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m2">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div> -->
                         <!-- <div class="col s12 m12">
                           <h5>Half yeraly Fee</h5>
                        </div> -->
                        </div>
                        <div class="fee-selction col s12 m12">
                        <div class="input-field col s12 m3 col-fee">
                           <label class="label-fee">Annual Function Fee</label>
                        </div>
                         <c:forEach items="${feeFormBean.halfyearlyFeeList}" var="feeDto" varStatus="status">
                         	<form:hidden path="halfyearlyFeeList[${status.index}].id"  />
	                          <div class="input-field col s12 m2">
	                            <p class="red-done text-center"><i class="material-icons font-size-icon red-text">info_outline</i><span>${feeDto.name} </span></p>
	                           
	                         </div>
	
	                         <div class="input-field col s12 m2">
	                            <form:input placeholder="PlaceHolder" id="hfamt_${status.index}" path="halfyearlyFeeList[${status.index}].amount" type="text" class="validate"/>
		          
	          
	                         </div>
	                         <div class="input-field col s12 m2">
	                           <form:input placeholder="Discount" id="hfdis_${status.index}" path="halfyearlyFeeList[${status.index}].discount" type="text" class="validate" onblur="setPaidAmount('h',this)" />
		          
	                         </div>
	                         <div class="input-field col s12 m2">
	                            <form:input placeholder="Final Amount" id="hfpamt_${status.index}" path="halfyearlyFeeList[${status.index}].paidAmount" type="text" class="validate"/>
		          
	                         </div>
	                          <div class="col m3"> &nbsp;</div>
                         </c:forEach>
                          
                          
                          <!-- <div class="input-field col s12 m2">
                             <p class="green-done"><i class="material-icons font-size-icon">done</i><span>FEB </span></p>
                           
	                         </div>
	                         <div class="input-field col s12 m2">
	                            <input placeholder="Placeholder" type="text" class="validate">
	          
	                         </div>
	                         <div class="input-field col s12 m2">
	                            <input placeholder="Discount" type="text" class="validate">
	          
	                         </div>
	                         <div class="input-field col s12 m2">
	                            <input placeholder="Final Amount" type="text" class="validate">
	          
	                         </div>
          				 -->               
           				</div>
                         <!-- <div class="col s12 m12">
                           <h5>Yearly Fee</h5>
                        </div> -->
                        <div class="fee-selction col s12 m12">
                       <c:forEach items="${feeFormBean.anualFeeList}" var="feeDto" varStatus="status">
                      	 <form:hidden path="anualFeeList[${status.index}].id"  />
	                        <div class="col s12 m3 col-fee">
	                           <label class="label-fee">${feeDto.name}</label>
	                        </div>
	                        
	                         <div class="input-field col s12 m3">
	                           <form:input placeholder="Placeholder" id="afamt_${status.index}" path="anualFeeList[${status.index}].amount" type="text" class="validate"/>
		          
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <form:input placeholder="Discount" id="afdis_${status.index}" path="anualFeeList[${status.index}].discount" type="text" class="validate" onblur="setPaidAmount('a',this)" />
		          
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <form:input placeholder="Final Amount" id="afpamt_${status.index}" path="anualFeeList[${status.index}].paidAmount" type="text" class="validate"/>
		          
	          
	                         </div>
	                     </c:forEach>    
                         
                        <!-- <div class="col s12 m3 col-fee">
                           <label class="label-fee">Practical Fee</label>
                        </div>
                        
                         <div class="input-field col s12 m3">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div>
                         <div class="col s12 m3 col-fee">
                           <label class="label-fee">T.C Fee</label>
                        </div>
                        
                         <div class="input-field col s12 m3">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div>
                         <div class="col s12 m3 col-fee">
                           <label class="label-fee">Miscellaneous</label>
                        </div>
                        
                         <div class="input-field col s12 m3">
                            <input placeholder="Placeholder" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Discount" type="text" class="validate">
          
                         </div>
                         <div class="input-field col s12 m3">
                            <input placeholder="Final Amount" type="text" class="validate">
          
                         </div> -->
                         </div>
                          <div class="fee-selction col s12 m12">
                          <div class="input-field col s12 m3 col-fee">
                           <label class="label-fee">Total</label>
                        </div>

                        
                         <div class="input-field col s12 m3">
                            <form:input path="totalAmt"  placeholder="Placeholder" type="text" class="validate"/>
          
                         </div>
                         <div class="input-field col s12 m3">
                            <form:input path="totalDiscAmt" placeholder="Discount" type="text" class="validate"/>
          
                         </div>
                         <div class="input-field col s12 m3">
                            <form:input path="totalPaidAmt" placeholder="Final Amount" type="text" class="validate"/>
          
                         </div>
                         </div>
                           <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                          			 <i class="mdi-content-send right"></i>
                          		 </button>
                          		 <button class="btn waves-effect waves-light  submit" type="submit" name="action">Cancel
                           			<i class="mdi-navigation-close right"></i>
                           		</button>
                          </div>
                     </div>
                  
               </div>
            </div>
            </form:form>
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
        	 setDiscount();
        	 
        	 function setDiscount(){
         		$('.disc').each(function(){
         			this.value = 0;
         			setPaidAmount('m',this);
         			/* var id = this.id;
               	    var index = id.substring(id.indexOf("_")+1,id.length);
               	    var amt = document.getElementById("mfamt_"+index).value
               	    document.getElementById("mfpamt_"+index).value = amt; */
         		});
         	}
         });
         
         var totalAmt = 0;
         var totaldiscAmt = 0;
         function setPaidAmount(type, obj){
        	 var id = obj.id;
        	 var index = id.substring(id.indexOf("_")+1,id.length);
        	 var amt = document.getElementById(type+"famt_"+index).value
        	 var paidAmt = "";
        	 var discVal = obj.value;
        	 if(discVal.indexOf("%")!= -1){
        		 discVal = discVal.substring(0,discVal.indexOf("%"));
        		 discVal = amt*discVal/100;
        		// alert("%::"+paidAmt)
        	 }else{
        		// alert("No %")
        	 }
        	 if(discVal == ''){
        		 discVal = 0;
        		 obj.value = 0;
        	 }
        	 totaldiscAmt = parseFloat(totaldiscAmt) + parseFloat(discVal);
        	 paidAmt = parseFloat(amt) - parseFloat(discVal);
        	// alert("Paid amt::"+paidAmt)
        	 document.getElementById(type+"fpamt_"+index).value = paidAmt;
        	 totalAmt = parseFloat(totalAmt) + parseFloat(paidAmt);
        	 document.getElementById("totalAmt").value = parseFloat(totalAmt) + parseFloat(totaldiscAmt);
        	 document.getElementById("totalDiscAmt").value = totaldiscAmt;
        	 document.getElementById("totalPaidAmt").value = totalAmt;
         }
         
        

        	
      </script>
      <!--materialize js-->
   </body>
</html>