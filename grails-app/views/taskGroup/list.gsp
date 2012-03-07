<%@ page import="com.honeydothis.TaskGroup" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Task Groups</title>
</head>

<body>
<div data-role="header" data-nobackbtn="true" data-position="fixed" data-theme="b">
  <g:link action="create" data-icon="plus" data-iconpos="notext">Create New Task Group</g:link>
  <h1>Task Groups</h1>
</div>

<div data-role="content">
  <g:if test="${flash.message}">
    <h3>${flash.message}</h3>
  </g:if>

  <ul data-role="listview" data-inset="true" data-split-theme="b" data-split-icon="delete">
    <g:each in="${taskGroupInstanceList}" status="i" var="taskGroup">
      <li data-icon="arrow-r">
        <g:link controller="task" action="list" params="[taskGroupId:taskGroup.id]">${fieldValue(bean: taskGroup, field: "name")}</g:link>
        <g:link action="deleteDialog" id="${taskGroup.id}" data-role="button" data-inline="true" data-rel="dialog" data-transition="pop"/>
      </li>
    </g:each>
  </ul>
</div>
</body>
</html>
