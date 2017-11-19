<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="context" value="/" />
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">ROLES</div>
			<div class="panel-body">
				<c:url var="ProjectUrl" value="/project" />
				<ul class="nav nav-tabs">
					<c:forEach var="role" items="${roles}">
						<li><a data-toggle="tab" href="#tab_${role.name}">${role.name}</a></li>
					</c:forEach>
					<li><a data-toggle="tab" href="#">+</a></li>
					<!-- 	<li class="active"><a data-toggle="tab" href="#admins">ADMINS</a></li>
					<li><a data-toggle="tab" href="#users">USERS</a></li> -->
				</ul>

				<c:forEach var="role" items="${roles}">
					<div class="tab-content">
						<div id="tab_${role.name}" class="tab-pane fade in">
							<h3>${role.name}</h3>
							<div style = "padding: 5px">
								<div class="input-group">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button" onclick="addRole(${role.id},'${role.name}')">Add</button>
									</span> <input id="input_${role.name}" type="text" class="form-control" placeholder ="Username">
								</div>
								<div id="alert_${role.name}" style="display: none" class ="alert alert-danger" role="alert">Username doesn't exist</div>
								<div id="success_${role.name}" style="display: none" class ="alert alert-success" role="alert">Role has been successfully given the user.</div>
							</div>
							<div id="list_${role.name}" class="list-group">
								<a href="#" class="list-group-item active"> Cras justo odio
								</a> <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
							</div>
						</div>
				</c:forEach>

				<!-- 					<div id="users" class="tab-pane fade">
						<h3>ADMINS</h3>
						<div class="list-group">
							<a href="#" class="list-group-item active"> Cras justo odio </a>
							<a href="#" class="list-group-item">Dapibus ac facilisis in</a> <a
								href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
								class="list-group-item">Porta ac consectetur ac</a> <a href="#"
								class="list-group-item">Vestibulum at eros</a>
						</div>
					</div> -->
			</div>
		</div>
	</div>
</div>
<div class="col-xs-3  col-md-3"></div>
</div>