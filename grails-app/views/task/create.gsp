<%@ page import="com.honeydothis.Task" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="new task in ${taskGroupName}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div data-role="header" data-nobackbtn="true" data-position="fixed" data-theme="b">
    <g:link action="list" params="[taskGroupId:taskGroupId]" data-icon="grid" data-direction="reverse">View</g:link>
    <a href="${createLink(uri: '/')}" data-icon="home" data-iconpos="notext" data-direction="reverse"
       class="ui-btn-right jqm-home">Home</a>

    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
</div>

<div data-role="content">
    <g:if test="${flash.message}">
        <h3>${flash.message}</h3>
    </g:if>
    <g:hasErrors bean="${taskInstance}">
        <div class="errors">
            <g:renderErrors bean="${taskInstance}" as="list"/>
        </div>
    </g:hasErrors>
    <g:form action="save" params="[taskGroupId: taskGroupId">
        <div data-role="fieldcontain">
            <label for="name"><g:message code="task.title.label" default="New Task:"/></label>
            <input type="text" name="name" id="name" value="${taskInstance?.name}"/>
        </div>
        <g:hiddenField name="description" value=""/>
        <g:hiddenField name="taskGroupId" value="${taskGroupId}"/>
        <g:submitButton name="create" data-theme="a" data-role="button" value="Create"/>
    </g:form>
</div>
</body>
</html>