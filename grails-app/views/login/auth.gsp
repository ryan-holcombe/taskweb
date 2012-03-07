<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Login</title>
</head>

<body>
  <div data-role="header" data-position="fixed" data-theme="b">
      <h1>Login</h1>
  </div>

  <div data-role="content" data-inset="true">
    <g:if test="${flash.message}">
      <h3>${flash.message}</h3>
    </g:if>

    <form action="${postUrl}" data-ajax="false" method="post" autocomplete="off">
      <label for="username">Email:</label>
      <input type="text" name="j_username" id="username"/>

      <label for="password">Password:</label>
      <input type="password" name="j_password" id="password"/>

      <label for="remember_me">Remember me</label>
      <input type="checkbox" name="${rememberMeParameter}" id="remember_me" <g:if test="${hasCookie}">checked="checked"</g:if>/>

      <input type="hidden" name="spring-security-redirect" value="/taskGroup/list"/>

      <button type="submit" data-inline="true" data-theme="b">Login</button>
    </form>
    <hr />
    <h3>Don't have a login? <g:link controller="user" action="create">Register</g:link></h3>
  </div>
</body>
</html>
