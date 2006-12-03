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
	<title>Notes</title>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<script type="text/javascript" src="js/global.js"/>
	</head>
	<body>
	<h1>Selected Notes</h1>
	<h:dataTable var="row" value="#{notes.rows}" rowClasses="odd,even"
		columnClasses="odd,even">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Id" />
			</f:facet>
			<h:outputText value="#{row.id}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Category" />
			</f:facet>
			<h:outputText value="#{row.category}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Body" />
			</f:facet>
			<h:outputText value="#{row.body}" onmouseover="hilite(this.parentNode.parentNode)" onmouseout="unhilite(this.parentNode.parentNode)"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Created By" />
			</f:facet>
			<h:outputText value="#{row.creator}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Creation Timestamp" />
			</f:facet>
			<h:outputText value="#{row.createTimestamp}" />
		</h:column>
	</h:dataTable>
	</body>
	</html>
</f:view>
