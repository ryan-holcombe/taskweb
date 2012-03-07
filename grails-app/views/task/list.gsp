<%@ page import="com.honeydothis.Task" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <g:set var="entityName" value="${taskGroupName}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div data-role="header" data-nobackbtn="true" data-position="fixed" data-theme="b">
  <g:link action="create" params="[taskGroupId:taskGroupId]" data-icon="plus" data-iconpos="notext">Create New Task</g:link>
  <a href="${createLink(uri: '/')}" data-icon="home" data-iconpos="notext">Home</a>
  <h1><g:message code="default.list.label" args="[entityName]"/></h1>
</div>

<div data-role="content">
  <div data-role="fieldcontain">
    <fieldset data-role="controlgroup">
      <g:each in="${taskInstanceList}" status="i" var="task">
        <input type="checkbox" name="checkBox${i}" id="checkBox${i}" class="custom"/>
        <label for="checkBox${i}">${fieldValue(bean: task, field: "name")}</label>
      </g:each>
    </fieldset>
  </div>
</div>
</body>
</html>