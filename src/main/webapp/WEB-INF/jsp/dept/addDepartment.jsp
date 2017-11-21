<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="Dept.Manage" /></div>
			<div class="panel-body">

				<form:form modelAttribute="newDept" method="post" action="saveNewDept"  id="deptForm">
				<form:errors path="*" cssClass="text-danger"/>

					<div class="form-group">
						<label for="name"><spring:message code="Dept.NAME" /></label>
						<form:input cssClass="form-control" id="deptName" name="name" path="name" />
						<form:errors path="name" cssClass="text-danger"/>
					</div>
					
					<div class="form-group">
						<label for="description"><spring:message code="Dept.DESC" /></label>
						<form:input cssClass="form-control" id="description" name="description" path="description" />
						<form:errors path="description" cssClass="text-danger"/>
					</div>					

					<br />
					<br />
					<br />


					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="Save" /> 
						<input type="submit" class="btn btn-danger" value="Cancel" onclick="changeAction('manageDept')" /> 
						

					</div>

				</form:form>
				
					<script type="text/javascript">
					
						function changeAction(actionName) {
							document.getElementById("deptForm").action = actionName;
							document.getElementById("deptForm").method = 'GET'
						}
				
					</script>
					
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
