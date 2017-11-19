<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
		<div class="alert alert-success">Project Saved Successfully</div>
		<div class="panel panel-default">
			<div class="panel-heading">Project Details</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
				  <dt>Name</dt>
				  <dd>${project.name}</dd>
				  <dt>Description</dt>
				  <dd>${project.description}</dd>
				  <dt>Start Date</dt>
				  <dd><fmt:formatDate pattern="MM-dd-yyyy" value="${project.startDate}" /></dd>
				  <dt>End Date</dt>
				  <dd><fmt:formatDate pattern="MM-dd-yyyy" value="${project.endDate}" /></dd>
				  <dt>Department</dt>
				  <dd>${project.department.name}</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="col-xs-2  col-md-2"></div>
</div>
