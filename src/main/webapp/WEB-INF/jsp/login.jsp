<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Login</div>
			<div class="panel-body">
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="form-group">
						<label for="username">Username</label> <input class="form-control"
							id="username" name="username" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password" class="form-control"
							id="password" name="password" />
					</div>
				 <div class="col-sm-offset-1">
				            <label class="checkbox">
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="Submit" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
