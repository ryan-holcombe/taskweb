package com.honeydothis

class TaskGroup
{
  String name
  User user
  Set<Task> tasks

  static hasMany = [tasks: Task]

  static constraints = {
    name(blank: false)
    user(nullable: false)
  }
}
