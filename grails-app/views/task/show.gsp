
<%@ page import="com.honeydothis.Task" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="task.id.label" default="Id" /></td>

                            <td valign="top" class="value">${fieldValue(bean: taskInstance, field: "id")}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="task.title.label" default="Title" /></td>

                            <td valign="top" class="value">${fieldValue(bean: taskInstance, field: "name")}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="task.description.label" default="Description" /></td>

                            <td valign="top" class="value">${fieldValue(bean: taskInstance, field: "description")}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="task.assignedTo.label" default="Assigned To" /></td>

                            <td valign="top" class="value"><g:link controller="user" action="show" id="${taskInstance?.assignedTo?.id}">${taskInstance?.assignedTo?.encodeAsHTML()}</g:link></td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="task.taskGroup.label" default="Task Group" /></td>

                            <td valign="top" class="value"><g:link controller="taskGroup" action="show" id="${taskInstance?.taskGroup?.id}">${taskInstance?.taskGroup?.encodeAsHTML()}</g:link></td>

                        </tr>

                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${taskInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
