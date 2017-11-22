<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="context" value="/"/>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="Project.new_project"/></div>
			<div class="panel-body">
				<c:url var="ProjectUrl" value="/project" />
				<form:form modelAttribute="project" method="post" action="${context}project/save">
					<c:if test="${not empty project.id}">
						<form:input type="hidden" class="form-control" id="id" path="id" />
					</c:if>
					
					<div class="form-group">
						<label for="name"><spring:message code="Project.name"/></label> 
						<form:input class="form-control" id="name" path="name" />
						<form:errors path="name" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="description"><spring:message code="Project.description"/></label> 
						<form:input class="form-control" id="description" path="description" />
						<form:errors path="description" class="text-danger"></form:errors>
					</div>
					
					<div class="form-group">
						<label for="code"><spring:message code="Project.code"/></label> 
						<form:input class="form-control" id="code" path="code" />
						<form:errors path="code" class="text-danger"></form:errors>
					</div>
					
					<div class="form-group">
						<label for="startDate"><spring:message code="Project.startdate"/></label>
						<fmt:formatDate pattern="MM-dd-yyyy" value="${project.startDate}" var="sdate"/>						
						<form:input class="form-control" id="startDate" path="startDate" value="${sdate}"/>							
						<form:errors path="startDate" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="endDate"><spring:message code="Project.enddate"/></label>
						<fmt:formatDate pattern="MM-dd-yyyy" value="${project.endDate}" var="edate"/>
						<form:input class="form-control" id="endDate" path="endDate" value="${edate}"/>
						<form:errors path="endDate" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="department"><spring:message code="Project.department"/></label> 
						<form:select class="form-control" path="department.id" items="${departments}" itemValue="id" itemLabel="name"/>
						<%-- <form:input class="form-control" id="department" path="department.id" /> --%>						
						<form:errors path="department.id" class="text-danger"></form:errors>
					</div>
					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="<spring:message code="Project.submit"/>" />
					</div>
					<%-- <form:errors path="*" class="alert alert-danger" /> --%>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
<script type="text/javascript">
$( "#startDate" ).datepicker({dateFormat: 'mm-dd-yy'});
$( "#endDate" ).datepicker({dateFormat: 'mm-dd-yy'});
</script>