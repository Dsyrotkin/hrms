<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="context" value="/"/>
<div class="row">
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
		<c:if test="{not empty ${message}}">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">Project List <span class="badge">${projects.size()}</span> found</div>
			<div class="panel-body">
				<c:url var="loginUrl" value="/login" />
				<table class="table table-bordered table-hover table-responsive">
					<thead>
						<tr>
							<td>Action</td>
							<td>Name</td>
							<td>Description</td>
							<td>Start Date</td>
							<td>End Date</td>
							<td>Department</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${projects}" var="project">
							<tr>
								<td>
									<ul class="nav navbar-nav">
										<li><a href="${context}project/edit/${project.id}" title="edit"><span class="glyphicon glyphicon-pencil"/></a></li>
										<li><a href="${context}project/remove/${project.id}" title="delete"><span class="glyphicon glyphicon-remove"/></a></li>
									</ul>
								</td>
								<td>${project.name}</td>
								<td>${project.description}</td>
								<td><fmt:formatDate type = "date" value = "${project.startDate}" /></td>
								<td><fmt:formatDate type = "date" value = "${project.endDate}" /></td>
								
								<td>
									<c:if test="${not empty project.department.name}">
										<a href="department/${project.department.id}">${project.department.name}</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" class="text-center info"><!-- pagination code --></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<div class="col-xs-2  col-md-2"></div>
</div>
