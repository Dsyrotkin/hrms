<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Employee Form</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/main.css"/>">
</head>
<body>


	<form:form commandName="employee">
		<p>Test</p>
		
				
		<spring:message code="firstName" text="Not Found"></spring:message>

		<spring:url value="?language=ar" var="url_ar"></spring:url>
		<spring:url value="?language=en" var="url_en"></spring:url>

		<a href="${url_ar}">Arabic</a>
		<a href="${url_en}">English</a>
		
	</form:form>

</body>
</html>
