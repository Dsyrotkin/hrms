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
			<div class="panel-heading">Employee Information</div>
			<div class="panel-body">
				<c:url var="EmployeeUrl" value="/employee" />
				<form:form modelAttribute="employee" method="post">
					<fieldset>
						<legend>General information</legend>
						<div class="pull-right" style="margin-right: 20px;">
							<a href="getPhoto/${employee.photo.id}">
								<img src="getPhoto/${employee.photo.id}" alt="photo" style="max-width: 100px; max-height: 100px;"/>
							</a>
						</div>
						<div><p><label>Full Name:</label> ${employee.fullName}</p>
						<p><label>Employee ID:</label> ${employee.employeeId}</p>
						<p><label>Date of birth:</label> <fmt:formatDate pattern="MMM dd, yyyy" value="${employee.dateOfBirth}" /></p>
						</div>
					</fieldset>
					<fieldset>
						<legend>Contacts</legend>
						<p><label>Phone:</label> ${employee.phone}</p>
						<p><label>Email:</label> ${employee.email}</p>
					</fieldset>
					<br>
					<fieldset>
						<legend>Address</legend>
						<p><label>State:</label> ${employee.address.state}</p>
						<p><label>City:</label> ${employee.address.city}</p>
						<p><label>Street:</label> ${employee.address.street}</p>
						<p><label>ZIP:</label> ${employee.address.zip}</p>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
<script type="text/javascript">
$("#dateOfBirth").datepicker({dateFormat: 'mm-dd-yy'});
</script>