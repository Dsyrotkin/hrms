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
				<form:form modelAttribute="address">
					<div class="form-group">
						<label for="state">State</label>
						<form:input class="form-control" id="state" path="state" />
						<form:errors path="state" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="city">City</label>
						<form:input class="form-control" id="city" path="city" />
						<form:errors path="city" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="street">Street</label>
						<form:input class="form-control" id="street" path="street" />
						<form:errors path="street" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="zip">ZIP</label>
						<form:input class="form-control" id="zip" path="zip" />
						<form:errors path="zip" class="text-danger"></form:errors>
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