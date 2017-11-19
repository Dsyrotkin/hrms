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
			<div class="panel-heading">New Project</div>
			<div class="panel-body">
				<c:url var="ProjectUrl" value="/project" />
				<form:form modelAttribute="project" method="post" action="${context}project/save">
					<c:if test="${not empty project.id}">
						<form:input type="hidden" class="form-control" id="id" path="id" />
					</c:if>
					<div class="form-group">
						<label for="name">Name</label> 
						<form:input class="form-control" id="name" path="name" />
						<form:errors path="name"></form:errors>
					</div>
					<div class="form-group">
						<label for="description">Description</label> 
						<form:input class="form-control" id="description" path="description" />
						<form:errors path="description"></form:errors>
					</div>
					<div class="form-group">
						<label for="startDate">Start Date</label>
						<fmt:formatDate pattern="MM-dd-yyyy" value="${project.startDate}" var="sdate"/>						
						<form:input class="form-control" id="startDate" path="startDate" value="${sdate}"/>							
						<form:errors path="startDate"></form:errors>
					</div>
					<div class="form-group">
						<label for="endDate">End Date</label>
						<fmt:formatDate pattern="MM-dd-yyyy" value="${project.endDate}" var="edate"/>
						<form:input class="form-control" id="endDate" path="endDate" value="${edate}"/>
						<form:errors path="endDate"></form:errors>
					</div>
					<div class="form-group">
						<label for="department">Department</label> 
						<form:select path="department.id" items="${departments}" itemValue="id" itemLabel="name"/>
						<%-- <form:input class="form-control" id="department" path="department.id" /> --%>						
						<form:errors path="department.id"></form:errors>
					</div>
					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="Submit" />
					</div>
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