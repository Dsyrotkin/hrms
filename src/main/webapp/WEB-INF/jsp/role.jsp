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
					<li class="active"><a data-toggle="tab" href="#admins">ADMINS</a></li>
					<li><a data-toggle="tab" href="#users">USERS</a></li>
				</ul>

				<div class="tab-content">
					<div id="admins" class="tab-pane fade in active">
						<h3>ADMINS</h3>
						<div class="list-group">
							<a href="#" class="list-group-item active"> Cras justo odio </a>
							<a href="#" class="list-group-item">Dapibus ac facilisis in</a> <a
								href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
								class="list-group-item">Porta ac consectetur ac</a> <a href="#"
								class="list-group-item">Vestibulum at eros</a>
						</div>
					</div>
					<div id="users" class="tab-pane fade">
						<h3>ADMINS</h3>
						<div class="list-group">
							<a href="#" class="list-group-item active"> Cras justo odio </a>
							<a href="#" class="list-group-item">Dapibus ac facilisis in</a> <a
								href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
								class="list-group-item">Porta ac consectetur ac</a> <a href="#"
								class="list-group-item">Vestibulum at eros</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>