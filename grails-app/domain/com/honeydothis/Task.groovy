package com.honeydothis

class Task
{
  TaskGroup taskGroup
  String name

  static constraints = {
    name(blank: false, maxLength: 32)
    taskGroup(nullable: false)
  }

  static belongsTo = [taskGroup: TaskGroup]
}
