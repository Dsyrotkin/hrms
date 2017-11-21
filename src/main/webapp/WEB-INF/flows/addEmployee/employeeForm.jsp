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
					<div class="form-group">
						<label for="fullName">Full Name</label>
						<form:input class="form-control" id="fullName" path="fullName" />
						<form:errors path="fullName" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="userId">Employee ID</label>
						<form:input class="form-control" id="employeeId" path="employeeId" />
						<form:errors path="employeeId" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="dateOfBirth">Date Of Birth</label>
						<fmt:formatDate pattern="MM-dd-yyyy" value="${project.endDate}" var="dob" />			
						<form:input class="form-control" id="dateOfBirth" path="dateOfBirth" value="${dob}"/>	
						<form:errors path="dateOfBirth" class="text-danger"></form:errors>				
					</div>
					<div class="form-group">
						<label for="phone">Phone</label>
						<form:input class="form-control" id="phone" path="phone" />
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<form:input class="form-control" id="email" path="email" />
					</div>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					<div class="form-group text-right">
						<button id="btnNext" class="btn btn-primary" name="_eventId_photo">Next</button>
						<button id="btnCancel" class="btn btn-danger" name="_eventId_cancel">Cancel</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
<script type="text/javascript">
$("#dateOfBirth").datepicker({dateFormat: 'mm-dd-yy'});
</script>