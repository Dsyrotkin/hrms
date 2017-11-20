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
			<div class="panel-heading"><spring:message code="addRole.form.title" /></div>
			<div class="panel-body">
				<c:url var="addUrl" value="/admin/role/addRole" />
				<form:form modelAttribute="role" method="post" action="${addUrl}">
					<div class="form-group">
						<label for="name"><spring:message code="addRole.form.name" /></label> 
						<form:input class="form-control" id="name" path="name" />
						<form:errors path="name"></form:errors>
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