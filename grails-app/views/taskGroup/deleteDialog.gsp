<%@ page import="com.honeydothis.TaskGroup" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Delete Confirmation</title>
</head>

<body>
<div data-role="header" data-theme="b" data-position="inline">
  <h1>Delete Confirmation</h1>
</div>

<div data-role="content" data-theme="b">
  <h3>Delete ${fieldValue(bean: taskGroupInstance, field: "name")}?</h3>
  <g:form method="post">
    <div data-inline="true">
      <g:actionSubmit action="delete" value="Yes" data-role="button" data-theme="b"/>
      <g:link action="list" data-role="button" data-theme="c">No</g:link>
      <g:hiddenField name="id" value="${taskGroupInstance.id}"/>
    </div>
  </g:form>
</div>
</body>
</html>