<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Employees List</h1>  

<f:form action="save1" method="post" modelAttribute="emp" >
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   
   
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.designation}</td>  
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>  

</f:form>

</body>
</html>