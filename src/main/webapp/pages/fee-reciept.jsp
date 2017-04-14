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
      <title>Fee Receipt </title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
       <link rel="stylesheet" type="text/css" media="print" href="css/print.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.min.css">
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
  	  <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
               <li ><a href="javascript:void();">Enrollment</a>
               </li>
               <li ><a href="javascript:void();">Fee Details</a>
               </li>
               <li ><a href="javascript:void();">Payment</a>
               </li>
               <li class="active_list"><a href="javascript:void();">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
     <div class="row_form valign-wrapper">
         <div class="col s12 m12 recipt-width">
            <div class="card-panel card-main">
        
          <div class="col s12 m12 text-center logo-recipt">
            <img src="img/login.png" alt="" class="responsive-img valign profile-image-login size-logo center ">
          </div>
      
            <h3 class="text-center">Fee Receipt</h3>
            <br>
               <h5>Congratulations, Admission process has been
Successfully Completed. !!!</h5>
<h6 class="h6-p">your Morning Star ID (MSID) is 123456</h6>
<br>
<div class="row">
                  <form:form class="formValidate" id="formValidate"  modelAttribute="feeFormBean"  action="fee.do"  novalidate="novalidate">
                  
                     <div class="row">

                        <!-- <div class="col s12 m12">
                           <h5> Monthly Fee</h5>
                        </div> -->
                        <div class="fee-selction col s12 m12">
                          <c:forEach items="${feeFormBean.monthlyFeeList}" var="feeDto" varStatus="status">
	                        <div class="col s3 m3 col-fee">
	                           <label class="label-fee">${feeDto.name}</label>
	                        </div>
	
	                         <div class="input-field col s3 m3">
	                            <p>${feeDto.amount}</p>
	          
	                         </div>
	                         <div class="input-field col s3 m3">
	                             <p>${feeDto.discount}</p>
	                         </div>
	                         <div class="input-field col s3 m3">
	                           <p>${feeDto.paidAmount}</p>
	                         </div>
                         </c:forEach>
                         
	                         <!-- <div class="col s12 m3 col-fee">
	                           <label class="label-fee">M.F</label>
	                        </div>
	                        
	                         <div class="input-field col s12 m3">
	                            <p>1234</p>
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <p>1234</p>
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                           <p>1234</p>
	          
	                         </div>
	                         <div class="col s12 m3 col-fee">
	                           <label class="label-fee">Tution Fee</label>
	                        </div>
	                        
	                         <div class="input-field col s12 m3">
	                           <p>1234</p>
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                            <p>1234</p>
	          
	                         </div>
	                         <div class="input-field col s12 m3">
	                           <p>1234</p>
	                         </div> -->
	                         
                         </div>
                         <!-- <div class="col s12 m12">
                           <h5>Quarterly Fee</h5>
                        </div> -->
                        <c:if test="${feeFormBean.quarterlyFeeList.size() > 0  }">
                        <div class="fee-selction col s12 m12">
                        	<div class="col s3 m3 col-fee">
	                           <label class="label-fee">Exam Fee</label>
	                        </div>
	                      <c:out value="${feeFormBean.quarterlyFeeList.size() > 0  }"></c:out>
	                     
	                         <c:forEach items="${feeFormBean.quarterlyFeeList}" var="feeDto" varStatus="status">
	                        
		                        
		                        <div class="input-field col s2 m2">
		                            <p class="text-center">${feeDto.name}</p>
		                           
		                         </div>
		                         <div class="input-field col s2 m2">
		                            <p>${feeDto.amount}</p>
		          
		                         </div>
		                         <div class="input-field col s2 m2">
		                           <p>${feeDto.discount}</p>
		          
		                         </div>
		                         <div class="input-field col s2 m2">
		                            <p>${feeDto.paidAmount}</p>
		                         </div>
		                          <div class="col s3 m3 col-fee">
	                        	   &nbsp;
	                       		 </div>
		                    </c:forEach>     
	                    
                        
                       <!--  <div class="input-field col s12 m2">
                            <p class="text-center">AUG</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="col s12 m3 col-fee">
                          &nbsp;
                        </div>
                        <div class="input-field col s12 m2">
                            <p class="text-center">SEP</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="col s12 m3 col-fee">
                          &nbsp;
                        </div>
                         <div class="input-field col s12 m2">
                            <p class="text-center">OCT</p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2"><p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div> -->
                         <!-- <div class="col s12 m12">
                           <h5>Half yeraly Fee</h5>
                        </div> -->
                        </div>
                         </c:if>  
                        <c:if test="${feeFormBean.halfyearlyFeeList.size() > 0  }">
                        	<div class="fee-selction col s12 m12">
	                        <div class="col s3 m3 col-fee">
	                           <label class="label-fee">Annual Function Fee</label>
	                        </div>
                        
	                         <c:forEach items="${feeFormBean.halfyearlyFeeList}" var="feeDto" varStatus="status">
	                        
		                        
		                        <div class="input-field col s2 m2">
		                            <p class="text-center">${feeDto.name}</p>
		                           
		                         </div>
		                         <div class="input-field col s2 m2">
		                            <p>${feeDto.amount}</p>
		          
		                         </div>
		                         <div class="input-field col s2 m2">
		                           <p>${feeDto.discount}</p>
		          
		                         </div>
		                         <div class="input-field col s2 m2">
		                            <p>${feeDto.paidAmount}</p>
		                         </div>
		                          <div class="col s3 m3 col-fee">
	                        	   &nbsp;
	                       		 </div>
		                    </c:forEach> 
		                   </div>
                       </c:if>
                        
                     <!--      <div class="input-field col s12 m2">
                            <p class="red-done"><i class="material-icons font-size-icon">info_outline</i><span>DEC </span></p>
                           
                         </div>

                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                          <div class="col m3"> &nbsp;</div>
                          <div class="input-field col s12 m2">
                             <p class="green-done"><i class="material-icons font-size-icon">done</i><span>FEB </span></p>
                           
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div>
                         <div class="input-field col s12 m2">
                            <p>1234</p>
          
                         </div> -->
                         
                         <!-- <div class="col s12 m12">
                           <h5>Yearly Fee</h5>
                        </div> -->
                        <c:if test="${feeFormBean.anualFeeList.size() > 0  }">
                       		 <div class="fee-selction col s12 m12">
                       
                       
                       
	                        <c:forEach items="${feeFormBean.anualFeeList}" var="feeDto" varStatus="status">
	                       
		                        <div class="col s3 m3 col-fee">
		                           <label class="label-fee">${feeDto.name}</label>
		                        </div>
		                        
		                         <div class="input-field col s3 m3">
		                            <p>${feeDto.amount}</p>
		          
		                         </div>
		                         <div class="input-field col s3 m3">
		                            <p>${feeDto.discount}</p>
		          
		                         </div>
		                         <div class="input-field col s3 m3">
		                           <p>${feeDto.paidAmount}</p>
		          
		                         </div>
	                        </c:forEach> 
		                       <!--   
		                        <div class="col s12 m3 col-fee">
		                           <label class="label-fee">Practical Fee</label>
		                        </div>
		                        
		                         <div class="input-field col s12 m3">
		                            <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                            <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                            <p>1234</p>
		          
		                         </div>
		                         <div class="col s12 m3 col-fee">
		                           <label class="label-fee">T.C Fee</label>
		                        </div>
		                        
		                         <div class="input-field col s12 m3">
		                           <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                           <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                           <p>1234</p>
		          
		                         </div>
		                         <div class="col s12 m3 col-fee">
		                           <label class="label-fee">Miscellaneous</label>
		                        </div>
		                        
		                         <div class="input-field col s12 m3">
		                            <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                            <p>1234</p>
		          
		                         </div>
		                         <div class="input-field col s12 m3">
		                           <p>1234</p>
		          
		                         </div> -->
                        	 </div>
                         </c:if>
                         
                          <div class="fee-selction col s12 m12">
                          <div class="col s3 m3 col-fee">
                           <label class="label-fee">Total</label>
                        </div>

                        
                         <div class="input-field col s3 m3">
                            <p>${feeFormBean.totalAmt}</p>
          
                         </div>
                         <div class="input-field col s3 m3">
                          <p>${feeFormBean.totalDiscAmt}</p>
          
                         </div>
                         <div class="input-field col s3 m3">
                            <p>${feeFormBean.totalPaidAmt}</p>
          
                         </div>
                         </div>
                          
                        
                        </div>
                    
                 	 </form:form>
                   </div>
                  <div class="col s12 m12 text-center"> <a onclick="printme()" class="btn waves-effect waves-light center">Print</a></div>
                  
               </div>
           
          </div>
         </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
      
      <script type="text/javascript">

      function printme() {
          window.print();
      }
        
      </script>
      <!--materialize js-->
   </body>
</html>