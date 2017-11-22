<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="row">
		<div class="col-xs-3 col-md-3"></div>
		<div class="col-xs-6 col-md-6">
			<div class="alert alert-danger"><spring:message code="${msg}"></spring:message></div>
		</div>
		<div class="col-xs-3 col-md-3"></div>
	</div>
