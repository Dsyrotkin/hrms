<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Department</div>
			<div class="panel-body">

				<form:form method="post">

					<div class="form-group">
						<label for="username"><spring:message code="Dept.NAME" /></label>
						<form:input cssClass="form-control" id="username" name="username"
							path="" />
					</div>


					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="Submit" />
					</div>
				</</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
