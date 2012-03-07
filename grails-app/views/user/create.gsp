<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Register</title>
</head>

<body>
  <div data-role="header" data-position="fixed" data-theme="b" data-dir="reverse">
    <a href="#" data-icon="arrow-l" data-rel="back">Back</a>
    <h1>Register</h1>
  </div>

  <div data-role="content" data-inset="true">
    <g:if test='${flash.message}'>
      <h3>${flash.message}</h3>
    </g:if>
    <g:hasErrors bean="${userInstance}">
        <div class="errors">
            <g:renderErrors bean="${userInstance}" as="list"/>
        </div>
    </g:hasErrors>

    <form controller="user" action="save" method="post" autocomplete="off">
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName" id="firstName" value="${userInstance?.firstName}"/>

      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName" id="lastName" value="${userInstance?.lastName}"/>

      <label for="username">Email:</label>
      <input type="username" name="username" id="username" value="${userInstance?.username}"/>

      <label for="password">Password:</label>
      <input type="password" name="password" id="password"/>

      <label for="passwordConfirm">Confirm:</label>
      <input type="password" name="passwordConfirm" id="passwordConfirm"/>
      
      <g:hiddenField name="enabled" value="true"/>

      <g:submitButton name="create" data-theme="a" data-role="button" value="Register"/>
    </form>
  </div>
</body>
</html>