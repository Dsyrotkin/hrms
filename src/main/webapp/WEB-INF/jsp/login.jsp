<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="row">
		<div class="col-xs-3 col-md-3"></div>
		<div class="col-xs-6 col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">Login</div>
				<div class="panel-body">
					<form:form modelAttribute="credentials" action="login" method="POST">
					<div class="form-group">
					    <label for="username">Username</label>
					    <form:input class="form-control" id="username"  path="username"/>
					</div>
					<div class="form-group">
					    <label for="password">Password</label>
					    <form:input class="form-control" id="password"  path="password"/>
					</div>
					<div class="form-group text-right">
					    <input type="submit" class="btn btn-primary" value="Submit"/>
					</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-xs-3  col-md-3"></div>
	</div>
