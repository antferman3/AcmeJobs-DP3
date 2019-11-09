
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="true">
	<acme:form-textbox code="administrator.spam.form.label.spamWords" path="spamWords"/> 
	<acme:form-moment code="administrator.spam.form.label.umbral" path="umbral"/>
	
	
</acme:form>