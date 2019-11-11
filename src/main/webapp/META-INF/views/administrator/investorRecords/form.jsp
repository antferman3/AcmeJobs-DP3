
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="true">
	<acme:form-textbox code="administrator.investorRecords.form.label.name" path="name"/> 
	<acme:form-textbox code="administrator.investorRecords.form.label.sector" path="sector"/>
	<acme:form-money code="administrator.investorRecords.form.label.investingStatements" path = "investingStatements"/>
	<acme:form-double code="administrator.investorRecords.form.label.ratings" path="ratings"/>
	
	<acme:form-submit test="${command=='show' }" code="administrator.investorRecords.form.button.update"
		action="/administrator/investorRecords/update"/>
	<acme:form-submit test="${command=='show' }" code="administrator.investorRecords.form.button.delete"
		action="/administrator/investorRecords/delete"/>
	<acme:form-submit test="${command=='create' }" code="administrator.investorRecords.form.button.create"
		action="/administrator/investorRecords/create"/>
	<acme:form-submit test="${command=='update' }" code="administrator.investorRecords.form.button.update"
		action="/administrator/investorRecords/update"/>
	<acme:form-submit test="${command=='delete' }" code="administrator.investorRecords.form.button.delete"
		action="/administrator/investorRecords/delete"/>
	
	<acme:form-return code="administrator.investorRecords.form.button.return"/> 
	
</acme:form>