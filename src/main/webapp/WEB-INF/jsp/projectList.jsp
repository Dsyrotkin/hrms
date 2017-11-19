<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
		<div class="panel panel-default">
			<div class="panel-heading">Project List</div>
			<div class="panel-body">
				<c:url var="loginUrl" value="/login" />
				<table class="table">
					<thead>
						<tr>
							<td>Name</td>
							<td>Description</td>
							<td>StartDate</td>
							<td>EndDate</td>
							<td>Department</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${projects}" var="project">
							<tr>
								<td>${project.name}</td>
								<td>${project.description}</td>
								<td>${project.startDate}</td>
								<td>${project.endDate}</td>
								<td>${project.department.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-xs-2  col-md-2"></div>
</div>
