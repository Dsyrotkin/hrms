<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:url var="image" value="/resources/img" />
<c:url var="context" value="/" />
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${context}"><img alt="Octagon HRMS"
				src="${image}/fulllogo-22.png" /></a>
		</div>

		<!-- if user is logged in, show below -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<security:authorize access="hasRole('ROLE_ADMIN')">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><spring:message code="Nav.Employee"/> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<spring:url value="/employee/list" />"><spring:message code="Nav.ListEmployee"/></a></li>
						<li>
							<a href="<spring:url value="/employee/new" />">
							<spring:message code="Nav.AddEmployee"/></a></li>
						
						<!-- <li role="separator" class="divider"></li> -->						
					</ul>
				</li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><spring:message code="Nav.Project"/> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${context}project/list"><spring:message code="Nav.ListProjects"/></a></li>
						<li><a href="${context}project/new"><spring:message code="Nav.AddProject"/></a></li>
						
						<!-- <li role="separator" class="divider"></li> -->						
					</ul>
				</li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><spring:message code="Nav.Department"/> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${context}manageDept"><spring:message code="Nav.ListDepartments"/></a></li>
						<li><a href="${context}addNewDept"><spring:message code="Nav.AddDepartment"/></a></li>
						
						<!-- <li role="separator" class="divider"></li> -->						
					</ul>
				</li>

				</security:authorize>
			
				<security:authorize
					access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
				


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><spring:message code="Nav.Admin"/> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${context}admin/role"><spring:message code="addRole.page.title" /></a></li>						
						<!-- <li role="separator" class="divider"></li> -->						
					</ul>
				</li>

				</security:authorize>

			</ul>
			<spring:url value="?language=ar" var="url_ar"></spring:url>
			<spring:url value="?language=en" var="url_en"></spring:url>
			<spring:url value="?language=tr" var="url_tr"></spring:url>
			<spring:url value="?language=ua" var="url_ua"></spring:url>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAuthenticated()">
					<li class="active"><a href="#"><spring:message code="Nav.Welcome"/> ${user}</a></li>
				</security:authorize>

				<li><security:authorize access="!isAuthenticated()">
						<a href="${context}login"><spring:message code="Nav.Login"/></a>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<a href="${context}logout"><spring:message code="Nav.Logout"/></a>
					</security:authorize>
				</li>
				

					

				<li class="dropdown"><a href="#" class="dropdown-toggle"

					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <img alt="Language"
						src="${image}/earth-22.png" /> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${url_ar}">عربي</a></li>
						<li><a href="${url_en}">English</a></li>
						<li><a href="${url_tr}">Turkish</a></li>
						<li><a href="${url_ua}">Ukraine</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
