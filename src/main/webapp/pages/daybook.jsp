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
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="css/materialize.min.css"> -->
      
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <form:form  modelAttribute="dayBookBean"  action="daybook.do" method="post" class="formValidate" novalidate="novalidate">
      <form:hidden  path="transactionType"/>
      <form:hidden path="paymentType"/>
      <div class="container_b">
         <div class="valign-wrapper row ">
            <div class="col s12 valign">
               <div class="card-panel search-c">
                  <!-- <h4 class="header2">Search</h4> -->
                  <div class="row">
                    
                     <form:hidden path="userAction"/>
                        <div class="col s12 m6">
                           <div class="row">
                              <div class="col s6 m2">
                                 <br>
                                 <h6>Account</h6>
                              </div>
                              <div class="col s6 m6 input-field" style="margin-left: 42px;">
                                 <i class="material-icons prefix" style="top: 11px;"> search</i>
                                    <input type="text" id="autocomplete-input" class="autocomplete">
          
                        
                                   <!-- <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span> -->
                                <%-- <form:select class="error browser-default" path="accountBean.id" id="lastClass" >
                                		<form:options items="${dayBookBean.accountList}" itemValue="id"  itemLabel="accountName"  />
                          		</form:select> --%>
                                
                                 <label for="autocomplete-input" class="">Search Account</label>
                              </div>
                              <div class="col s6 m3">
                                 <br>
                                 <a class="modal-trigger" href="#modal1" style="margin-top: 6px;"><i class="material-icons left" style="
                                    font-size: 35px;
                                    margin-left: -22px;" 
                                    onclick="setAction('1')";>add_circle_outline</i></a>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Transaction Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group1" type="radio" id="test12" onclick="setTrType('1')" />
                                 <label for="test12">Credit  </label>
                                 <input name="group1" type="radio" id="test13" onclick="setTrType('2')" checked/>
                                 <label for="test13">Debit</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Payment Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group1" type="radio" id="test1" value="1" onchange="checkbox(this)" onclick="setPyType('1')" checked/>
                                 <label for="test1">Cash </label>
                                 <input name="group1" type="radio" id="test2" value="2" onchange="checkbox(this)" onclick="setPyType('2')" />
                                 <label for="test2">Epay</label>
                                 <input name="group1" type="radio" id="test3" value="3" onchange="checkbox(this)" onclick="setPyType('3')" />
                                 <label for="test3">Cheque number</label>
                              </div>
                           </div>
                           <div class="row Epay">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Epay</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                  <form:input placeholder="Placeholder" path="chequeEpayNo" type="text" class="validate" required="required" />
                                 <label for="chequeEpayNo">Epay No</label>
                              </div>
                           </div>
                           <div class="row Cheque">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Cheque number</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:input placeholder="Placeholder" path="chequeEpayNo" type="text" class="validate" required="required"/>
                                 <label for="chequeEpayNo">Cheque number</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Amount</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:input placeholder="Placeholder" id="Amount" path="amount" type="number" class="validate" required="required"/>
                                 <label for="Amount">Amount</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Comments</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:textarea id="textarea1" path="comments" class="materialize-textarea"></form:textarea>
                                 <label for="textarea1">Comments</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="input-field col s12 center-align ">
                                 <button class="btn waves-effect waves-light  submit center-btn" type="button" name="action" onclick="submitForm('dayBookBean')">Submit
                                 <i class="mdi-content-send right"></i>
                                 </button>
                                 <button class="btn waves-effect waves-light  submit" type="button" name="action">Reset
                                 <i class="mdi-navigation-close right"></i>
                                 </button>
                              </div>
                           </div>
                        </div>
                        <div class="col s6 m6">
                           <table class="bordered" >
                              <thead>
                                 <tr>
                                    <th>S.No</th>
                                    <th>Account</th>
                                    <th>Transaction Type</th>
                                    <th>Amount</th>
                                     <th>Comments</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 
                              <c:forEach items="${dayBookBean.dayBookDTOList}" var="dayBookDTO" varStatus="status">   
                                 <tr>
                                    <td>(${status.index +1})</td>
                                    <td>${dayBookDTO.accountName }</td>
                                    <td>${dayBookDTO.transactionType }</td>
                                    <td>${dayBookDTO.amount }</td>
                                    <td>${dayBookDTO.comment }</td>
                                    <td><a href="javascript:deleteEntry(${dayBookDTO.id})"><i class="material-icons left">cancel</i></a></td>
                                 </tr>
                              </c:forEach>  
                                 
                                 <!-- <tr>
                                    <td>Alan</td>
                                    <td>Jellybean</td>
                                    <td>$3.76</td>
                                    <td>$0.87</td>
                                    <td><a href="#"><i class="material-icons left">cancel</i></a></td>
                                 </tr>
                                 <tr>
                                    <td>Jonathan</td>
                                    <td>Lollipop</td>
                                    <td>Lollipop</td>
                                    <td>$0.87</td>
                                    <td><a href="#"><i class="material-icons left">cancel</i></a></td>
                                 </tr> -->
                              </tbody>
                           </table>
                        </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      <div id="modal1" class="modal">
         <div class="modal-content">
            <h4>Account Creation(A/C)</h4>
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Account Name</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.name"  type="text" class="validate" placeholder="Name" required="required"/>
                  <label for="Amount">Account Name</label>
               </div>
            </div>
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Desc</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.description"  type="text" class="validate" placeholder="Description" required="required"/>
                  <label for="Amount">Desc</label>
               </div>
            </div>
            <div class="input-field col s12 center-align ">
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="submitForm('dayBookBean')">Submit
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light  submit" type="button" onclick="$('#modal1').modal('close');setAction('2')">Exit
               <i class="mdi-navigation-close right"></i>
               </button>
            </div>
         </div>
      </div>
      </form:form>
      
       <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
  <script type="text/javascript" src="js/autocomplate.js"></script>
  <script src="js/jquery.validate.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" ></script>

      <script type="text/javascript">
      
      
      $.validator.setDefaults({
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
  	     form.submit();
  	    }
  	});
         $(document).ready(function(){
        	 
        	 $(document).ready(function() {
        		 
        		 /* var fakedata = ['test1','test2','test3','test4','arpit'];
        		 $("input.autocomplete").autocomplete({source:fakedata}); */
        		 
        		 
        		 
        		 $('input.autocomplete').autocomplete({
        			    data: {
        			      "Apple": null,
        			      "Microsoft": null,
        			      "Google": 'https://placehold.it/250x250'
        			    },
        			    limit: 20, // The max amount of results that can be shown at once. Default: Infinity.
        			    onAutocomplete: function(val) {
        			      // Callback function when value is autcompleted.
        			    },
        			    minLength: 1, // The minimum length of the input for the autocomplete to start. Default: 1.
        			  });

                 $('select').material_select(); 
                
                 
                 $('.modal').modal({
                     dismissible: true, // Modal can be dismissed by clicking outside of the modal
                    opacity: .5,
                    }); 
                    
               
               });
                
         
          
         $('.Epay').hide();
         $('.Cheque').hide();
         $(document).ready(function() {
        	 
         var t = $('#example').DataTable( {
           "columnDefs": [ {
               "searchable": false,
               "orderable": false,
               "targets": 0
           } ],
           "order": [[ 1, 'asc' ]]
         } );
         
         t.on( 'order.dt search.dt', function () {
           t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
               cell.innerHTML = i+1;
           } );
         } ).draw();
         } );
         
         });
          function checkbox(id){
             var test1= id.value;
         var test2= id.value;
         var test3=  id.value;
         
         if(test1==1){
         $('.Epay').hide();
         $('.Cheque').hide();
         }
         else if(test2==2){
         $('.Epay').show();
         $('.Cheque').hide();
         }
         
         else if(test3==3){
         $('.Cheque').show();
         $('.Epay').hide();
         }
          }
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });
            
             
            function setAction(action){
            	//alert(action);
            	 document.getElementById("userAction").value = action;
            }
            
           /*  function submitForm(formId){
          		 $("#"+formId).submit();
          	} */
            
       		function deleteEntry(id){
       		 var cnf =confirm("Do you really want to delete this entry?.");
	       		 if(cnf == true){
	       			 $.ajax({
	 	                type: "get",
	 	          		url: "delete-dBookEntry.do",
	 	          		cache: false,
	 	          		data: {"daybookId":id},
	 	                dataType: "json",
	 	                success: function(data) {
	 	                	location.reload();
	 	                }
	 	            }); 
	       		 }
       		}
       		function setPyType(pyType){
       			 document.getElementById("paymentType").value = pyType;
       		}
			function setTrType(trType){
				 document.getElementById("transactionType").value = trType;
       		}
			
        
           
      </script>
   </body>
</html>