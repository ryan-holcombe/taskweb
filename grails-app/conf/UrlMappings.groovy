class UrlMappings
{

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }
    "/login/$action?"(controller: "login")
    "/logout/$action?"(controller: "logout")
    "/"(controller: "login", action: "index" )
    "500"(view: '/error')

    "/tasks/$login"(controller: "task", action: "jsonList")
  }
}
