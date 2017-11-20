<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="context" value="/"/>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Employee Registration</div>
			<div class="panel-body">
				<c:url var="EmployeeUrl" value="/employee" />
				<form:form modelAttribute="employee" method="post">
					<p>Full Name: ${employee.fullName} </p>
					<p>Employee ID: ${employee.employeeId} </p>
					<p>Phone: ${employee.phone} </p>
					<p>Email: ${employee.email} </p>
					<br>
					<p>State: ${employee.address.state} </p>
					<p>Street: ${employee.address.street} </p>
					<p>ZIP: ${employee.address.zip} </p>
					<button id="btnHome" class="btn btn-primary" name="_eventId_home">Main page</button>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
<script type="text/javascript">
$("#dateOfBirth").datepicker({dateFormat: 'mm-dd-yy'});
</script>