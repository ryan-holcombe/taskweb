<%@ page import="com.honeydothis.TaskGroup" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Create New Task Group</title>

  <script type="text/javascript">
    $(document).ready(function()
    {
      $("#name").focus();
    });
  </script>
</head>

<body>
<div data-role="header" ddata-position="fixed" data-theme="b">
  <g:link action="list" params="[taskGroupId:taskGroupId]" data-icon="grid" data-direction="reverse">View</g:link>
  <a href="${createLink(uri: '/')}" data-icon="home" data-iconpos="notext" data-direction="reverse"
     class="ui-btn-right jqm-home">Home</a>
  <h1>Create New Task Group</h1>
</div>

<div data-role="content">
  <g:if test="${flash.message}">
    <h3>${flash.message}</h3>
  </g:if>
  <g:hasErrors bean="${taskGroupInstance}">
    <div class="errors">
      <g:renderErrors bean="${taskGroupInstance}" as="list"/>
    </div>
  </g:hasErrors>
  <g:form action="save">
    <div data-role="fieldcontain">
      <label for="name">New Task Group:</label>
      <input type="text" name="name" id="name" value="${taskGroupInstance?.name}"/>
    </div>
    <g:submitButton name="create" data-theme="a" data-role="button" value="Create"/>
  </g:form>
</div>
</body>
</html>
