<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
<script>
  function deleteConfirm(){
	        var txt;
             var r= confirm("are you sure, you want to delete?");
             if(r==true){
                txt="you pressed OK";
                 }else{
                  txt="you preessed cancel!!";
                  event.preventDefault();
                 }
	  }
</script>
</head>
<body>
   <a href="addContact">Add New Contact</a>
   </br>
	<table border="1" id="contactTbl">
		<thead>
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone number</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${contacts}"
			              var="c"
			              varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td>
					     <a href="editContact?cid=${c.contactId}">Edit</a>| 
					     <a href="deleteContact?cid=${c.contactId}" onclick="deleteConfirm()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>