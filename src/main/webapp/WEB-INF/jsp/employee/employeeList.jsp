<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="context" value="/"/>
<div class="row">
	<div class="col-xs-1 col-md-1"></div>
	<div class="col-xs-10 col-md-10">
		<c:if test="{not empty ${message}}">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">Employee List <span class="badge">${employees.size()}</span> found</div>
			<div class="panel-body">
				<c:url var="EmployeeUrl" value="/employee" />
				<table class="table table-bordered table-hover table-responsive">
					<thead>
						<tr>
							<td />
							<td>Full Name</td>
							<td>Employee ID</td>
							<td>Phone</td>
							<td>Email</td>
							<td>State</td>
							<td>Street</td>
							<td>ZIP</td>
							<td>View Employee</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="employee">
							<tr>
								<td>
									<ul class="nav navbar-nav">
										<li><a href="${context}employee/edit/${employee.id}" title="edit"><span class="glyphicon glyphicon-pencil"></span></a></li>
										<li><a href="${context}employee/remove/${employee.id}" title="delete"><span class="glyphicon glyphicon-remove"></span></a></li>
									</ul>
								</td>
								<td>${employee.fullName}</td>
								<td>${employee.employeeId}</td>
								<td>${employee.phone}</td>
								<td>${employee.email}</td>
								<td>${employee.address.state}</td>
								<td>${employee.address.street}</td>
								<td>${employee.address.zip}</td>
								
								<td>
									<a href="info/${employee.id}">View Employee</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="9" class="text-center info"><!-- pagination code --></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<div class="col-xs-1  col-md-1"></div>
</div>
