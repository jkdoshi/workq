<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%-- all JSF components must be inside a "view" --%>
<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello Java Server Faces</title>
	</head>
	<body>
	<h1>Hello Java Server Faces</h1>
	<h2>Date: <%=new java.util.Date()%></h2>
	<h:outputText
		value="You are logged in as user: #{facesContext.externalContext.request.remoteUser}" />
	<hr />
	<%-- all input and command components must be inside a "form" --%>
	<h:form id="frmHello">
		<h:commandLink value="Go to Notes" action="#{notes.fetchRows}" />
	</h:form>
	<hr />
	<h:messages showDetail="true" showSummary="false" />
	</body>
	</html>
</f:view>
