<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="context" value="/"/>
<spring:url var="JS" value="/resources/js"/>
<script type="text/javascript" src="${JS}/image-upload.js"></script>
<div class="row">
	<div class="col-xs-3 col-md-3"></div>
	<div class="col-xs-6 col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">Employee Registration</div>
			<div class="panel-body">
				<c:url var="EmployeeUrl" value="/employee" />
				<form:form modelAttribute="fileUploadHandler" enctype="multipart/form-data">
					Select photo: <input type="file" name="file" id="photo" />
					<div style="width: 200px; height: 300px;">
						<img id="chosenImage" src="#" alt="" style="max-width: 200px; max-height: 300px;"/>
					</div>
					<div class="form-group text-right">
						<input type="submit" class="btn btn-primary" name="_eventId_contacts" value="Next" />
						<button id="btnCancel" class="btn btn-danger" name="_eventId_back">Return</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="col-xs-3  col-md-3"></div>
</div>