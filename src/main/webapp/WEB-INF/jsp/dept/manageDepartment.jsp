<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
<<<<<<< HEAD
<<<<<<< HEAD
	<div class="col-xs-1 col-md-1"></div>
	<div class="col-xs-10 col-md-10">
=======
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
>>>>>>> master
=======

>>>>>>> eeb702b73f93cfb245ce1adef14fbf9a1a3681f6
		<div class="panel panel-default">
			<div class="panel-heading">
				<spring:message code="Dept.Manage" />
			</div>
			<div class="panel-body">

				<script type="text/javascript"
					src="<spring:url value="/resource/js/deptajax.js"/>"></script>

				<script type="text/javascript"
					src="https://code.jquery.com/jquery-1.12.4.js"></script>
				<script type="text/javascript"
					src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


				<!-- Success - or Validation errors -->
				<div id="result" style="display: none">
					<p id="success"></p>
					<p id="errors"></p>
				</div>

				<form:form modelAttribute="dept" method="post" id="deptForm">

					<div class="form-group">
						<label for="username"><spring:message code="Dept.NAME" /></label>
						<form:input cssClass="form-control" id="deptName" name="deptName"
							path="name" />
					</div>

					<br />
					<br />
					<br />

					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="Dept.ID" /></th>
								<th><spring:message code="Dept.NAME" /></th>
								<th><spring:message code="Dept.DESC" /></th>
								<th># <spring:message code="Dept.PROJECTS" /></th>
								<th># <spring:message code="Dept.EMPS" /></th>
								<th colspan="2"><spring:message code="Gen.ACTIONS" /></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty depts}">
								<tr>
									<td colspan="8"><spring:message code="Gen.NO_RECORDS" /></td>
								</tr>
							</c:if>
							<c:if test="${not empty depts}">

								<c:forEach items="${depts}" var="deptBean">
									<tr id='${deptBean.id}'>
										<td>${deptBean.id}</td>
										<td>${deptBean.name}</td>
										<td>${deptBean.description}</td>
										<td>${deptBean.projects.size()}</td>
										<td>${deptBean.employees.size()}</td>
										<td>
						
										
									<ul class="nav navbar-nav">	
										<li><a href=<spring:url value="/viewDept?id=${deptBean.id}"/> title=<spring:message code="Gen.VIEW" /> ><span class="glyphicon glyphicon-eye-open"></span></a></li>
										<li><a href=<spring:url value="/updateDept?id=${deptBean.id}"/> title=<spring:message code="Gen.UPDATE" /> > <span class="glyphicon glyphicon-pencil"></span></a></li>
										<li><a onclick="confirmDelete(${deptBean.id})" title=<spring:message code="Gen.DELETE" /> > <span class="glyphicon glyphicon-remove"></span></a></li>
										</ul>
										</td>
									
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>



					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="<spring:message code="Gen.SEARCH" />"
							onClick="changeAction('searchDept')" /> <input type="submit"
							class="btn btn-success" value="<spring:message code="Gen.ADD" />"
							onClick="changeAction('addNewDept')" />


					</div>


					<div id="dialog-confirm" style = "display: none;" title="Do you want to department ">
						<p>
							<span class="ui-icon ui-icon-alert"
								style="float: left; margin: 12px 12px 20px 0;"></span>These item
							will be permanently deleted and cannot be recovered. Are you
							sure ?
						</p>
					</div>

				</form:form>
			</div>
		</div>
	</div>
<<<<<<< HEAD
<<<<<<< HEAD
	<div class="col-xs-1  col-md-1"></div>
=======
	<div class="col-xs-2  col-md-2"></div>
>>>>>>> master
=======
>>>>>>> eeb702b73f93cfb245ce1adef14fbf9a1a3681f6
</div>
