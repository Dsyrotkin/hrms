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

				<form:form modelAttribute="dept" method="post" action="searchDept" id="deptForm">

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
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty depts}">
								<tr>
									<td colspan="8"><spring:message code="GenNO_RECORDS" /></td>
								</tr>
							</c:if>
							<c:if test="${not empty depts}">

								<c:forEach items="${depts}" var="deptBean">
									<tr class="">
										<td>${deptBean.id}</td>
										<td>${deptBean.name}</td>
										<td>${deptBean.description}</td>
										<td></td>

									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>



					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" value="Search" /> <input
							type="submit" class="btn btn-primary" value="Add New" />
						<form:button />

					</div>

					<script type="text/javascript">
					
						function changeAction(url)
						{
							document.getElementById("deptForm").action = 'searchDept';
					
							//document.this_form.action = "http://google.com";
						}
				
					</script>

						<input type="submit"  value="Add New"	onClick="changeAction('addNewDept')"/>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>
