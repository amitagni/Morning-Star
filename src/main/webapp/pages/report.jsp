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
      <title>Admission</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
   	  <body class="dashboard-body">
       <table width="80%">
  <tr>
	<th>S.No</th>
	<th>Name</th>
	<th>Father's Name</th>
	<th>Class</th>
	<th>Amount</th>
	<th>Discount</th>
	<th>Monthly</th>
	<th>Exam Fee</th>
	<th>Half Yearly</th>
	<th>Anual Fee</th>
	
  </tr>
  <c:forEach items="${reportBean.studentDtoList}" var="report" varStatus="status">
	  <tr>
		<td></td>
		<td>${report.studentName}</td>
		<td>${report.studentFatherName}</td>
		<td>${report.studentName}</td>
		<td>${report.paidAmount}</td>
		<td>${report.discAmount}</td>
		<td>${report.monthlyPaid}</td>
		<td>${report.quterlyPaid}</td>
		<td>${report.halfyearlyPaid}</td>
		<td>${report.anuallyPaid}</td>
	  </tr>
	</c:forEach>
  </table>
   </body>
</html>