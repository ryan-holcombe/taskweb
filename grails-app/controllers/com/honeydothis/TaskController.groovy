package com.honeydothis

import com.honeydothis.json.JsonTask
import com.honeydothis.json.JsonTaskGroup
import grails.converters.JSON

class TaskController
{

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [taskInstanceList: Task.findAll("from Task task where task.taskGroup.id = ${params.taskGroupId}"), taskInstanceTotal: Task.count(),
    taskGroupName: TaskGroup.findById(params.taskGroupId)?.name,
    taskGroupId: params.taskGroupId]
  }

  def create = {
    def taskInstance = new Task()
    taskInstance.properties = params
    return [taskInstance: taskInstance,
    taskGroupName: TaskGroup.findById(params.taskGroupId)?.name,
    taskGroupId: params.taskGroupId]
  }

  def save = {
    params.taskGroup = TaskGroup.findById(params.taskGroupId)
    def taskInstance = new Task(params)
    if (taskInstance.save(flush: true))
    {
      flash.message = "${message(code: 'default.created.message', args: [taskInstance.name])}"
      redirect(action: "create", params: [taskGroupId: params.taskGroupId])
    } else
    {
        flash.message = "Task cannot be blank";
      redirect(action: "create", model: [taskInstance: taskInstance], params: [taskGroupId: params.taskGroupId])
    }
  }

  def show = {
    def taskInstance = Task.get(params.id)
    if (!taskInstance)
    {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
      redirect(action: "list")
    } else
    {
      [taskInstance: taskInstance]
    }
  }

  def edit = {
    def taskInstance = Task.get(params.id)
    if (!taskInstance)
    {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
      redirect(action: "list")
    } else
    {
      return [taskInstance: taskInstance]
    }
  }

  def update = {
    def taskInstance = Task.get(params.id)
    if (taskInstance)
    {
      if (params.version)
      {
        def version = params.version.toLong()
        if (taskInstance.version > version)
        {

          taskInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'task.label', default: 'Task')] as Object[], "Another user has updated this Task while you were editing")
          render(view: "edit", model: [taskInstance: taskInstance])
          return
        }
      }
      taskInstance.properties = params
      if (!taskInstance.hasErrors() && taskInstance.save(flush: true))
      {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'task.label', default: 'Task'), taskInstance.id])}"
        redirect(action: "show", id: taskInstance.id)
      } else
      {
        render(view: "edit", model: [taskInstance: taskInstance])
      }
    } else
    {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def taskInstance = Task.get(params.id)
    if (taskInstance)
    {
      try
      {
        taskInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e)
      {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    } else
    {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])}"
      redirect(action: "list")
    }
  }

  def jsonList = {
    def login = Login.findByUsername(params.login)
    if (login)
    {
      def all = TaskGroup.findAllByLogin(login)

      Set<JsonTaskGroup> tasks = [];
      all.each() {
        JsonTaskGroup taskGroup = new JsonTaskGroup(it.id, it.name)
        it.tasks.each() {
          JsonTask task = new JsonTask(it.id, it.name)
          taskGroup.tasks.add(task);
        }
        tasks.add(taskGroup)
      }

      render tasks as JSON
    } else
    {
      render(status: 404)
    }
  }
}
