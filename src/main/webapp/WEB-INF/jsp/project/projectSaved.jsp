<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
		<div class="alert alert-success"><spring:message code="Project.project_saved_successfully"/></div>
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="Project.project_details"/></div>
			<div class="panel-body">
				<dl class="dl-horizontal">
				  <dt><spring:message code="Project.name"/></dt>
				  <dd>${project.name}</dd>
				  <dt><spring:message code="Project.description"/></dt>
				  <dd>${project.description}</dd>
				  <dt><spring:message code="Project.code"/></dt>
				  <dd>${project.code}</dd>
				  <dt><spring:message code="Project.startdate"/></dt>
				  <dd><fmt:formatDate pattern="MM-dd-yyyy" value="${project.startDate}" /></dd>
				  <dt><spring:message code="Project.enddate"/></dt>
				  <dd><fmt:formatDate pattern="MM-dd-yyyy" value="${project.endDate}" /></dd>
				  <dt><spring:message code="Project.department"/></dt>
				  <dd>${project.department.name}</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="col-xs-2  col-md-2"></div>
</div>
