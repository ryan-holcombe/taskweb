dataSource {
  pooled = true
  driverClassName = "org.hsqldb.jdbcDriver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      driverClassName = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost/honeydothis"
      username = "honeydothis"
      password = "grails"
    }
  }
  test {
    dataSource {
      dbCreate = "update"
      url = "jdbc:hsqldb:mem:testDb"
    }
  }
  production {
    dataSource {
      dbCreate = "update"
      driverClassName = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost/honeydothis"
      username = "honeydothis"
      password = "grails"
      //run the evictor every 30 minutes and evict any connections older than 30 minutes.
      minEvictableIdleTimeMillis = 1800000
      timeBetweenEvictionRunsMillis = 1800000
      numTestsPerEvictionRun = 3
      //test the connection while its idle, before borrow and return it
      testOnBorrow = true
      testWhileIdle = true
      testOnReturn = true
      validationQuery = "SELECT 1"
    }
  }
}
