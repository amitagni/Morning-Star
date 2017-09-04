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
      <title>Abacusreg Form</title>
     
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
 <link rel="stylesheet" href="css/materialize.min.css">
  <link rel="shortcut icon" type="image/png" href="images/login.png"/>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/print.css">
   <body class="dashboard-body">
     
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         
      </div>
      </div>
       <div class="row_form valign-wrapper">
       
          <div class="col s12 m12 recipt-width">
            <div class="card-panel card-main">
           <div><!-- <p id="bg-text">adsad</p> -->
           <div class="row">
                <div class="col s3 m3">
            <img src="img/login.png" alt="" class="responsive-img valign profile-image-login size-logo center ">
            
          </div>
          <div class="col m9 s9 tex-morning">
         	 <h4 class="tex-font">MORNING STAR CHILDREN'S SR. SEC. ACADEMY</h4>
          </div>
          </div>
          <div class="row box-print">
          <div class="col m6 s6 ">
          <p>Admission No. <span>515151</span></p>
          <p>Name :<span>abcsda</span></p>
          <p>Father's Name :<span>abcsda</span></p>
          <p>Class :<span>VI</span></p>
          </div>
       
          <div class="col m6 s6 ">
          <p class="right-align">Data:<span>12/31/2016</span></p>
          <p class="right-align" >Section :<span>A</span></p>
          </div>
          </div>
          <div class="col m12 s12">
           <table>
        <thead>
          <tr>
              <th>Particulars</th>
              <th>Amounts</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Tuition Fee</td>
            <td>1200.00</td>
            
          </tr>
          <tr>
            <td>Maintenance Fee</td>
            
            <td>1000</td>
          </tr>
          <tr>
            <td>Digi. class/Sci/Prac/Comp.</td>
           
            <td>15515</td>
          </tr>
          <tr>
            <td>total</td>
           
            <td>125</td>
          </tr>
          <tr>
            <td>V>F</td>
           
            <td>1515</td>
            
          </tr>
            <tr>
            <td>Late Fee Rs 40/ per Month  Late Fee</td>
           
            <td>40</td>
            
          </tr>
          <tr class="grand-t">
           
            <td>Grand Total</td>
           
            <td>4000</td>
            
          
          </tr>
    
        </tbody>
      </table>
      <br>
      
      <div class="row">
      <div class="col m6 s6">
          <h6>Checker</h6>
        
          </div>
          <div class="col m6 s6">
          <h6 class="right-align">Cashier</h6>
        
          </div>
           <div class="col s12 m12 text-center"> <a onclick="printme()" class="btn waves-effect waves-light center">Print</a></div>
      </div>
      
          </div>
         </div>
          <div id="one-r">
        <div style="border-bottom: 1px dashed;    margin: 10px 0px 20px;"></div>
        <div class="col m9 s9 tex-morning">
         	 <h4 class="tex-font text-center">MORNING STAR CHILDREN'S SR. SEC. ACADEMY</h4>
          </div>
        
          <div class="row box-print">
          <div class="col m6 s6 ">
          <p>Admission No. <span>515151</span></p>
          <p>Name :<span>abcsda</span></p>
          <p>Father's Name :<span>abcsda</span></p>
          <p>Class :<span>VI</span></p>
          </div>
       
          <div class="col m6 s6 ">
          <p class="right-align">Data:<span>12/31/2016</span></p>
          <p class="right-align" >Section :<span>A</span></p>
          </div>
          </div>
          <div class="col m12 s12">
           <table>
        <thead>
          <tr>
              <th>Particulars</th>
              <th>Amounts</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Tuition Fee</td>
            <td>1200.00</td>
            
          </tr>
          <tr>
            <td>Maintenance Fee</td>
            
            <td>1000</td>
          </tr>
          <tr>
            <td>Digi. class/Sci/Prac/Comp.</td>
           
            <td>15515</td>
          </tr>
          <tr>
            <td>total</td>
           
            <td>125</td>
          </tr>
          <tr>
            <td>V>F</td>
           
            <td>1515</td>
            
          </tr>
            <tr>
            <td>Late Fee Rs 40/ per Month  Late Fee</td>
           
            <td>40</td>
            
          </tr>
          <tr class="grand-t">
           
            <td>Grand Total</td>
           
            <td>4000</td>
            
          
          </tr>
    
        </tbody>
      </table>
      <br>
      
      <div class="row">
      <div class="col m6 s6">
          <h6>Checker</h6>
        
          </div>
          <div class="col m6 s6">
          <h6 class="right-align">Cashier</h6>
        
          </div>
           
      </div>
      
          </div>
           </div>
          </div>
          </div>
         </div>
        
     
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script src="js/jquery.validate.min.js"></script>
       <script type="text/javascript">

      function printme() { window.print();
        
      }
        
      </script>
      
   </body>
</html>