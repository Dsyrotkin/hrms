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
			<div class="panel-heading">Employee Contacts Form</div>
			<div class="panel-body">
				<c:url var="EmployeeUrl" value="/employee" />
				<form:form modelAttribute="employee">
					<div class="form-group">
						<label for="state">State</label>
						<form:input class="form-control" id="state" path="address.state" />
					</div>
					<div class="form-group">
						<label for="street">Street</label>
						<form:input class="form-control" id="street" path="address.street" />
					</div>
					<div class="form-group">
						<label for="zip">ZIP</label>
						<form:input class="form-control" id="zip" path="address.zip" />
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
						<input type="submit" class="btn btn-primary" value="Submit" name="_eventId_save" />
						<button id="btnCancel" class="btn btn-danger" name="_eventId_back">Return</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>