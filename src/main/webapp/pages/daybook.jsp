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
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link rel="stylesheet" href="css/materialize.min.css">
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
         <div class="valign-wrapper row ">
            <div class="col s12 valign">
               <div class="card-panel search-c">
                  <!-- <h4 class="header2">Search</h4> -->
                  <div class="row">
                     <form:form  modelAttribute="dayBookBean"  action="day-book" method="post" class="formValidate" novalidate="novalidate">
                        <div class="col s12 m6">
                           <div class="row">
                              <div class="col s6 m2">
                                 <br>
                                 <h6>Account</h6>
                              </div>
                              <div class="col s6 m6 input-field" style="margin-left: 42px;">
                                 <i class="material-icons prefix" style="top: 11px;"> search</i>
                                 <input type="text" id="autocomplete-input" class="autocomplete ui-autocomplete-input" autocomplete="off"><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                                 <label for="autocomplete-input" class="">Search Account</label>
                              </div>
                              <div class="col s6 m3">
                                 <br>
                                 <a class="modal-trigger" href="#modal1" style="margin-top: 6px;"><i class="material-icons left" style="
                                    font-size: 35px;
                                    margin-left: -22px;
                                    ">add_circle_outline</i></a>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Transaction Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group1" type="radio" id="test12" />
                                 <label for="test12">Credit  </label>
                                 <input name="group1" type="radio" id="test13" />
                                 <label for="test13">Debit</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Payment Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group1" type="radio" id="test1" value="1" onchange="checkbox(this)" />
                                 <label for="test1">Cash </label>
                                 <input name="group1" type="radio" id="test2" value="2" onchange="checkbox(this)" />
                                 <label for="test2">Epay</label>
                                 <input name="group1" type="radio" id="test3" value="3" onchange="checkbox(this)" />
                                 <label for="test3">Cheque number</label>
                              </div>
                           </div>
                           <div class="row Epay">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Epay</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <input placeholder="Placeholder" id="Amount" type="text" class="validate">
                                 <label for="Amount">Epay No</label>
                              </div>
                           </div>
                           <div class="row Cheque">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Cheque number</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <input placeholder="Placeholder" id="Amount" type="text" class="validate">
                                 <label for="Amount">Cheque number</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Amount</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <input placeholder="Placeholder" id="Amount" type="text" class="validate">
                                 <label for="Amount">Amount</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Comments</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <textarea id="textarea1" class="materialize-textarea"></textarea>
                                 <label for="textarea1">Comments</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="input-field col s12 center-align ">
                                 <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                                 <i class="mdi-content-send right"></i>
                                 </button>
                                 <button class="btn waves-effect waves-light  submit" type="submit" name="action">Reset
                                 <i class="mdi-navigation-close right"></i>
                                 </button>
                              </div>
                           </div>
                        </div>
                        <div class="col s6 m6">
                           <table class="bordered" >
                              <thead>
                                 <tr>
                                    <th>Transaction Type</th>
                                    <th>Account</th>
                                    <th>Payment Type</th>
                                    <th>Comments</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <td>Alvin</td>
                                    <td>Eclair</td>
                                    <td>$0.87</td>
                                    <td>$0.87</td>
                                    <td><a href="#"><i class="material-icons left">cancel</i></a></td>
                                 </tr>
                                 <tr>
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
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </form:form>
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
                  <input placeholder="Placeholder" id="Amount" type="text" class="validate">
                  <label for="Amount">Account Name</label>
               </div>
            </div>
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Desc</h6>
               </div>
               <div class="input-field col s6 m6">
                  <input placeholder="Placeholder" id="Amount" type="text" class="validate">
                  <label for="Amount">Desc</label>
               </div>
            </div>
            <div class="input-field col s12 center-align ">
               <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light  submit" type="submit" name="action" onclick="$('#modal1').modal('close');">Exit
               <i class="mdi-navigation-close right"></i>
               </button>
            </div>
         </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <!--materialize js-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
      <script src="js/jquery.validate.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" ></script>
      <script type="text/javascript">
         $(document).ready(function(){
         // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
         $('.modal').modal({
          dismissible: true, // Modal can be dismissed by clicking outside of the modal
         opacity: .5,
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
            $(document).ready(function() {
                // Basic
                $('.dropify').dropify();
                
                // Translated
            
            });
             $(document).ready(function() {
            $('select').material_select();
            
             var fakedata = ['test1','test2','test3','test4','ietsanders'];
         $("input.autocomplete").autocomplete({source:fakedata});
            });
            
            
           
      </script>
   </body>
</html>