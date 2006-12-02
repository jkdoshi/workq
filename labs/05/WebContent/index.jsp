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
	<%-- all _input_ components must be inside a "form" --%>
	<h:form id="frmHello">
	Please enter your name:
		<%-- input text box component to enter updates model state --%>
		<h:inputText id="txtName" value="#{hello.name}" />
		<%-- command button component to submit --%>
		<h:commandButton id="btnSubmit" value="Say Hello!" action="#{hello.upcase}" />
	</h:form>
	<hr />
	<%-- output text component to show model state --%>
	<p>Hello "<h:outputText value="#{hello.name}" />"!</p>
	<p>Hello CAP "<h:outputText value="#{hello.capName}" />"!</p>
	</body>
	</html>
</f:view>
