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
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
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

.input-field .prefix {
    position: absolute;
    width: 3rem;
    font-size: 2rem;
    -webkit-transition: color .2s;
    -moz-transition: color .2s;
    -o-transition: color .2s;
    -ms-transition: color .2s;
    transition: color .2s;
    line-height: 1.7;
      </style>
 
  </head>
   <body class="dashboard-body">
   	 <%@ include file="../includes/header.jsp"%>

     <div class="container_b serach-top">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
         
	         
      
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                  <form:form  modelAttribute="inventoryCateoryBean"  action="inventoryCategory.do" name="inventoryCateoryBean" method="post"  class="formValidate" novalidate="novalidate">
<h4>Add Inventory -New Item(s)</h4>
                    <div class="row">
                        <div class="col s6 m2">
                        <br>
                          <h6>Account Name</h6>
                        </div>
                        <div class="col s6 m3 input-field" style="margin-left: 72px;">
                          
                          <i class="material-icons prefix"> search</i>
                          <input type="text" id="autocomplete-input" class="autocomplete ui-autocomplete-input" autocomplete="off" required="required"><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                          <label for="autocomplete-input" class="">Search Category</label>
                        
                        
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
                        <br>
                          <h6>Add Items</h6>
                        </div>
                        <div class="input-field col s6 m3">
          <input placeholder="Placeholder" id="Items" type="text" class="validate">
          <label for="Items">Desc</label>
        </div>
                        </div>

          <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Desc</h6>
                        </div>
                        <div class="input-field col s6 m3">
          <input placeholder="Placeholder" id="Amount" type="text" class="validate">
          <label for="Amount">Desc</label>
        </div>
                        </div>

  <div class="input-field col s12 center-align ">
       <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit" type="submit" name="action" onclick="$('#modal1').modal('close');">Clear
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
     
      </div>
<div id="modal1" class="modal">
    <div class="modal-content">
      <h4>Add Category</h4>
       <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Category Name</h6>
                        </div>
                        <div class="input-field col s6 m6">
          <input placeholder="Placeholder" id="Amount" type="text" class="validate">
          <label for="Amount">Category Name</label>
        </div>
                        </div>
          <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Description</h6>
                        </div>
                        <div class="input-field col s12 m6">
          <textarea id="textarea1" class="materialize-textarea"></textarea>
          <label for="textarea1">Description</label>
        </div>
                        </div>
  <div class="input-field col s12 center-align ">
       <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit" type="submit" name="action" onclick="$('#modal1').modal('close');">Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
      

                    
                    
       
                 </form:form>
               </div>
            </div>
         </div>
      
      <script type="text/javascript" src="js/jquery.min.js"></script>
     <!--  <script src="js/materialize.min.js"></script> -->
     <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
     
      <script type="text/javascript" src="js/dropify.min.js"></script>
      <link href="css/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/jquery-ui.js" ></script>
 <script>
 
 $('.modal').modal({
     dismissible: true, // Modal can be dismissed by clicking outside of the modal
    opacity: .5,
  });

 </script>
      <!--materialize js-->
   </body>
</html>